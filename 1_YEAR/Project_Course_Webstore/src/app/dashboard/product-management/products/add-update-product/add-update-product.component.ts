import { Component, Input, OnChanges } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductManagementService } from '../../product-management.service';
import { ModalService } from 'src/app/shared/components/modal/modal.service';
import { MessagesService } from 'src/app/shared/components/messages/messages.service';
import { Observable } from 'rxjs';
import {
  AngularFireUploadTask,
  AngularFireStorage,
} from '@angular/fire/storage';

interface Image {
  imagePath: string;
  imageUrl: string;
}

interface FileDoc {
  fileName: string;
  filePath: string;
  fileUrl: string;
}

export interface Product {
  categoryId: string;
  description: string;
  id: string;
  title: string;
  coverImage: Image;
  images: Image[];
  file: FileDoc;
  price: number;
  discountPrice: number;
  quantity: number;
  numRatings: number;
  avgRating: number;
  searchName: string;
  url: string;
  isDayDeal: boolean;
}

interface SelectedBike {
  id: number;
  imageUrl: string;
  imagePath: string;
}

@Component({
  selector: 'add-update-product',
  templateUrl: './add-update-product.component.html',
  styleUrls: ['./add-update-product.component.css'],
})
export class AddUpdateProductComponent implements OnChanges {
  @Input() type: string;
  @Input() product: any;
  @Input() category: any;

  productObject: Product = {
    id: '',
    categoryId: '',
    title: '',
    description: '',
    coverImage: {
      imagePath: '',
      imageUrl: '',
    },
    images: [],
    file: {
      fileName: '',
      filePath: '',
      fileUrl: '',
    },
    price: 0,
    discountPrice: 0,
    quantity: 0,
    numRatings: 0,
    avgRating: 0,
    searchName: '',
    url: '',
    isDayDeal: false,
  };

  addUpdateForm: FormGroup = null;
  files: File[] = [];
  selectedBike: SelectedBike = { id: 0, imageUrl: '', imagePath: '' };
  isWarning: boolean = false;
  warningMessage: string = '';
  isUploading = false;
  isLoading = false;
  isDeleting = false;
  method: any = {
    past: '',
    present: '',
  };
  task: AngularFireUploadTask;
  uploadProgress$: Observable<number>;

  constructor(
    private formBuilder: FormBuilder,
    private modalService: ModalService,
    private messagesService: MessagesService,
    private productManagementService: ProductManagementService,
    private fireStorage: AngularFireStorage
  ) {}

  ngOnChanges() {
    this.buildEmptyForm();

    if (this.category) {
      this.addUpdateForm.patchValue({ categoryName: this.category.name });
    }

    if (this.type === 'add') {
      this.files = [];
      this.productObject.images = [];
      this.productObject.coverImage.imagePath = '';
      this.productObject.coverImage.imageUrl = '';
      this.productObject.file.fileName = '';
      this.productObject.file.filePath = '';
      this.productObject.file.fileUrl = '';
    }

    if (this.type === 'update') {
      this.buildFormWithData();
    }

    if (this.productObject.images.length > 0) {
      this.selectedBike.imageUrl = this.productObject.images[0].imageUrl;
      this.selectedBike.imagePath = this.productObject.images[0].imagePath;
    }
  }

  get isSuccess(): boolean {
    return this.messagesService.isSuccess;
  }

  get isFail(): boolean {
    return this.messagesService.isFail;
  }

  addImageToArray(object: any): void {
    this.productObject.images.push(object);
    this.selectedBike.id = 0;
    this.selectedBike.imageUrl = this.productObject.images[0].imageUrl;
    this.selectedBike.imagePath = this.productObject.images[0].imagePath;
    this.productObject.coverImage.imageUrl = this.productObject.images[0].imageUrl;
    this.productObject.coverImage.imagePath = this.productObject.images[0].imagePath;
  }

  buildEmptyForm(): void {
    this.addUpdateForm = this.formBuilder.group({
      categoryName: [{ value: '', disabled: true }],
      title: ['', Validators.required],
      description: ['', Validators.required],
      price: ['', Validators.required],
      discountPrice: ['', Validators.required],
      quantity: ['', Validators.required],
    });
  }

  buildFormWithData(): void {
    if (this.type === 'update') {
      if (this.product.images) {
        this.productObject.images = this.product.images;
        this.productObject.coverImage = this.product.coverImage;
      }
      if (this.product.file) {
        this.productObject.file = this.product.file;
      }
      this.addUpdateForm.patchValue({ title: this.product.title });
      this.addUpdateForm.patchValue({ description: this.product.description });
      this.addUpdateForm.patchValue({ price: this.product.price });
      this.addUpdateForm.patchValue({
        discountPrice: this.product.discountPrice,
      });
      this.addUpdateForm.patchValue({ quantity: this.product.quantity });
    }
  }

  closeModal(): void {
    this.addUpdateForm.reset();
    this.addUpdateForm.patchValue({ categoryName: this.category.name });
    this.files = [];
    this.productObject.images = [];
    this.messagesService.isFail = false;
    this.messagesService.isSuccess = false;
    this.buildFormWithData();
    this.modalService.toggle();
  }

  updateProduct(): void {
    this.isLoading = true;
    this.productObject.avgRating = this.product.avgRating;
    this.productObject.numRatings = this.product.numRatings;
    this.productObject.categoryId = this.product.categoryId;
    this.productObject.id = this.product.id;
    this.productObject.isDayDeal = this.product.isDayDeal;

    this.productObject.title = this.addUpdateForm.get('title').value;
    this.productObject.searchName = this.productObject.title.toLowerCase();
    this.productObject.url = this.productObject.title
      .replace(/\s+/g, '-')
      .toLowerCase();
    this.productObject.description = this.addUpdateForm.get(
      'description'
    ).value;
    this.productObject.price = this.addUpdateForm.get('price').value;
    this.productObject.discountPrice = this.addUpdateForm.get(
      'discountPrice'
    ).value;
    this.productObject.quantity = this.addUpdateForm.get('quantity').value;

    this.method.past = 'Successfully updated product!';
    this.method.present = 'Could not update product.';

    this.productManagementService.updateProduct(this.productObject).then(
      () => {
        this.isLoading = false;
        this.messagesService.toggleSuccess();
      },
      () => {
        this.isLoading = false;
        this.messagesService.toggleFail();
      }
    );
  }

  deleteProduct(): void {
    this.isDeleting = true;

    this.method.past = 'Successfully deleted product!';
    this.method.present = 'Could not delete product.';

    this.productManagementService.deleteProduct(this.product.id).then(
      () => {
        this.isDeleting = false;
        this.messagesService.toggleSuccess();
      },
      () => {
        this.isDeleting = false;
        this.messagesService.toggleFail();
      }
    );
  }

  createProduct(): void {
    this.isLoading = true;

    this.method.past = 'Successfully created product!';
    this.method.present = 'Could not create product.';

    this.productObject.categoryId = this.category.id;
    this.productObject.title = this.addUpdateForm.get('title').value;
    this.productObject.searchName = this.productObject.title.toLowerCase();
    this.productObject.url = this.productObject.title
      .replace(/\s+/g, '-')
      .toLowerCase();
    this.productObject.description = this.addUpdateForm.get(
      'description'
    ).value;
    this.productObject.price = this.addUpdateForm.get('price').value;
    this.productObject.discountPrice = this.addUpdateForm.get(
      'discountPrice'
    ).value;
    this.productObject.quantity = this.addUpdateForm.get('quantity').value;

    this.productManagementService.createProduct(this.productObject).then(
      () => {
        this.isLoading = false;
        this.messagesService.toggleSuccess();
      },
      () => {
        this.isLoading = false;
        this.messagesService.toggleFail();
      }
    );
  }

  onSubmit(type: string): void {
    if (type === 'add') {
      this.createProduct();
    }
    if (type === 'update') {
      this.updateProduct();
    }
    if (type === 'delete') {
      this.deleteProduct();
    }
  }

  toggleWarning(allowedNumber: number): void {
    if (allowedNumber === 0) {
      this.warningMessage = `You cannot upload more images.`;
    } else {
      this.warningMessage = `You can only upload ${allowedNumber} more ${
        allowedNumber === 1 ? 'photo' : 'photos'
      }.`;
    }
    this.isWarning = !this.isWarning;
  }

  changeSelectedBike(imageObject: any, id: number): void {
    this.selectedBike.id = id;
    this.selectedBike.imageUrl = imageObject.imageUrl;
    this.selectedBike.imagePath = imageObject.imagePath;
  }

  changeSelectedBikeData(): void {
    if (this.selectedBike.imageUrl !== this.productObject.coverImage.imageUrl) {
      this.productObject.coverImage.imageUrl = this.selectedBike.imageUrl;
      this.productObject.coverImage.imagePath = this.selectedBike.imagePath;
    }
  }

  deleteImage(): void {
    if (this.selectedBike.imagePath.length < 10) {
      if (
        this.selectedBike.imageUrl === this.productObject.coverImage.imageUrl
      ) {
        this.productObject.coverImage.imageUrl = '';
        this.productObject.coverImage.imagePath = '';
      }
      if (this.productObject.images.length > 0) {
        this.selectedBike.id = 0;
        this.selectedBike.imagePath = this.productObject.images[0].imagePath;
        this.selectedBike.imageUrl = this.productObject.images[0].imageUrl;
        this.productObject.coverImage.imageUrl = this.productObject.images[0].imageUrl;
        this.productObject.coverImage.imagePath = this.productObject.images[0].imagePath;
      } else {
        this.selectedBike.id = null;
        this.selectedBike.imagePath = '';
        this.selectedBike.imageUrl = '';
      }
      this.productObject.images.splice(this.selectedBike.id, 1);
    } else {
      this.productManagementService
        .deleteFile(this.selectedBike.imagePath)
        .then(() => {
          this.productObject.images.splice(this.selectedBike.id, 1);
          if (this.productObject.images.length > 0) {
            if (
              this.selectedBike.imagePath ===
              this.productObject.coverImage.imagePath
            ) {
              this.productObject.coverImage.imagePath = this.productObject.images[0].imagePath;
              this.productObject.coverImage.imageUrl = this.productObject.images[0].imagePath;
            }
            this.selectedBike.id = 0;
            this.selectedBike.imageUrl = this.productObject.images[0].imageUrl;
            this.selectedBike.imagePath = this.productObject.images[0].imagePath;
          } else {
            this.selectedBike.id = null;
            this.selectedBike.imageUrl = '';
            this.selectedBike.imagePath = '';
          }
        });
    }
  }

  uploadAttachmentFile(event: any): void {
    this.isUploading = true;
    const file = event.target.files[0];
    const filePath = `files/${new Date().getTime()}_${file.name}`;
    this.task = this.fireStorage.upload(filePath, file);
    this.uploadProgress$ = this.task.percentageChanges();
    this.task.then(async data => {
      const downloadUrl = await data.ref.getDownloadURL();
      this.productObject.file.fileName = file.name;
      this.productObject.file.filePath = filePath;
      this.productObject.file.fileUrl = downloadUrl;
      this.isUploading = false;
    });
  }

  deleteFileDoc(): void {
    this.productManagementService
      .deleteFile(this.productObject.file.filePath)
      .then(() => {
        this.productObject.file.fileName = '';
        this.productObject.file.filePath = '';
        this.productObject.file.fileUrl = '';
      });
  }

  multiFileUpload(e: any): void {
    const files = e.target.files;
    const currentAmount: number = this.productObject.images.length;
    if (currentAmount + files.length > 4) {
      if (files.length > 4) {
        this.toggleWarning(0);
      } else {
        const diff: number = 4 - currentAmount;
        this.toggleWarning(diff);
      }
    } else {
      for (let i = 0; i < files.length; i++) {
        this.files.push(files.item(i));
      }
    }
  }
}

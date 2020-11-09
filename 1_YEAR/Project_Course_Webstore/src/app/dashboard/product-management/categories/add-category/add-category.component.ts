import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormControl } from '@angular/forms';
import { ProductManagementService } from '../../product-management.service';
import { ModalService } from '../../../../shared/components/modal/modal.service';
import { MessagesService } from 'src/app/shared/components/messages/messages.service';
import { Observable } from 'rxjs';
import { CategoriesService } from '../categories.service';

export interface Category {
  id: string;
  imageUrl: string;
  name: string;
  searchName: string;
  topic: string;
  url: string;
}

@Component({
  selector: 'add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css'],
})
export class AddCategoryComponent implements OnInit {
  isUploading: boolean = false;
  isLoading: boolean = false;
  categoryObject: Category = {
    id: '',
    imageUrl: '',
    name: '',
    searchName: '',
    topic: '',
    url: '',
  };
  addCategoryForm: FormGroup = null;

  constructor(
    private modalService: ModalService,
    private productManagementService: ProductManagementService,
    private categoriesService: CategoriesService,
    private messagesService: MessagesService
  ) {}

  ngOnInit() {
    this.createNewForm();
  }

  get isSuccess(): boolean {
    return this.messagesService.isSuccess;
  }

  get isFail(): boolean {
    return this.messagesService.isFail;
  }

  get uploadProgress(): Observable<number> {
    return this.productManagementService.uploadProgress$;
  }

  get previewImage(): Observable<any> {
    return this.productManagementService.image$;
  }

  get imageDownloadUrl(): Promise<any> {
    return this.productManagementService.task.then(url => {
      this.isUploading = false;
      return url.ref.getDownloadURL();
    });
  }

  get categoryTopic(): any {
    return this.addCategoryForm.get('topic').value;
  }

  get categoryName(): any {
    return this.addCategoryForm.get('name').value;
  }

  get categoryUrl(): any {
    return this.addCategoryForm.get('url').value;
  }

  generateUrl(): void {
    if (this.categoryName !== '') {
      const url = this.categoryName.replace(/\s+/g, '-').toLowerCase();
      this.addCategoryForm.patchValue({ url: url });
    }
  }

  createNewForm(): void {
    this.addCategoryForm = new FormGroup({
      fileUpload: new FormControl(null, Validators.required),
      topic: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      url: new FormControl('', Validators.required),
    });
  }

  uploadFile($event: any): void {
    this.isUploading = true;
    this.productManagementService.uploadFile($event);
  }

  resetState(): void {
    this.productManagementService.image$ = null;
    this.productManagementService.uploadProgress$ = null;
    this.productManagementService.filePath = '';
    this.isUploading = false;
    this.isLoading = false;
    this.createNewForm();
  }

  closeModal(): void {
    this.modalService.toggle();
    if (this.productManagementService.filePath !== '') {
      this.productManagementService.deleteFile(
        this.productManagementService.filePath
      );
    }
    this.messagesService.isFail = false;
    this.messagesService.isSuccess = false;
    this.resetState();
  }

  onSubmit(): void {
    this.isLoading = true;
    this.categoryObject.topic = this.categoryTopic;
    this.categoryObject.name = this.categoryName;
    this.categoryObject.url = this.categoryUrl;
    this.categoryObject.searchName = this.categoryName.toLowerCase();
    this.imageDownloadUrl.then(url => {
      this.categoryObject.imageUrl = url;
      this.categoriesService.createCategory(this.categoryObject).then(
        () => {
          this.isLoading = false;
          this.messagesService.toggleSuccess();
          this.resetState();
        },
        () => {
          this.messagesService.toggleFail();
          this.resetState();
        }
      );
    });
  }
}

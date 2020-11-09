import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'product-detail-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css'],
})
export class GalleryComponent implements OnInit {
  @Input() images: any[];
  @Input() cover: string;
  imageGallery: any[] = [];
  currentImageIndex: number = 0;
  currentImage: string = '';

  constructor() {}

  ngOnInit() {
    if (this.images && this.cover) {
      this.imageGallery.push(this.cover);
      this.images.forEach(image => {
        if (this.imageGallery[0] !== image.imageUrl)
          this.imageGallery.push(image.imageUrl);
      });
      this.currentImage = this.imageGallery[0];
    }
  }

  changeImage(image: string, index: number): void {
    this.currentImage = image;
    this.currentImageIndex = index;
  }
}

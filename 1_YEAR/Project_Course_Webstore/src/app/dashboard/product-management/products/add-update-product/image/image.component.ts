import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {
  AngularFireUploadTask,
  AngularFireStorage,
} from '@angular/fire/storage';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css'],
})
export class ImageComponent implements OnInit {
  @Input() file: any;
  @Output() imageObject = new EventEmitter();
  task: AngularFireUploadTask;
  percentage$: Observable<number>;
  downloadURL;
  object: any = {
    imageUrl: '',
    imagePath: '',
  };

  constructor(private storage: AngularFireStorage) {}

  ngOnInit() {
    this.startUpload();
  }

  startUpload() {
    if (this.file) {
      const filePath = `images/products/${Date.now()}_${this.file.name}`;
      const ref = this.storage.ref(filePath);
      this.task = this.storage.upload(filePath, this.file);
      this.percentage$ = this.task.percentageChanges();
      this.task.then(async data => {
        this.downloadURL = await data.ref.getDownloadURL();
        this.object.imageUrl = this.downloadURL;
        this.object.imagePath = filePath;
        this.imageObject.emit(this.object);
      });
    }
  }
}

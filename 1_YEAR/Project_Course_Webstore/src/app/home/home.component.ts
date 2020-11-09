import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  images: string[] = [
    'https://www.bikester.co.uk/uploads-ng/tx_isimageslider/20190313_BUK_bikes2019_1200x400.jpg',
    'https://www.bikester.co.uk/uploads-ng/tx_isimageslider/20190430_BUK_bike2work_1200x400.jpg',
    'https://www.bikester.co.uk/uploads-ng/tx_isimageslider/20190508_BUK_biketuning_1200x400.jpg',
  ];

  constructor(private title: Title) {
    this.title.setTitle('Startpage | Bikeshop');
  }

  ngOnInit() {}

  get imageSources(): string[] {
    return this.images;
  }
}

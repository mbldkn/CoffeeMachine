import { Component, OnInit, AfterViewInit } from '@angular/core';
import { WebApiService } from 'src/app/service/web-api.service';
import { Response } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent 
{
  title = 'web-site';
  webApiService: WebApiService;
  apiUrl = "http://localhost:8090/";
  milkTypes: any = [];
  cupTypes: any;
  coffeeTypes: any;

  constructor(_webApiService: WebApiService)
  {
    this.webApiService = _webApiService;
    this.getCoffeeTypes();
    this.getCupTypes();
    this.getMilkTypes();
  }

  getMilkTypes()
  {
    var url = this.apiUrl + "milk-amount";
    this.webApiService.getService(url).subscribe((response: Response )=> {
      console.log(response.json());
    });
  }

  getCupTypes()
  {
    var url = this.apiUrl + "cup-sizes";
    this.cupTypes = this.webApiService.getService(url);
  }

  getCoffeeTypes()
  {
    var url = this.apiUrl + "coffee-types";
    this.coffeeTypes = this.webApiService.getService(url);
  }
}

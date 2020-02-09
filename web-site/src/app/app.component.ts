import { Component, OnInit, AfterViewInit } from '@angular/core';
import { WebApiService } from 'src/app/service/web-api.service';
import { Response } from '@angular/http';
import swal from 'sweetalert2';

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
  stock: any;
  coffeeType: any;
  milkAmount: any;
  cupSize: any;
  coffee: any= {};

  constructor(_webApiService: WebApiService)
  {
    this.webApiService = _webApiService;
    this.getCoffeeTypes();
    this.getCupTypes();
    this.getMilkTypes();
    this.getStock();
  }

  getMilkTypes()
  {
    var url = this.apiUrl + "milk-amount";
    this.webApiService.getService(url).subscribe((response: Response)=> {
      this.milkTypes = response.json();
    });
  }

  getCupTypes()
  {
    var url = this.apiUrl + "cup-sizes";
    this.webApiService.getService(url).subscribe((response: Response)=> {
      this.cupTypes = response.json();
    });
  }

  getCoffeeTypes()
  {
    var url = this.apiUrl + "coffee-types";
    this.webApiService.getService(url).subscribe((response: Response)=> {
      this.coffeeTypes = response.json();
    });
  }

  getStock()
  {
    var url = this.apiUrl + "stock";
    this.webApiService.getService(url).subscribe((response: Response)=> {
      this.stock = response.json();
    });
  }

  public prepareCoffee() 
  {
    var url = this.apiUrl + "prepare-coffee";
   
    this.coffee.coffeeType = this.coffeeType;
    this.coffee.milkAmount = this.milkAmount;
    this.coffee.cupSize = this.cupSize;

    console.log(this.coffee)

    this.webApiService.postService(url, this.coffee).subscribe((response: Response)=> {
      swal.fire(response.json().message)
    });
    this.getStock();
  }

  public refill() 
  {
    var url = this.apiUrl + "refill-stock";

    this.webApiService.postService(url, null).subscribe((response: Response)=> {
      swal.fire('Stok tekrar doldurulmuştur.')
    });

    this.getStock();
  }
}

import { Injectable } from '@angular/core';
import { Router } from "@angular/router";
import { Http, Response, Headers, RequestOptions, RequestMethod } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Observable } from 'rxjs/Observable';
import swal from 'sweetalert2';
@Injectable({
  providedIn: 'root'
})
export class WebApiService {
      constructor(private http: Http){}
  
      postService(url: string, param: any): Observable<object>
      {
          return this.http.post(url, param)
          .map((response: Response) => {
              return response;
          });
  
      }
  
      getService(url: string): Observable<object>
      {
          return this.http.get(url)
          .map((response: Response) => {
              return response;
          });
      }
  }
  


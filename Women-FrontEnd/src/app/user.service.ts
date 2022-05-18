import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  getAllUsers(){
    return this.http.get("http://localhost:8000/api/user/all");
  }

  add(data : any) : Observable<any>{
    return this.http.post('http://localhost:8000/api/user/add' , data);
  }

  get(id: any ): Observable<any> {
    return this.http.get(`http://localhost:8000/api/user/get/`+`${id}`);
  }

  update(id: any , data : any): Observable<any> {
    return this.http.put(`http://localhost:8000/api/user/update/`+`${id}` , data);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/user/delete/`+`${id}`);
  }

  getLoggedUser(): User {
    return JSON.parse(localStorage.getItem('loggedUser')!);
  }
}


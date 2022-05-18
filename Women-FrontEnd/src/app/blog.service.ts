import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http : HttpClient) { }

  getAllPosts(){
    return this.http.get("http://localhost:8000/api/publication/RetrievePublication");
  }

  getAllRecentPosts(){
    return this.http.get("http://localhost:8000/api/publication/GetPubAlaune");
  }

  get(id: any): Observable<any> {
    return this.http.get<any>(`http://localhost:8000/api/publication/RetrievePublication/${id}`);
  }

  add(data : any) : Observable<any>{
    return this.http.post(`http://localhost:8000/api/publication/add` , data);
  }

  getByTitle(title : string){
    return this.http.get(`http://localhost:8080/api/publication/get/${title}`);
  }
}

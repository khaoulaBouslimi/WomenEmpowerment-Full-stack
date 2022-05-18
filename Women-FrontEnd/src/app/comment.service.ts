import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http : HttpClient) { }

 
  postComment(data: any , userId : number , postId:number): Observable<any> {
    return this.http.post<any>(`http://localhost:8000/api/comments/add/${userId}/${postId}`, data);
  }

  getByPubId(id : number):Observable<any>{
    return this.http.get(`http://localhost:8000/api/comments/get-comment/${id}`);
  }
}

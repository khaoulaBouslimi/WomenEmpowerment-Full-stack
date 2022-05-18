import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ComplaintsService {

  readonly API_URL = 'http://localhost:8000';
  
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get(`${this.API_URL}/api/complaints/all`)
  }
  addComplaints(data : any) {
    return this.httpClient.post(`${this.API_URL}/api/complaints/add`, data)
  }
  updateComplaints( data : any):Observable<Object>{
    return this.httpClient.put(`${this.API_URL}/api/complaints/update`, data)
  }
  delete(id : any){
    return  this.httpClient.delete(`http://localhost:8000/api/complaints/delete/${id}`)
  }
  get(id : any){
    return  this.httpClient.get(`http://localhost:8000/api/complaints/get/${id}`)
  }
 
  


}

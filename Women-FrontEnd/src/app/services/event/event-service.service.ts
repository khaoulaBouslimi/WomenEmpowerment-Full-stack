import { Injectable } from '@angular/core';
import { Event } from '../Model/Event'; 
import { environment } from 'src/environments/environment';
import { catchError, map } from 'rxjs/operators';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { HttpClient,HttpErrorResponse,HttpEvent,HttpParams,HttpRequest   } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EventServiceService {
  url = 'http://localhost:8000/api/'
  event:Event =new Event();
  tab:any=[];
  public curEvent= new BehaviorSubject(this.event);
  public curEvent1= new BehaviorSubject([this.event]);
  sharedEvent = this.curEvent.asObservable();
  sharedEvent1 = this.curEvent1.asObservable();
  
  constructor(private http:HttpClient) {
   }

  addEvent(data:Event){
     return this.http.post(this.url+'Events/add',data,{responseType: 'text'}).pipe(map((res) =>{
      this.tab=res;
      this.curEvent.next(this.tab);
    }));
  }

  getAllEvents(): Observable<Event[]>{
    return this.http.get<Event[]>(this.url+'Events/all');
  }
  

  deleteEvent(id:Number){
    return this.http.delete(this.url+'Events/'+id,{responseType: 'text'});
  }

  updateEvent(id:number,data:Event){
   
    return this.http.put(this.url+'Events/'+id,data,{responseType: 'text'});
  }
  getEventById(id:Number): Observable<Event>{
    return this.http.get<Event>(this.url+'Events/'+id);
  }

  uploadImg(id:any,file:any){
    const formData: FormData = new FormData();
    let params = new HttpParams();
    params.set('idRec',id);
    formData.append('file', file);
    formData.append('idRec',id);
    return this.http.post(this.url+'Events/addImgEventsList',formData,{
      reportProgress: true,
      responseType: 'json'
    })
  }
}

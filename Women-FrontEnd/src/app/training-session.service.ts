import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TrainingSession } from './training-session';

@Injectable({
  providedIn: 'root'
})
export class TrainingSessionService {
  private apiUrl = "http://localhost:8000"

  constructor(private httpClient : HttpClient) { }

  getALLTrainingSessions(){
    return this.httpClient.get(`${this.apiUrl}/GetAllTrainingSessions`)
  }

 

  getTheTrainingSessions():Observable<TrainingSession[]>{
    return this.httpClient.get<TrainingSession[]>(`${this.apiUrl}/GetAllTrainingSessions`);
  }

  createTrainingSession(trainingSession :TrainingSession): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/addTheTrainingSession`, trainingSession)
  }

  getTrainingSessionById( id : number): Observable <TrainingSession>{
    return this.httpClient.get<TrainingSession>(`${this.apiUrl}/GetTrainingSessionById/${id}`);
  }


  updateTrainingSession( id : number, ts : TrainingSession): Observable <Object> {
    return this.httpClient.put(`${this.apiUrl}/updateTrainingSession/${id}`, ts) ;
  }

  deleteTrainingSession(id : number):Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/DeleteTheTrainingSessionById/${id}`);
  }



  

}

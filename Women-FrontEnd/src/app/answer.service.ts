import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Answer } from './answer';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {
  

  readonly apiUrl = "http://localhost:8000"

  constructor(private httpClient : HttpClient) { }

  getALLAnswers(){
    return this.httpClient.get(`${this.apiUrl}/AfficherToutesLesReponses`)
  }

  updateAnswer( id : number, a : Answer): Observable <Object> {
    return this.httpClient.put(`${this.apiUrl}/updateUneReponse/${id}`, a) ;
  }

  deleteAnswer(id : number):Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/SupprimerUneReponse/${id}`);
  }


  getAnswerById( idQuiz : number): Observable <Answer>{
    return this.httpClient.get<Answer>(`${this.apiUrl}/RechercherLaReponseAvec/${idQuiz}`);

  }

  

}

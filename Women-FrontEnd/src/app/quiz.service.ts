import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from './question';
import { Quiz } from './quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  readonly apiUrl = "http://localhost:8000"

  constructor(private httpClient : HttpClient) { }

  getAllQuiz(){
    return this.httpClient.get(`${this.apiUrl}/GetAllquiz`)
  }

  updateQuiz( id : number, q : Quiz): Observable <Object> {
    return this.httpClient.put(`${this.apiUrl}/updateQuiz/${id}`, q) ;
  }

  deleteQuiz(id : number):Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/deleteQuizById/${id}`);
  }

  createQuiz(q :Quiz): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/AjouterUnQuizZz`, q)
  }

  getQuiizById( idQuiz : number): Observable <Quiz>{
    return this.httpClient.get<Quiz>(`${this.apiUrl}/finQuizById/${idQuiz}`);

  }

  addQuestionToQuiz(id : number, q : Question){
    return this.httpClient.post(`${this.apiUrl}/addQuestionToQuiz/${id}`, q) ;
  }

  
}

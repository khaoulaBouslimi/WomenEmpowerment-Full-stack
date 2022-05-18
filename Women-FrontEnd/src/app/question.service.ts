import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Answer } from './answer';
import { Question } from './question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private apiUrl = "http://localhost:8000"

  constructor(private httpClient : HttpClient) { }

  getALLQuestions(){
    return this.httpClient.get<any>("assets/question.json")
  }

  getAllquestionZ(){
    return this.httpClient.get(`${this.apiUrl}/AfficherTousLesQuestions`)
  }

  updateQuestion( id : number, q : Question): Observable <Object> {
    return this.httpClient.put(`${this.apiUrl}/MisAJoursQuestion/${id}`, q) ;
  }

  deleteQuestion(idQuiz : number):Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/SupprimerUneQuestion/${idQuiz}`);
  }

  createQuestion(q :Question): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}/AjouterUneQuestion`, q)
  }

  getQuestionById( idQuiz : number): Observable <Question>{
    return this.httpClient.get<Question>(`${this.apiUrl}/RechercherLaQuestionAvec/${idQuiz}`);
  }


  addAnswersToTheQuestion(id : number, q : Answer){
    return this.httpClient.post(`${this.apiUrl}/addAnswersToTheQuestion/${id}`, q) ;
  }

}

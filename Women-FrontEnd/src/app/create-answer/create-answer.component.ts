import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Answer } from '../answer';
import { Question } from '../question';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-create-answer',
  templateUrl: './create-answer.component.html',
  styleUrls: ['./create-answer.component.css']
})
export class CreateAnswerComponent implements OnInit {

  idQuestion : number
  question : Question = new Question();
  a : Answer = new Answer() ;

  constructor( private qService: QuestionService, 
    private route : ActivatedRoute ,
    private router: Router) { }

  ngOnInit(): void {

    this.idQuestion = this.route.snapshot.params['id'];
    this.qService.getQuestionById(this.idQuestion).subscribe(data => {
      this.question = data ;
    }, error => console.log(error));
  }

  
  saveAnswer(){
    this.qService.addAnswersToTheQuestion(this.question.idQuestion, this.a).subscribe(data => {
      console.log(data);
      this.goToAnswerList();
    },
    error => console.log(error));
  }

  /* to navigate to list of ts after creating one */
  goToAnswerList(){
    this.router.navigate(['/answerList']);
  }

  onSubmit(){
    console.log(this.question);
    this.saveAnswer();
  }

}

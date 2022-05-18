import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../question';
import { QuestionService } from '../question.service';
import { Quiz } from '../quiz';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {


  term;
  listQuiz : Quiz;
  listquestion : any;
  q : Question;

  constructor(private qService :  QuestionService,
    private router : Router ) { }

  ngOnInit(): void {

    this.getAllQuestions();

    this.q={
      idQuestion : null,
      questionorder :null,
      questiontext: null,
      isvalid : null,
      
    }
  }

  getAllQuestions(){
    this.qService.getAllquestionZ().subscribe(data => {
      this.listquestion = data ;
    })
  }

  updateQuestion( idQuestion : number){
    this.router.navigate(['update-question', idQuestion ]);
  }


  deleteQuestionById( idQuestion : number){
    this.qService.deleteQuestion(idQuestion).subscribe(data => {
      console.log(data);
      this.getAllQuestions();
    })
  }

  
  addQuestionToQuiz( idQuiz : number){
    this.router.navigate(['create-answer', idQuiz ]);
  }



}

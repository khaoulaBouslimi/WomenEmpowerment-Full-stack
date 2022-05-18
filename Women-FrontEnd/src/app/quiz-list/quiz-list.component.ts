import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../quiz';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-quiz-list',
  templateUrl: './quiz-list.component.html',
  styleUrls: ['./quiz-list.component.css']
})
export class QuizListComponent implements OnInit {
 

  term
  listQuiz : any;
  quiz : Quiz;

  constructor(private qService :  QuizService,
    private router : Router ) { }

  ngOnInit(): void {

    this.getAllQuiz();

    this.quiz={
      idQuiz: null,
      name: null,
      duration: null,
      location: null,
      description: null,
      trainerSname:null,
      isPublished:null
      
    }
  
  }

  getAllQuiz(){
    this.qService.getAllQuiz().subscribe(data => {
      this.listQuiz = data ;
    })
  }

  updateQuiz( idQuiz : number){
    this.router.navigate(['update-quiz', idQuiz ]);
  }


  deleteQuizById( idQuiz : number){
    this.qService.deleteQuiz(idQuiz).subscribe(data => {
      console.log(data);
      this.getAllQuiz();
    })
  }
  

  addQuestionToQuiz( idQuiz : number){
    this.router.navigate(['create-question', idQuiz ]);
  }
 
}

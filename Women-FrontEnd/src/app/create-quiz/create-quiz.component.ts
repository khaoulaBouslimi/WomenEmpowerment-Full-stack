import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from '../quiz';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.css']
})
export class CreateQuizComponent implements OnInit {

  q : Quiz = new Quiz();

  constructor( private qService: QuizService, 
    private router: Router) { }

  ngOnInit(): void {
  }

  
  saveQuiz(){
    this.qService.createQuiz(this.q).subscribe(data => {
      console.log(data);
      this.goToTsList();
    },
    error => console.log(error));
  }

  /* to navigate to list of ts after creating one */
  goToTsList(){
    this.router.navigate(['/quizList']);
  }

  onSubmit(){
    console.log(this.q);
    this.saveQuiz();
  }

}

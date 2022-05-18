import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../question';
import { QuestionService } from '../question.service';
import { Quiz } from '../quiz';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  idQuiz : number
  q : Question = new Question();
  quiz :Quiz = new Quiz();

  constructor( private qService: QuizService, 
    private route : ActivatedRoute ,
    private router: Router) { }

  ngOnInit(): void {

    this.idQuiz = this.route.snapshot.params['id'];
    this.qService.getQuiizById(this.idQuiz).subscribe(data => {
      this.quiz = data ;
    }, error => console.log(error));
  }

  
  saveQuestion(){
    this.qService.addQuestionToQuiz(this.quiz.idQuiz, this.q).subscribe(data => {
      console.log(data);
      this.goToQuestionList();
    },
    error => console.log(error));
  }

  /* to navigate to list of ts after creating one */
  goToQuestionList(){
    this.router.navigate(['/questionList']);
  }

  onSubmit(){
    console.log(this.q);
    this.saveQuestion();
  }

}

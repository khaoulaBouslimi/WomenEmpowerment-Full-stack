import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Quiz } from '../quiz';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {


  id : number;
  q : Quiz = new Quiz();
  constructor(private qService : QuizService ,
    private route : ActivatedRoute ,
    private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.qService.getQuiizById(this.id).subscribe(data => {
      this.q = data ;
    }, error => console.log(error));
  }

  onSubmit(){
    this.qService.updateQuiz(this.id, this.q).subscribe( data => {
      this.goToQuizList();
    }, error => console.log(error));

  }

  /* to navigate to list of ts after creating one */
  goToQuizList(){
    this.router.navigate(['/quizList']);
  }

}
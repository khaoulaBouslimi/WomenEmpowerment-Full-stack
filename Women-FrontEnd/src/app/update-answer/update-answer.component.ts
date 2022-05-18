import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Answer } from '../answer';
import { AnswerService } from '../answer.service';

@Component({
  selector: 'app-update-answer',
  templateUrl: './update-answer.component.html',
  styleUrls: ['./update-answer.component.css']
})
export class UpdateAnswerComponent implements OnInit {


  id : number;
  a : Answer = new Answer();
  constructor(private aService : AnswerService ,
    private route : ActivatedRoute ,
    private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.aService.getAnswerById(this.id).subscribe(data => {
      this.a = data ;
    }, error => console.log(error));
  }

  onSubmit(){
    this.aService.updateAnswer(this.id, this.a).subscribe( data => {
      this.goToQuizList();
    }, error => console.log(error));

  }

  /* to navigate to list of ts after creating one */
  goToQuizList(){
    this.router.navigate(['/answerList']);
  }

}
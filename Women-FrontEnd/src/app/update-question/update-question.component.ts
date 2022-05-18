import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../question';
import { QuestionService } from '../question.service';

@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})
export class UpdateQuestionComponent implements OnInit {

  id : number;
  q : Question = new Question();
  constructor(private questionService : QuestionService ,
    private route : ActivatedRoute ,
    private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.questionService.getQuestionById(this.id).subscribe(data => {
      this.q = data ;
    }, error => console.log(error));
  }

  onSubmit(){
    this.questionService.updateQuestion(this.id, this.q).subscribe( data => {
      this.goToTsList();
    }, error => console.log(error));

  }

  /* to navigate to list of ts after creating one */
  goToTsList(){
    this.router.navigate(['/questionList']);
  }

}
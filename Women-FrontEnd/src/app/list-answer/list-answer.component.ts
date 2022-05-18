import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Answer } from '../answer';
import { AnswerService } from '../answer.service';

@Component({
  selector: 'app-list-answer',
  templateUrl: './list-answer.component.html',
  styleUrls: ['./list-answer.component.css']
})
export class ListAnswerComponent implements OnInit {

  term;

  title : any;
  aList : Answer[]=[] ;
  public employees: Answer[];
  listOfanswers : any;
  form: boolean;
  a : Answer;
  closeResult : string;
  response = [];


  constructor(private aService : AnswerService,
    private router : Router ) { }

  ngOnInit(): void {

    this.getanswers();

    this.a = {
      idanswer : null,
      answerorder: null,
      answertext: null
    
    }

  }

  private getanswers(){
    this.aService.getALLAnswers().subscribe(data => 
      this.listOfanswers = data
    )
  }

  updateAnswer( idanswer : number){
    this.router.navigate(['update-answer', idanswer ]);
  }

  deleteAnswer( idanswer : number){
    this.aService.deleteAnswer(idanswer).subscribe(data => {
      console.log(data);
      this.getanswers();
    })
  }



}

import { Component, OnInit } from '@angular/core';
import { NgxQrcodeElementTypes, NgxQrcodeErrorCorrectionLevels } from '@techiediaries/ngx-qrcode';
import { interval } from 'rxjs';
import { QuestionService } from '../question.service';


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  title = 'MonQrCode';
  elementType = NgxQrcodeElementTypes.URL ;
  correctionLevel = NgxQrcodeErrorCorrectionLevels.HIGH ;
  value = 'Congratulations ';

  public name: string="";
  public questionList : any = [];
  public currentQuestion: number = 0;
  public points : number = 0;
  counter = 60;
  correctAnswer : number = 0;
  inCorrectAnswer : number=0;
  interval$:any;
  progress: string="0";
  isQuizCompleted : boolean=false;


  constructor(private qService : QuestionService) { }

  ngOnInit(): void {
    this.name = localStorage.getItem("name");
    this.getQuestionsFromService();
    this.startCounter();
  }

  getQuestionsFromService(){
    this.qService.getALLQuestions()
    .subscribe(res => {
      this.questionList = res.questions ;
    })
  }

  previousQuestion(){
    this.currentQuestion--;
  }
  nextQuestion(){
    this.currentQuestion++;
  }

  answer(currentQno:number, option:any){
    if (currentQno === this.questionList.length){
      this.isQuizCompleted = true;
      this.startCounter();
    }
    if (option.correct){
      this.points+=10;
      this.correctAnswer++;
      setTimeout(() => {
        this.currentQuestion++;
        this.resetCounter();
        this.getProgressPercent();
      }, 1000);
      
    }else{
      setTimeout(() => {
        this.currentQuestion++;
        this.inCorrectAnswer++;
        this.resetCounter();
        this.getProgressPercent();
      }, 1000);
      this.points-=10;
    }
  }

  startCounter(){
    this.interval$ = interval(1000).subscribe(val =>{
      this.counter--;
      if(this.counter ===0){
        this.currentQuestion++;
        this.counter = 60;
        this.points = 10;
      }
    });
    setTimeout(()=> {
      this.interval$.unsubscribe();
    }, 600000);
  }

  stopCounter(){
    this.interval$.unsubscribe();
    this.counter=0;
  }

  resetCounter(){
    this.stopCounter();
    this.counter= 60;
    this.startCounter();
  }

  resetQuiz(){
    this.resetCounter();
    this.getQuestionsFromService();
    this.points=0;
    this.counter=60;
    this.currentQuestion =0;
    this.progress="0";
  }

  getProgressPercent(){
    this.progress = ((this.currentQuestion/this.questionList.length)*100).toString();
    return this.progress;
  }
  
}

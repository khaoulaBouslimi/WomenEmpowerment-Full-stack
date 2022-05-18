import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrainingSession } from '../training-session';
import { TrainingSessionService } from '../training-session.service';

@Component({
  selector: 'app-training-session-list',
  templateUrl: './training-session-list.component.html',
  styleUrls: ['./training-session-list.component.css']
})
export class TrainingSessionListComponent implements OnInit {
  term;

  title : any;
  tsList : TrainingSession[]=[] ;
  public employees: TrainingSession[];
  listOfTrainingSessions : any;
  form: boolean;
  t : TrainingSession;
  closeResult : string;
  response = [];


  constructor(private tsService : TrainingSessionService,
    private router : Router ) { }

  ngOnInit(): void {

    this.getTrainingSessions();

    this.t = {
      idTS : null,
      title : null,
      dateDebut:null,
      dateFin: null,
      dure : null,
      localisation: null,
      DescriptionOfTS: null
    
    }

  }

  private getTrainingSessions(){
    this.tsService.getALLTrainingSessions().subscribe(data => 
      this.listOfTrainingSessions = data
    )
  }

  updateTrainingSession( idTS : number){
    this.router.navigate(['update-ts', idTS ]);
  }

  deleteTrainingSession( idTS : number){
    this.tsService.deleteTrainingSession(idTS).subscribe(data => {
      console.log(data);
      this.getTrainingSessions();
    })
  }




 

}

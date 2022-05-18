import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrainingSession } from '../training-session';
import { TrainingSessionService } from '../training-session.service';

@Component({
  selector: 'app-create-traininsession',
  templateUrl: './create-traininsession.component.html',
  styleUrls: ['./create-traininsession.component.css']
})
export class CreateTraininsessionComponent implements OnInit {

  
  ts : TrainingSession = new TrainingSession();

  constructor(private tsService : TrainingSessionService,
    private router: Router) { }

  ngOnInit(): void {
  }


  saveTs(){
    this.tsService.createTrainingSession(this.ts).subscribe(data => {
      console.log(data);
      this.goToTsList();
    },
    error => console.log(error));
  }

  /* to navigate to list of ts after creating one */
  goToTsList(){
    this.router.navigate(['/trainingSessionList']);
  }

  onSubmit(){
    console.log(this.ts);
    this.saveTs();
  }

}

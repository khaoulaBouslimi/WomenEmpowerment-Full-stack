import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TrainingSession } from '../training-session';
import { TrainingSessionService } from '../training-session.service';

@Component({
  selector: 'app-update-traininsession',
  templateUrl: './update-traininsession.component.html',
  styleUrls: ['./update-traininsession.component.css']
})
export class UpdateTraininsessionComponent implements OnInit {

  id : number;
  ts : TrainingSession = new TrainingSession();
  constructor(private tsService : TrainingSessionService ,
    private route : ActivatedRoute ,
    private router : Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.tsService.getTrainingSessionById(this.id).subscribe(data => {
      this.ts = data ;
    }, error => console.log(error));
  }

  onSubmit(){
    this.tsService.updateTrainingSession(this.id, this.ts).subscribe( data => {
      this.goToTsList();
    }, error => console.log(error));

  }

  /* to navigate to list of ts after creating one */
  goToTsList(){
    this.router.navigate(['/trainingSessionList']);
  }

}

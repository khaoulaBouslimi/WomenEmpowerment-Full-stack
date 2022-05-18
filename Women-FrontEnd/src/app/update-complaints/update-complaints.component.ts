import { Component, OnInit } from '@angular/core';
import { Complaints } from '../complaints';
import { ComplaintsService } from '../complaints.service';

@Component({
  selector: 'app-update-complaints',
  templateUrl: './update-complaints.component.html',
  styleUrls: ['./update-complaints.component.css']
})
export class UpdateComplaintsComponent implements OnInit {
  data : Complaints = {
    id:'',
    topic: '',
    complaintDate: Date.now()
  };

  submitted = false;
  constructor(private complaintsService: ComplaintsService) { 

  }
  editComplaint(data:Complaints){
    this.complaintsService.updateComplaints(data).subscribe();
  }

 
  ngOnInit(): void {
    ;
  }
}

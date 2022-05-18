import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Complaints } from '../complaints';
import { ComplaintsService } from '../complaints.service';

@Component({
  selector: 'app-create-complaints',
  templateUrl: './create-complaints.component.html',
  styleUrls: ['./create-complaints.component.css']
})
export class CreateComplaintsComponent implements OnInit {

  complaint : Complaints = {
    id:'',
    topic: '',
    complaintDate: Date.now()
  };
  submitted = false;
  constructor(private complaintsService: ComplaintsService) { 

  }
  saveComplaint(): void {
    const data = {
      topic: this.complaint.topic,
      complaintDate: this.complaint.complaintDate
    };

    this.complaintsService.addComplaints(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
          this.reloadPage();
        },
        error => {
          console.log(error);
        });
  }

  ngOnInit() {
  }

  reloadPage(): void {
    window.location.href = "/complaintsList";
  }

 
}

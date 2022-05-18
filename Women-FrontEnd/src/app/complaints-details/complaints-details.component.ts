import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Complaints } from '../complaints';
import { ComplaintsService } from '../complaints.service';

@Component({
  selector: 'app-complaints-details',
  templateUrl: './complaints-details.component.html',
  styleUrls: ['./complaints-details.component.css']
})
export class ComplaintsDetailsComponent implements OnInit {
  currentComplaints: Complaints= {
    id:'',
    topic: '',
    complaintDate: '',

  };
  message = '';
  constructor(
    private complaintsService: ComplaintsService,
    private route: ActivatedRoute,
    private router: Router) { }

    ngOnInit(): void {
      this.message = '';
     
    }
    getComplaint(id: any): void {
      this.complaintsService.get(id)
        .subscribe(
          data => {
            this.currentComplaints!= data;
            console.log(data);
          },
          error => {
            console.log(error);
          });
    }
    delete(): void {
      this.complaintsService.delete(this.currentComplaints.id)
        .subscribe(
          response => {
            console.log(response);
            this.router.navigate(['/complaintsList']);
          },
          error => {
            console.log(error);
          });
    }
  

}

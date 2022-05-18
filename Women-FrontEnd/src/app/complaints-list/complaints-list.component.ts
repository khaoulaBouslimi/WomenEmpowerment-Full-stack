import { Component, OnInit } from '@angular/core';
import { Complaints } from '../complaints';
import { ComplaintsService } from '../complaints.service';

@Component({
  selector: 'app-complaints-list',
  templateUrl: './complaints-list.component.html',
  styleUrls: ['./complaints-list.component.css']
})
export class ComplaintsListComponent implements OnInit {
  dataC:any;
  term!: string;
  p: number = 1;
  currentIndex = -1;
  currentComplaints:Complaints={
    id: '',
    topic: '',
    complaintDate: ''
  };
  complaints: Complaints[] = [];
  complaint!:Complaints;
  index:number=1;
  
  title = '';
  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];
  submitted:boolean=false;
  
  constructor(private complaintsService :ComplaintsService) {
    this.complaintsService.getAll().subscribe(data=>this.dataC=data);
   }
   getRequestParams( page: number, pageSize: number): any {
    let params: any = {};
   
    if (page) {
      params[`page`] = page - 1;
    }
    if (pageSize) {
      params[`size`] = pageSize;
    }
    return params;
  }

  ngOnInit(): void {
    
  }
  setActiveComplaints(complaints: Complaints, index: number): void {
    this.currentComplaints= complaints;
    this.currentIndex = index;
  }

  delete(id : number): void {
    this.complaintsService.delete(id)
      .subscribe(
        response => {
          console.log(response);
          window.location.href = "/complaintsList";
        },
        error => {
          console.log(error);
        });
  }
  editComplaint(): void {
    const data = {
      topic: this.currentComplaints.topic,
      complaintDate: this.currentComplaints.complaintDate
    };

    this.complaintsService.updateComplaints(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
         
        },
        error => {
          console.log(error);
        });
  }
  retrieveTutorials(): void {
   
  }
  handlePageChange(event: number): void {
    this.page = event;
    this.retrieveTutorials();
  }
  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.page = 1;
    this.retrieveTutorials();
  }

}

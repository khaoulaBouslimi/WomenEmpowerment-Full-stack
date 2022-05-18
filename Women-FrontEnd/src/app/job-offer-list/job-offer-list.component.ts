import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobOffer } from '../job-offer';
import { JobOfferService } from '../job-offer.service';

@Component({
  selector: 'app-job-offer-list',
  templateUrl: './job-offer-list.component.html',
  styleUrls: ['./job-offer-list.component.css']
})
export class JobOfferListComponent implements OnInit {

  JobOffer!: JobOffer[];

  constructor(private jobOfferServ :JobOfferService, private router: Router ) { }

  ngOnInit(): void {
    this.getJobOffer();
  }

  private getJobOffer(){
    this.jobOfferServ.getJobOfferList().subscribe(data =>{
      this.JobOffer = data;
    });
  }
  JobOfferDetails(idOffer: any){
    this.router.navigate(['job-offer-details', idOffer]);
  }
  updateJobOffer(idOffer:any){
    this.router.navigate(['update-job-offer', idOffer]);
  }
  deleteJobOfferById(idOffer: any){
    this.jobOfferServ.deleteJobOfferById(idOffer).subscribe(data => {
      console.log(data);
      this.getJobOffer();
    })
  }

}
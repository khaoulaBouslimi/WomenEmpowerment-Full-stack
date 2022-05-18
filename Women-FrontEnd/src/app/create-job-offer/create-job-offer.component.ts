import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobOffer } from '../job-offer';
import { JobOfferService } from '../job-offer.service';

@Component({
  selector: 'app-create-job-offer',
  templateUrl: './create-job-offer.component.html',
  styleUrls: ['./create-job-offer.component.css']
})
export class CreateJobOfferComponent implements OnInit {

  jobOffers: JobOffer = new JobOffer();
  constructor(private jobOfferServ: JobOfferService, private router: Router) { }

  ngOnInit(): void {
  }
    saveJobOffer(){
      this.jobOfferServ.addJobOffer(this.jobOffers).subscribe(data =>{
        console.log(data);
        this.goToJobOfferList();
      },
      error => console.log(error));
      
    }
    goToJobOfferList(){
      this.router.navigate(['/jobOffers']);
    }
    onSubmit(){
      console.log(this.jobOffers);
      this.saveJobOffer();
    }
  

}
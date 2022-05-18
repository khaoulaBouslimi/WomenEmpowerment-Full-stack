import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JobOffer } from '../job-offer';
import { JobOfferService } from '../job-offer.service';

@Component({
  selector: 'app-update-job-offer',
  templateUrl: './update-job-offer.component.html',
  styleUrls: ['./update-job-offer.component.css']
})
export class UpdateJobOfferComponent implements OnInit {

  idOffer: any;
  jobOffers: JobOffer = new JobOffer();

  constructor(private jobOfferServ: JobOfferService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.idOffer = this.route.snapshot.params['idOffer'];

    this.jobOfferServ.getJobOfferById(this.idOffer).subscribe(data => {
      this.jobOffers = data;
    }, error => console.log(error));
  }
    
  onSubmit(){
    this.jobOfferServ.updateJobOffer(this.idOffer, this.jobOffers).subscribe( data =>{
      this.goToJobOfferList();
    }
    , error => console.log(error));
  }
  goToJobOfferList(){
    this.router.navigate(['/jobOffers']);
  }
}
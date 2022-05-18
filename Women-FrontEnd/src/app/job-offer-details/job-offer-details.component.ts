import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JobOffer } from '../job-offer';
import { JobOfferService } from '../job-offer.service';

@Component({
  selector: 'app-job-offer-details',
  templateUrl: './job-offer-details.component.html',
  styleUrls: ['./job-offer-details.component.css']
})
export class JobOfferDetailsComponent implements OnInit {

  idOffer: any;
  jobOffers!: JobOffer
  constructor(private route: ActivatedRoute, private jobOfferServ: JobOfferService ) { }

  ngOnInit(): void {
    this.idOffer = this.route.snapshot.params['idOffer'];

    this.jobOffers = new JobOffer();
    this.jobOfferServ.getJobOfferById(this.idOffer).subscribe( data => {
      this.jobOffers = data;
    });
  }

}
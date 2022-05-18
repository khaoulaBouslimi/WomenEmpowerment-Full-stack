import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { JobOffer } from './job-offer';

@Injectable({
  providedIn: 'root'
})
export class JobOfferService {

  private baseURL = "http://localhost:8000/joboffer";
  constructor(private httpClient: HttpClient) { }

  
  getJobOfferList(): Observable<JobOffer[]>{
    return this.httpClient.get<JobOffer[]>(`${this.baseURL}/jobOffers`);
  }
  addJobOffer(jobOffers: JobOffer): Observable<object>{
    return this.httpClient.post(`${this.baseURL}/jobOffers`, jobOffers);
  }
  updateJobOffer(idOffer: any,jobOffers: JobOffer ): Observable<object>{
    return this.httpClient.put(`${this.baseURL}/${idOffer}/jobOffers/${idOffer}`,jobOffers );
  }
  deleteJobOfferById(idOffer: any): Observable<object>{
    return this.httpClient.delete(`${this.baseURL}/jobOffers/${idOffer}`);
  }

  getJobOfferById(idOffer: any): Observable<JobOffer>{
  return this.httpClient.get<JobOffer>  (`${this.baseURL}/${idOffer}`);
  }
}
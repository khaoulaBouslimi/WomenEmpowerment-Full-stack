import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobOfferDetailsComponent } from './job-offer-details.component';

describe('JobOfferDetailsComponent', () => {
  let component: JobOfferDetailsComponent;
  let fixture: ComponentFixture<JobOfferDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JobOfferDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobOfferDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

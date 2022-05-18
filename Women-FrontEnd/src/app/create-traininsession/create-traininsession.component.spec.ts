import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTraininsessionComponent } from './create-traininsession.component';

describe('CreateTraininsessionComponent', () => {
  let component: CreateTraininsessionComponent;
  let fixture: ComponentFixture<CreateTraininsessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateTraininsessionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTraininsessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

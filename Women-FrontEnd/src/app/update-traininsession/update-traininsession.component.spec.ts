import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTraininsessionComponent } from './update-traininsession.component';

describe('UpdateTraininsessionComponent', () => {
  let component: UpdateTraininsessionComponent;
  let fixture: ComponentFixture<UpdateTraininsessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTraininsessionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTraininsessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

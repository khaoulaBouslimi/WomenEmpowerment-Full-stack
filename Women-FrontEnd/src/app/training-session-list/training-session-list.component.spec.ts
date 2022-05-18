import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingSessionListComponent } from './training-session-list.component';

describe('TrainingSessionListComponent', () => {
  let component: TrainingSessionListComponent;
  let fixture: ComponentFixture<TrainingSessionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainingSessionListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingSessionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateComplaintsComponent } from './create-complaints.component';

describe('CreateComplaintsComponent', () => {
  let component: CreateComplaintsComponent;
  let fixture: ComponentFixture<CreateComplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateComplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

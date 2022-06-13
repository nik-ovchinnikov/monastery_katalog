import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRelicFormComponent } from './add-icon-form.component';

describe('AddIconFormComponent', () => {
  let component: AddRelicFormComponent;
  let fixture: ComponentFixture<AddRelicFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRelicFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRelicFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

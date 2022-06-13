import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIconFormComponent } from './add-icon-form.component';

describe('AddIconFormComponent', () => {
  let component: AddIconFormComponent;
  let fixture: ComponentFixture<AddIconFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddIconFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIconFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

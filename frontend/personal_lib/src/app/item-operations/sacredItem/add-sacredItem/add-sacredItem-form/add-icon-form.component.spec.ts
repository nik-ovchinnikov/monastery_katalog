import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddChurchItemFormComponent } from './add-icon-form.component';

describe('AddIconFormComponent', () => {
  let component: AddChurchItemFormComponent;
  let fixture: ComponentFixture<AddChurchItemFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddChurchItemFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddChurchItemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

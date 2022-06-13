import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterIconChangeSubmitComponent } from './after-book-change-submit.component';

describe('AfterItemChangeSubmitComponent', () => {
  let component: AfterIconChangeSubmitComponent;
  let fixture: ComponentFixture<AfterIconChangeSubmitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfterIconChangeSubmitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterIconChangeSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

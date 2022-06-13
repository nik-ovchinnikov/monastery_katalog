import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IconAddSubmitComponent } from './book-add-submit.component';

describe('ItemAddSubmitComponent', () => {
  let component: IconAddSubmitComponent;
  let fixture: ComponentFixture<IconAddSubmitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IconAddSubmitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IconAddSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

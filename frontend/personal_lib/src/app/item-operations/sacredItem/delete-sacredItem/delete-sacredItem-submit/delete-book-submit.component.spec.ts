import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteIconSubmitComponent } from './delete-book-submit.component';

describe('DeleteItemSubmitComponent', () => {
  let component: DeleteIconSubmitComponent;
  let fixture: ComponentFixture<DeleteIconSubmitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteIconSubmitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteIconSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

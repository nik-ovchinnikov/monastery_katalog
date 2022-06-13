import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowIconsComponent } from './show-books.component';

describe('ShowItemsComponent', () => {
  let component: ShowIconsComponent;
  let fixture: ComponentFixture<ShowIconsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowIconsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowIconsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IconListFilterComponent } from './book-list-filter.component';

describe('BookListFilterComponent', () => {
  let component: IconListFilterComponent;
  let fixture: ComponentFixture<IconListFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IconListFilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IconListFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

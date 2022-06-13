import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ChurchItem } from 'src/app/shared/models/churchItem.model';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { ChurchItemFilter } from 'src/app/shared/models/filters/churchItemFilter.model';
import { ChurchItemService } from '../../churchItem.service';

@Component({
  selector: 'app-choose-churchItem-change',
  templateUrl: './choose-churchItem-change.component.html',
  styleUrls: ['./choose-churchItem-change.component.css']
})
export class ChooseChurchItemChangeComponent implements OnInit {


  showCarouselFlag: boolean = false;

  itemsToShow: ChurchItem[] = [];
  itemsToShowSubscription: Subscription = new Subscription();

  sourceList: string[] = [];

  //для фильтров
  filterData: ChurchItemFilter = new ChurchItemFilter();

  constructor(
    private itemService: ChurchItemService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.itemsToShowSubscription = this.itemService.itemListEmitter.subscribe((itemArray) => {
      this.itemsToShow = itemArray;
      for(let item of this.itemsToShow) {
        if(item.subPlace == null) {
          item.subPlace = new SubPlace();
        }
        if(item.subType == null) {
          item.subType = new SubType();
        }
        if(item.type == null) {
          item.type = new Type();
        }
        if(item.place == null) {
          item.place = new Place();
        }
      }
    });
    this.itemService.getAllItems();
  }

  ngOnDestroy(): void {
      this.itemsToShowSubscription.unsubscribe();
  }

  showCarousel(key: string) {
    this.showCarouselFlag = !this.showCarouselFlag;
    //дочтаём нужный элемент массива по ключу
    let currentItem= this.itemsToShow.filter((item) => {
      return item.key == key;
    });
    this.sourceList = [];
    for(let picture of currentItem[0].pictureList) {
      this.sourceList.push("./pictures/books/" + picture.name);
    }
  }

  afterCloseCarousel() {
    this.showCarouselFlag = false
  }

  onFilterValueChanged(event: any) {
     this.filterData.byName = event.byName;
     this.filterData.byWordsInDescription= event.byWordsInDescription;
     this.filterData.key = event.byKey;
     this.filterData.fromCreationDate = event.fromCreationDate;
     this.filterData.fromLastChange = event.fromLastChange;
     this.filterData.sortType = event.sortType;
     this.filterData.tillCreationDate = event.tillCreationDate;
     this.filterData.tillLastChange= event.tillLastChange;
     this.filterData.type = event.typeName;
     this.filterData.place = event.placeName;
     this.filterData.subPlace = event.subPlaceName;
     this.filterData.subtype= event.subTypeName;
  }

  onChangeBtnClick(event: any) {
    //TODO Тут можно воспоьзоваться ViewChild
    // let deleteItemIndex = event.target.previousSibling.previousSibling.innerHTML;
    let changeItemKey = event.target.id;
    // console.log(deleteItemIndex);
    //находим index в массиве
    // let deleteItemIndex = this.booksToShow.findIndex((book) => {book.key == deleteItem.key});
    let changeItemIndex = -2;
    this.itemsToShow.forEach((item, index, array) => {
      if(item.key == changeItemKey) {
        changeItemIndex = index;
      }
    });
    this.itemService.itemToChange = this.itemsToShow[changeItemIndex];
    //Добавить в массив для удаления
    // this.bookService.booksToDelete.push(this.booksToShow[changeItemIndex]);
    //Убрать из основного массива
    // this.booksToShow.splice(changeItemIndex, 1);
    // console.log(this.ps.placesToDelete);
    this.router.navigateByUrl('/churchItem/change/change-form');
  }

}

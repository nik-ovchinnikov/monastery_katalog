import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Relic } from 'src/app/shared/models/relic.model';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { RelicFilter } from 'src/app/shared/models/filters/relicFilter.model';
import { RelicService } from '../../relic.service';

@Component({
  selector: 'app-choose-relic-delete',
  templateUrl: './choose-relic-delete.component.html',
  styleUrls: ['./choose-relic-delete.component.css']
})
export class ChooseRelicDeleteComponent implements OnInit {

  showCarouselFlag: boolean = false;

  itemsToShow: Relic[] = [];
  itemsToShowSubscription: Subscription = new Subscription();

  sourceList: string[] = [];

  //для фильтров
  filterData: RelicFilter = new RelicFilter();

  constructor(
    private itemService: RelicService,
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
      this.sourceList.push("./pictures/relics/" + picture.name);
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

  onDeleteBtnClick(event: any) {
    //TODO Тут можно воспоьзоваться ViewChild
    // let deleteItemIndex = event.target.previousSibling.previousSibling.innerHTML;
    let deleteItemKey = event.target.id;
    //находим index в массиве
    // let deleteItemIndex = this.booksToShow.findIndex((book) => {book.key == deleteItem.key});
    let deleteItemIndex = -2;
    this.itemsToShow.forEach((item, index, array) => {
      if(item.key == deleteItemKey) {
        deleteItemIndex = index;
      }
    });
    //Добавить в массив для удаления
    this.itemService.itemsToDelete.push(this.itemsToShow[deleteItemIndex]);
    //Убрать из основного массива
    this.itemsToShow.splice(deleteItemIndex, 1);
    // console.log(this.ps.placesToDelete);
  }
  cancelDeletes() {
    this.itemsToShow = this.itemsToShow.concat(this.itemService.itemsToDelete);
    this.itemService.itemsToDelete = [];
  }

  submitDelete(){
    this.itemService.deleteItems();
  }

}

import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { SacredItem } from 'src/app/shared/models/sacredItem.model';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { SacredItemFilter } from 'src/app/shared/models/filters/sacredItemFilter.model';
import { SacredItemService } from '../sacredItem.service';
import { TypeService } from 'src/app/shared/components/type-operations/type.service';
import { PlaceService } from 'src/app/shared/components/place-operations/place.service';

@Component({
  selector: 'app-show-sacredItems',
  templateUrl: './show-sacredItems.component.html',
  styleUrls: ['./show-sacredItems.component.css']
})
export class ShowSacredItemsComponent implements OnInit, OnDestroy {

  showCarouselFlag: boolean = false;

  itemsToShow: SacredItem[] = [];
  itemsToShowSubscription: Subscription = new Subscription();

  sourceList: string[] = [];

  //для фильтров
  filterData: SacredItemFilter = new SacredItemFilter();

  constructor(
    private itemService: SacredItemService,
  ) {
  }

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
    let currentItem = this.itemsToShow.filter((item) => {
      return item.key == key;
    });
    this.sourceList = [];
    for(let picture of currentItem[0].pictureList) {
      this.sourceList.push("./pictures/sacredItems/" + picture.name);
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

}

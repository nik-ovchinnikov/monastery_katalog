import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ChurchItem } from 'src/app/shared/models/churchItem.model';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { ChurchItemFilter } from 'src/app/shared/models/filters/churchItemFilter.model';
import { ChurchItemService } from '../churchItem.service';
import { TypeService } from 'src/app/shared/components/type-operations/type.service';
import { PlaceService } from 'src/app/shared/components/place-operations/place.service';

@Component({
  selector: 'app-show-churchItems',
  templateUrl: './show-churchItems.component.html',
  styleUrls: ['./show-churchItems.component.css']
})
export class ShowChurchItemsComponent implements OnInit, OnDestroy {

  showCarouselFlag: boolean = false;

  itemsToShow: ChurchItem[] = [];
  itemsToShowSubscription: Subscription = new Subscription();

  sourceList: string[] = [];

  //для фильтров
  filterData: ChurchItemFilter = new ChurchItemFilter();

  constructor(
    private itemService: ChurchItemService,
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
      this.sourceList.push("./pictures/churchItems/" + picture.name);
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

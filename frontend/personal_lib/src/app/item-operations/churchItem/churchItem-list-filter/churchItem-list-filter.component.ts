import { Component, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { PlaceService } from '../../../shared/components/place-operations/place.service';
import { TypeService } from '../../../shared/components/type-operations/type.service';
import { ChurchItemService } from '../churchItem.service';

@Component({
  selector: 'app-churchItem-list-filter',
  templateUrl: './churchItem-list-filter.component.html',
  styleUrls: ['./churchItem-list-filter.component.css']
})
export class ChurchItemListFilterComponent implements OnInit, OnDestroy {

  @Output()
  onFormValueChanges: EventEmitter<any> = new EventEmitter<any>();


  filterForm = this.fb.group({
    "byName": [""],
    "fromCreationDate": [new Date(1970,1,1)],
    "tillCreationDate": [new Date(6999,1,1)],
    "fromLastChange": [new Date(1970,1,1)],
    "tillLastChange": [new Date(5970,1,1)],
    "byWordsInDescription": [""],
    "byKey": [""],
    "typeName": [""],
    "placeName": [""],
    "subPlaceName": [""],
    "subTypeName": [""],
    "sortType": ["changeDateDESC"],
  });

  placeList: Place[] = [];
  typeList: Type[] = [];
  chosenType: Type = new Type();
  chosenPlace: Place= new Place();
  chosenSubType: SubType = new SubType();
  chosenSubPlace: SubPlace= new SubPlace();
  placeListSubscr: Subscription = new Subscription();
  typeListSubscr: Subscription = new Subscription();

  tester: any;

  constructor(
    private fb: FormBuilder,
    private typeService: TypeService,
    private placeService: PlaceService,
  ) {
    typeService.urlParam = 'churchItem';
    placeService.urlParam = 'churchItem';
  }

  ngOnDestroy(): void {
    this.placeListSubscr.unsubscribe();
    this.typeListSubscr.unsubscribe();
  }


  ngOnInit(): void {
    //получение типов и места хранения
    this.placeListSubscr = this.placeService.placeListEmitter.subscribe((data) => {
      this.placeList = data;
    });
    this.placeService.getAllPlaceList();
    this.typeListSubscr = this.typeService.typeListEmitter.subscribe((data) => {
      this.typeList = data;
    });

    this.placeService.getAllPlaceList();
    this.typeService.getAllTypeList();

    //подписки на изменение формы
    this.filterForm.get("typeName")?.valueChanges.subscribe((data) => {
      this.tester = this.typeList.filter((type) => {
        return type.name.includes(data);
      });
      this.chosenType = this.tester[0];
    });

    this.filterForm.get("placeName")?.valueChanges.subscribe((data) => {
      this.tester = this.placeList.filter((place) => {
        return place.name.includes(data);
      });
      this.chosenPlace= this.tester[0];
    });

    this.filterForm.get("subTypeName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenType.subTypeList.filter((subType) => {
        return subType.name.includes(data);
      });
      this.chosenSubType = this.tester[0];
    });

    this.filterForm.get("subPlaceName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenPlace.subPlaceList.filter((subPlace) => {
        return subPlace.name.includes(data);
      });
      this.chosenSubPlace = this.tester[0];
    });

    this.filterForm.valueChanges.subscribe((filterData: any) => {
      this.onFormValueChanges.emit(filterData);
    });
  }



  filtersReset() {
    //TODO прописать сброс значений для каждого параметра отделнь
    this.filterForm.reset({
      "byName": "",
      "fromCreationDate": new Date(1970,1,1),
      "tillCreationDate": new Date(6970,1,1),
      "fromLastChange": new Date(1970,1,1),
      "tillLastChange": new Date(6970,1,1),
      "byWordsInDescription": "",
      "byKey": "",
      "typeName": [""],
      "placeName": [""],
      "subPlaceName": [""],
      "subTypeName": [""],
      "sortType": "changeDateDESC",
    }

    );
    this.chosenPlace = new Place();
    this.chosenType = new Type();
  }
}

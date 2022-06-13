import { Pipe, PipeTransform } from "@angular/core";
import { ChurchItem } from "src/app/shared/models/churchItem.model";
import { ChurchItemFilter } from "src/app/shared/models/filters/churchItemFilter.model";

@Pipe({
  name: 'churchItemFilter',
  pure: false,
})
export class FilterByNamePipe implements PipeTransform {
  transform(itemList: ChurchItem[], itemFilterData: ChurchItemFilter) {
    let itemResultArray = itemList.filter((item) => {
      return item.name.includes(itemFilterData.byName)
        && item.description.includes(itemFilterData.byWordsInDescription)
        && (+ new Date(item.lastChangeDate) > + new Date(itemFilterData.fromLastChange))
        && (+ new Date(item.lastChangeDate) < + new Date(itemFilterData.tillLastChange))
        && (+ new Date(item.creationDate) > + new Date(itemFilterData.fromCreationDate))
        && (+ new Date(item.creationDate) < + new Date(itemFilterData.tillCreationDate))
        && item.key.includes(itemFilterData.key)
        && item.type.name.includes(itemFilterData.type)
        && item.subType.name.includes(itemFilterData.subtype)
        && item.place.name.includes(itemFilterData.place)
        && item.subPlace.name.includes(itemFilterData.subPlace)
        ;

      ;
    })
    // console.log(bookResultArray);
    return this.sortFilteredArray(itemFilterData.sortType, itemResultArray);

  }

  sortFilteredArray(sortType: string, array: ChurchItem[]): ChurchItem[] {
    if(sortType== "changeDateDESC") {
      return this.sortByLastChangeDate(array);
    }else if(sortType == "changeDateASC") {
      return this.sortByLastChangeDate(array).reverse();
    }else if(sortType == "creatDateDESC") {
      return this.sortByCreationDate(array).reverse();
    }else if(sortType == "creatDateASC") {
      return this.sortByCreationDate(array);
    }else if(sortType == "byNameDESC") {
      return this.sortByName(array).reverse();
    }else if(sortType == "byNameASC") {
      return this.sortByName(array);
    }else {
      console.log(
        "ERROR!!! CHOOSE SORT TYPE!!!"
      );
      return [];
    }
  }
  sortByCreationDate(array: ChurchItem[]) {
    array = array.sort((a, b) => {
      if(+ new Date(a.creationDate) > + new Date(b.creationDate)) {
        return 1;
      } else if (+ new Date(a.creationDate) == + new Date(b.creationDate)) {
        return 0;
      } else {
        return -1;
      }
    });
    return array;

  }

  sortByLastChangeDate(array: ChurchItem[]) {
    array = array.sort((a, b) => {
      if(+ new Date(a.lastChangeDate) > + new Date(b.lastChangeDate)) {
        return 1;
      } else if (+ new Date(a.lastChangeDate) == + new Date(b.lastChangeDate)) {
        return 0;
      } else {
        return -1;
      }
    });
    return array;
  }
  sortByName(array: ChurchItem[]) {
    array = array.sort((a, b) => {
      if(a.name > b.name) {
        return 1;
      } else if (a.name == b.name) {
        return 0;
      } else {
        return -1;
      }
    });
    return array;

  }

}

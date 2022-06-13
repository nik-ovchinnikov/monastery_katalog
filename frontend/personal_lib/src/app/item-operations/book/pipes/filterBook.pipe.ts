import { Pipe, PipeTransform } from "@angular/core";
import { Book } from "src/app/shared/models/book.model";
import { BookFilter } from "src/app/shared/models/filters/bookFilter.model";

@Pipe({
  name: 'bookFilter',
  pure: false,
})
export class FilterByNamePipe implements PipeTransform {
  transform(bookList: Book[], itemFilterData: BookFilter) {
    let bookResultArray = bookList.filter((book) => {
      return book.name.includes(itemFilterData.byName)
        && book.description.includes(itemFilterData.byWordsInDescription)
        && (+ new Date(book.lastChangeDate) > + new Date(itemFilterData.fromLastChange))
        && (+ new Date(book.lastChangeDate) < + new Date(itemFilterData.tillLastChange))
        && (+ new Date(book.creationDate) > + new Date(itemFilterData.fromCreationDate))
        && (+ new Date(book.creationDate) < + new Date(itemFilterData.tillCreationDate))
        && book.key.includes(itemFilterData.key)
        && book.type.name.includes(itemFilterData.type)
        && book.subType.name.includes(itemFilterData.subtype)
        && book.place.name.includes(itemFilterData.place)
        && book.subPlace.name.includes(itemFilterData.subPlace)
        ;

      ;
    })
    // console.log(bookResultArray);
    return this.sortFilteredArray(itemFilterData.sortType, bookResultArray);

  }

  sortFilteredArray(sortType: string, array: Book[]): Book[] {
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
  sortByCreationDate(array: Book[]) {
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

  sortByLastChangeDate(array: Book[]) {
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
  sortByName(array: Book[]) {
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

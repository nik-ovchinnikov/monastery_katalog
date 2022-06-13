import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Subject } from "rxjs";
import { CrudService } from "src/app/shared/crud.service";
import { SacredItem} from "src/app/shared/models/sacredItem.model";
import { Picture } from "src/app/shared/models/picture.model";

@Injectable({providedIn: 'root'})
export class SacredItemService {

  isExistKeyInDBEmitter = new Subject<boolean>();

  //для изменеия книги
  oldItem: SacredItem = new SacredItem();

  //книга перед добавлением
  resultItem: SacredItem = new SacredItem();
  //хранит все файлы для загрузки
  selectedFiles: File[] = [];

  //все книги
  itemFullList: SacredItem[] = [];

  itemsToShow: SacredItem[] = [];
  itemListEmitter: Subject<SacredItem[]> = new Subject<SacredItem[]>();

  //deleting
  itemsToDelete: SacredItem[] = [];

  //changeItem
  itemToChange: SacredItem = new SacredItem();
//   oldPicture: SacredItemPicture = new BookPicture();
  changedItem: SacredItem = new SacredItem();
  newPictures: Picture[] = [];
  oldPicturesToDelete: Picture[] = [];

  constructor(
      private crudServ: CrudService,
      private http: HttpClient,
  ){}

  checkKey(key: string){
      this.crudServ.checkName('sacredItem/checkKey?key=' + key)
          .subscribe((data: { [key: string]: any}) => {
              let marker: number = 0;
              for(let key in data) {
                  marker++;
              }
              if(marker > 0){
                  if((marker == 1) && (key == this.oldItem.key)) {
                      this.isExistKeyInDBEmitter.next(false);
                  }else{
                      this.isExistKeyInDBEmitter.next(true);
                  }
              }else{
                 this.isExistKeyInDBEmitter.next(false);
              }
          });
  }

  public addItem(){
    return this.http.post(
        '/sacredItem/add',
        this.resultItem
    )
    .pipe(map((responseData: any) => {
        const nameArray = [];
        for(const key in responseData){
            if(responseData.hasOwnProperty(key)){
                nameArray.push(responseData[key]);
            }
        }
        return nameArray;
    }))
  }

  public getAllItems() {
      this.crudServ.getAllDAO<SacredItem>('/sacredItem/getAll')
        .pipe(map((responseData: any) => {
            const itemArray: SacredItem[] = [];
            for(const key in responseData) {
                if(responseData.hasOwnProperty(key)) {
                    itemArray.push(responseData[key]);
                }
            }
            return itemArray;
        }))
        .subscribe((items) => {
            this.itemListEmitter.next(items);
        });
  }

  public deleteItems() {
    this.crudServ.deleteItemList('/sacredItem/deleteItems', this.itemsToDelete)
    .subscribe((data) => {
        // console.log(data);
    });
  }

  public deletePictures(){
    let idArray: number[] = [];
    for(let picture of this.oldPicturesToDelete) {
       idArray.push(picture.id);
    }
    this.crudServ.urlParam = 'sacredItem';
     return this.crudServ.deleteOldPicturesByIds(idArray)
  }
  public changeItem() {
    return this.http.post(
        'sacredItem/update',
        this.changedItem
    )
    .pipe(map((responseData: any) => {
        const nameArray = [];
        for(const key in responseData) {
            if(responseData.hasOwnProperty(key)) {
                nameArray.push(responseData[key]);
            }
        }
        return nameArray;
    }))
  }
}

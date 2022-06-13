import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Subject } from "rxjs";
import { CrudService } from "src/app/shared/crud.service";
import { Icon} from "src/app/shared/models/icon.model";
import { Picture } from "src/app/shared/models/picture.model";

@Injectable({providedIn: 'root'})
export class IconService {

  isExistKeyInDBEmitter = new Subject<boolean>();

  //для изменеия книги
  oldItem: Icon = new Icon();

  //книга перед добавлением
  resultItem: Icon = new Icon();
  //хранит все файлы для загрузки
  selectedFiles: File[] = [];

  //все книги
  itemFullList: Icon[] = [];

  itemsToShow: Icon[] = [];
  itemListEmitter: Subject<Icon[]> = new Subject<Icon[]>();

  //deleting
  itemsToDelete: Icon[] = [];

  //changeItem
  itemToChange: Icon = new Icon();
//   oldPicture: IconPicture = new BookPicture();
  changedItem: Icon = new Icon();
  newPictures: Picture[] = [];
  oldPicturesToDelete: Picture[] = [];

  constructor(
      private crudServ: CrudService,
      private http: HttpClient,
  ){}

  checkKey(key: string){
      this.crudServ.checkName('icon/checkKey?key=' + key)
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
        '/icon/add',
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
      this.crudServ.getAllDAO<Icon>('/icon/getAll')
        .pipe(map((responseData: any) => {
            const itemArray: Icon[] = [];
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
    this.crudServ.deleteItemList('/icon/deleteItems', this.itemsToDelete)
    .subscribe((data) => {
        // console.log(data);
    });
  }

  public deletePictures(){
    let idArray: number[] = [];
    for(let picture of this.oldPicturesToDelete) {
       idArray.push(picture.id);
    }
    this.crudServ.urlParam = 'icon';
     return this.crudServ.deleteOldPicturesByIds(idArray)
  }
  public changeItem() {
    return this.http.post(
        'icon/update',
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

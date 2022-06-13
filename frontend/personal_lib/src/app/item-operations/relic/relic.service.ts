import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Subject } from "rxjs";
import { CrudService } from "src/app/shared/crud.service";
import { Relic} from "src/app/shared/models/relic.model";
import { Picture } from "src/app/shared/models/picture.model";

@Injectable({providedIn: 'root'})
export class RelicService {

  isExistKeyInDBEmitter = new Subject<boolean>();

  //для изменеия книги
  oldItem: Relic = new Relic();

  //книга перед добавлением
  resultItem: Relic = new Relic();
  //хранит все файлы для загрузки
  selectedFiles: File[] = [];

  //все книги
  itemFullList: Relic[] = [];

  itemsToShow: Relic[] = [];
  itemListEmitter: Subject<Relic[]> = new Subject<Relic[]>();

  //deleting
  itemsToDelete: Relic[] = [];

  //changeItem
  itemToChange: Relic = new Relic();
//   oldPicture: IconPicture = new BookPicture();
  changedItem: Relic = new Relic();
  newPictures: Picture[] = [];
  oldPicturesToDelete: Picture[] = [];

  constructor(
      private crudServ: CrudService,
      private http: HttpClient,
  ){}

  checkKey(key: string){
      this.crudServ.checkName('relic/checkKey?key=' + key)
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
        '/relic/add',
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
      this.crudServ.getAllDAO<Relic>('/relic/getAll')
        .pipe(map((responseData: any) => {
            const itemArray: Relic[] = [];
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
    this.crudServ.deleteItemList('/relic/deleteItems', this.itemsToDelete)
    .subscribe((data) => {
        // console.log(data);
    });
  }

  public deletePictures(){
    let idArray: number[] = [];
    for(let picture of this.oldPicturesToDelete) {
       idArray.push(picture.id);
    }
    this.crudServ.urlParam = 'relic';
     return this.crudServ.deleteOldPicturesByIds(idArray)
  }
  public changeItem() {
    return this.http.post(
        'relic/update',
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

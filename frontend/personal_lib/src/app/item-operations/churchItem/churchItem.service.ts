import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { map, Subject } from "rxjs";
import { CrudService } from "src/app/shared/crud.service";
import { ChurchItem} from "src/app/shared/models/churchItem.model";
import { Picture } from "src/app/shared/models/picture.model";

@Injectable({providedIn: 'root'})
export class ChurchItemService {

  isExistKeyInDBEmitter = new Subject<boolean>();

  //для изменеия книги
  oldItem: ChurchItem = new ChurchItem();

  //книга перед добавлением
  resultItem: ChurchItem = new ChurchItem();
  //хранит все файлы для загрузки
  selectedFiles: File[] = [];

  //все книги
  itemFullList: ChurchItem[] = [];

  itemsToShow: ChurchItem[] = [];
  itemListEmitter: Subject<ChurchItem[]> = new Subject<ChurchItem[]>();

  //deleting
  itemsToDelete: ChurchItem[] = [];

  //changeItem
  itemToChange: ChurchItem = new ChurchItem();
//   oldPicture: ChurchItemPicture = new BookPicture();
  changedItem: ChurchItem = new ChurchItem();
  newPictures: Picture[] = [];
  oldPicturesToDelete: Picture[] = [];

  constructor(
      private crudServ: CrudService,
      private http: HttpClient,
  ){}

  checkKey(key: string){
      this.crudServ.checkName('churchItem/checkKey?key=' + key)
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
        '/churchItem/add',
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
      this.crudServ.getAllDAO<ChurchItem>('/churchItem/getAll')
        .pipe(map((responseData: any) => {
            const itemArray: ChurchItem[] = [];
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
    this.crudServ.deleteItemList('/churchItem/deleteItems', this.itemsToDelete)
    .subscribe((data) => {
        // console.log(data);
    });
  }

  public deletePictures(){
    let idArray: number[] = [];
    for(let picture of this.oldPicturesToDelete) {
       idArray.push(picture.id);
    }
    this.crudServ.urlParam = 'churchItem';
     return this.crudServ.deleteOldPicturesByIds(idArray)
  }
  public changeItem() {
    return this.http.post(
        'churchItem/update',
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

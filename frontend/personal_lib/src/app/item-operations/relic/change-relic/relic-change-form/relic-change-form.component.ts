import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { PlaceService } from 'src/app/shared/components/place-operations/place.service';
import { TypeService } from 'src/app/shared/components/type-operations/type.service';
import { Relic } from 'src/app/shared/models/relic.model';
import { Picture } from 'src/app/shared/models/picture.model';
import { Place } from 'src/app/shared/models/place.model';
import { SubPlace } from 'src/app/shared/models/subPlace.model';
import { SubType } from 'src/app/shared/models/subType.model';
import { Type } from 'src/app/shared/models/type.model';
import { RelicService } from '../../relic.service';

@Component({
  selector: 'app-relic-change-form',
  templateUrl: './relic-change-form.component.html',
  styleUrls: ['./relic-change-form.component.css']
})
export class RelicChangeFormComponent implements OnInit {

  myForm: FormGroup = new FormGroup({});

  placeList: Place[] = [];
  typeList: Type[] = [];
  chosenType: Type = new Type();
  chosenPlace: Place= new Place();
  chosenSubType: SubType = new SubType();
  chosenSubPlace: SubPlace= new SubPlace();

  tester: any;

  //подписки
  placeListSubscr: Subscription = new Subscription();
  typeListSubscr: Subscription = new Subscription();

  //маркеры валидации
  itemKeyExistsInBase: boolean = false;
  keyCheckSubscription: Subscription = new Subscription();

  // changeBookKeyExistInBase: boolean = this.bookKeyExistsInBase && (this.bookService.itemToChange.key == );

  formIsNotValid: boolean = true;

  //объекты картинок для записи в базу
  itemPicturesToWrite: Picture[] = [];

  controlsBookPictures: AbstractControl[] = [];
  Pictures: Picture[] = [];

  //изменеие предмета
  oldPictures: Picture[] = [];


  constructor(
    private router: Router,
    private fb: FormBuilder,
    private typeService: TypeService,
    private placeService: PlaceService,
    private itemService: RelicService,
    private http: HttpClient,
  ) { }
  ngOnDestroy(): void {
    this.placeListSubscr.unsubscribe();
    this.typeListSubscr.unsubscribe();
    this.keyCheckSubscription.unsubscribe();
  }

  ngOnInit(): void {
    //очищаем массив с файлами
    this.itemService.selectedFiles = [];


    //старые фото
    this.itemService.oldItem.key = this.itemService.itemToChange.key;
    this.oldPictures = this.itemService.itemToChange.pictureList;

    this.createItemChanged();

    this.prepareChosenVars();

    this.getPlaceTypeLists();


    //подписка на состаяние уникальности ключа
    this.keyCheckSubscription = this.itemService.isExistKeyInDBEmitter.subscribe((data) => {
      this.itemKeyExistsInBase = data;
    });

    //создание формы
    this.formInitialization();

    this.controlsBookPictures = (<FormArray>this.myForm.get('pictures')).controls;
    this.formChangeSubscribe();

  }

  backToMenu() {
    this.router.navigateByUrl('/');
  }

  //проверка уникальности ключа
  onKeyInputPrint(event: any) {
    let key = event.target.value;
  }

  onSubmit() {

    //Даты не забудь!!!
    this.itemService.changedItem.lastChangeDate= new Date();
    // Object.assign(
    //   this.Service.changedItem.bookPictureList,
    //   this.oldPictures
    // );
    for(let picture of this.itemService.newPictures) {
      this.itemService.changedItem.pictureList.push(picture);
    }
    this.itemService.newPictures = [];
    //Переименовка файла после добавления книги
    // сброс формы, удаление всех фото, обнуления массива FormFrray и selectedFiles

    this.itemService.deletePictures()
    .subscribe(() => {

      this.itemService.changeItem()
      .subscribe((names) => {
          let i = 0;
          // Запрос с добавлением файлов
          for (let file of this.itemService.selectedFiles) {
              const fd = new FormData();
              fd.append("file", file);
              fd.append("fileName", names[i]);
              this.http.post(
                '/relic-files/addFile',
                fd
              ).subscribe( res => {});
              i++;
          }


          this.cleanForm();
          this.router.navigateByUrl('/');
      });
    })
    ;
    // disabled = true
    this.formIsNotValid = true;
  }

   //По нажатии кнопки добавляет ещё одну форму для выгрузки фойла
  onAddPhotoPath() {
    const control = new FormControl(null);
    (<FormArray>this.myForm.get('pictures')).push(control);
  }

  //после нажатия на кнопку "удалить"
  onClickDeletePicture(event: any) {
    // event.preventDefault();
    let fileToRemove: File = new File([], "");
    let fileNameToRemove = event.target.getAttribute("fileName");

    //можно заменить фильтром или пайпом
    if(fileNameToRemove != null) {
      this.itemService.selectedFiles.forEach((file) => {
        if(file.name == fileNameToRemove) {
          fileToRemove = file;
        }
      });

      this.itemService.selectedFiles.splice(this.itemService.selectedFiles.indexOf(fileToRemove), 1);
      //непосредственно удаление

      event.target.parentNode.parentNode.remove();
      //удалить обхект картинки из resultBook

      this.itemService.newPictures.splice(this.itemService.newPictures.length - 1, 1);
    }else{
      event.target.parentNode.parentNode.remove();
    }
  }

    //Действия после добавления файла
  onFileAdded(event: any) {
          if(event.target.nextSibling.getAttribute("wasUploaded") == "false"){

            event.target.nextSibling.setAttribute("fileName", event.target.files[0].name);
            event.target.nextSibling.setAttribute("wasUploaded", "true");
            //проверка имени файла на уникальность


            //добавление файла в массив
            this.itemService.selectedFiles.push(event.target.files[0]);
            //добавление в итоговый объект картинку
            this.itemService.newPictures.push(new Picture());
          }else{
            //удаляем старую фото
            let fileToRemove: File =  new File([], "");
            let fileNameToRemove = event.target.nextSibling.getAttribute("fileName");
            this.itemService.selectedFiles.forEach((file) => {
              if(file.name == fileNameToRemove) {
                fileToRemove = file;
              }
            });
            this.itemService.selectedFiles.splice(this.itemService.selectedFiles.indexOf(fileToRemove), 1);

            //проверка имени на уникальность


            //добавляем новое фото
            event.target.nextSibling.setAttribute("fileName", event.target.files[0].name);
            this.itemService.selectedFiles.push(event.target.files[0]);

          }
          //передадим этот файл в изображение
          //перенести в службу!!!! addItem
          const reader = new FileReader();
          reader.onloadend = () => {
            event.target.nextSibling.nextSibling.src = reader.result;
          }
          reader.readAsDataURL(event.target.files[0]);
  }

  onClickDeleteOldPicture(event: any){
    let pictureName = event.target.id;
    let index = this.oldPictures.findIndex((picture) => {
      return picture.name == pictureName;
    });
    this.itemService.oldPicturesToDelete.push(this.oldPictures[index]);
    this.oldPictures.splice(index, 1);
    this.itemService.changedItem.pictureList.splice(index, 1);
  }

  resetChanges() {
    this.itemService.selectedFiles = [];

    this.createItemChanged();

    this.myForm.patchValue({
      name: this.itemService.itemToChange.name,
      key: this.itemService.itemToChange.key,
      publishYear: this.itemService.itemToChange.publishYear,
      seria: this.itemService.itemToChange.seria,
      description: this.itemService.itemToChange.description,
      typeName: this.itemService.itemToChange.type.name,
      subTypeName: this.itemService.itemToChange.subType.name,
      placeName: this.itemService.itemToChange.place.name,
      subPlaceName: this.itemService.itemToChange.subPlace.name,
    });

    this.itemService.oldItem.key = this.itemService.itemToChange.key;
    this.itemService.checkKey(this.itemService.itemToChange.key);

    for(let picture of this.itemService.oldPicturesToDelete) {
      this.itemService.itemToChange.pictureList.push(picture);

    }
    this.itemService.itemsToDelete = [];
    this.itemService.oldPicturesToDelete = [];
  }

  cleanForm() {
        this.itemService.selectedFiles = [];
        this.itemService.changedItem.pictureList = [];
        this.itemService.newPictures = [];
        this.itemService.oldPicturesToDelete = [];
        this.chosenType = new Type();
        this.chosenPlace = new Place();
        this.chosenSubType = new SubType();
        this.chosenSubPlace = new SubPlace();
        this.itemService.changedItem.subPlace = new SubPlace();
        this.itemService.changedItem.subType= new SubType();

        this.itemService.itemToChange = new Relic();
        // this.ngOnInit();
        // this.myForm.reset();
        // this.myForm.get("bookPictures")?.setValue(new FormArray([]));
  }

  sendingFileToServer() {

  }

  formInitialization() {
    this.myForm = this.fb.group({
      name: [this.itemService.itemToChange.name, Validators.required],
      key: [this.itemService.itemToChange.key, Validators.required],
      seria: [this.itemService.itemToChange.seria],
      publishYear: [this.itemService.itemToChange.publishYear],
      description: [this.itemService.itemToChange.description],
      typeName: [this.itemService.itemToChange.type.name, Validators.required],
      subTypeName: [this.itemService.itemToChange.subType.name, Validators.required],
      placeName: [this.itemService.itemToChange.place.name, Validators.required],
      subPlaceName: [this.itemService.itemToChange.subPlace.name, Validators.required],
      pictures: new FormArray([
      ]),
    });
  }

  formChangeSubscribe() {
    //подписки на изменение формы
    this.myForm.get("typeName")?.valueChanges.subscribe((data) => {
      this.tester = this.typeList.filter((type) => {
        return type.name.includes(data);
      });
      this.chosenType = this.tester[0];
      this.itemService.changedItem.type =this.chosenType;
      // this.bookService.changedItem.bookSubType.id = -1;
      this.myForm.patchValue({subTypeName: this.chosenType.subTypeList[0].name});
    });

    this.myForm.get("placeName")?.valueChanges.subscribe((data) => {
      this.tester = this.placeList.filter((place) => {
        return place.name.includes(data);
      });
      this.chosenPlace= this.tester[0];
      this.itemService.changedItem.place = this.chosenPlace;
      // this.bookService.changedItem.bookSubPlace.id = -1;
      this.myForm.patchValue({subPlaceName: this.chosenPlace.subPlaceList[0].name});
    });

    this.myForm.get("subTypeName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenType.subTypeList.filter((subType) => {
        return subType.name.includes(data);
      });
      this.chosenSubType = this.tester[0];
      this.itemService.changedItem.subType = this.chosenSubType;
    });

    this.myForm.get("subPlaceName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenPlace.subPlaceList.filter((subPlace) => {
        return subPlace.name.includes(data);
      });
      this.chosenSubPlace = this.tester[0];
      this.itemService.changedItem.subPlace = this.chosenSubPlace;
    });

    this.myForm.get("key")?.valueChanges.subscribe((data) => {
      this.itemService.checkKey(data);
      this.itemService.changedItem.key = data;
    });

    this.myForm.get("name")?.valueChanges.subscribe((data) => {
      this.itemService.changedItem.name= data;
    });

    this.myForm.get("description")?.valueChanges.subscribe((data) => {
      this.itemService.changedItem.description= data;
    });

    this.myForm.get("publishYear")?.valueChanges.subscribe((data) => {
      this.itemService.changedItem.publishYear= data;
    });

    this.myForm.get("seria")?.valueChanges.subscribe((data) => {
      this.itemService.changedItem.seria= data;
    });

    this.myForm.valueChanges.subscribe(() => {
      this.formIsNotValid = !this.myForm.valid;
    });
  }

  createItemChanged() {
    //Создание изменённого объекта
    this.itemService.changedItem.name = this.itemService.itemToChange.name;
    this.itemService.changedItem.description = this.itemService.itemToChange.description;
    this.itemService.changedItem.lastChangeDate = this.itemService.itemToChange.lastChangeDate;
    this.itemService.changedItem.creationDate = this.itemService.itemToChange.creationDate;
    this.itemService.changedItem.key = this.itemService.itemToChange.key;
    this.itemService.changedItem.id = this.itemService.itemToChange.id;
    this.itemService.changedItem.place = Object.assign(this.itemService.itemToChange.place);
    this.itemService.changedItem.subPlace = Object.assign(this.itemService.itemToChange.subPlace);
    this.itemService.changedItem.type = Object.assign(this.itemService.itemToChange.type);
    this.itemService.changedItem.subType = Object.assign(this.itemService.itemToChange.subType);
    this.itemService.changedItem.publishYear = this.itemService.itemToChange.publishYear;
    this.itemService.changedItem.seria = this.itemService.itemToChange.seria;
  }

  prepareChosenVars() {
    this.chosenPlace = this.itemService.itemToChange.place;
    this.chosenType = this.itemService.itemToChange.type
    this.chosenSubType = this.itemService.itemToChange.subType;
    this.chosenSubPlace = this.itemService.itemToChange.subPlace;
  }

  getPlaceTypeLists() {

    //получение типов и места хранения
    this.placeListSubscr = this.placeService.placeListEmitter.subscribe((data) => {
      this.placeList = data;
    });
    this.typeListSubscr = this.typeService.typeListEmitter.subscribe((data) => {
      this.typeList = data;
    });

    this.placeService.getAllPlaceList();
    this.typeService.getAllTypeList();
  }
}

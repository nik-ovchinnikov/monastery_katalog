import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
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
import { Type } from "src/app/shared/models/type.model";
import { RelicService } from '../../relic.service';

@Component({
  selector: 'app-add-relic-form',
  templateUrl: './add-relic-form.component.html',
  styleUrls: ['./add-relic-form.component.css']
})
export class AddRelicFormComponent implements OnInit, OnDestroy {

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

  formIsNotValid: boolean = true;

  //объекты картинок для записи в базу
  picturesToWrite: Picture[] = [];

  controlsPictures: AbstractControl[] = [];
  pictures: Picture[] = [];



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
    this.typeService.urlParam = 'relic';
    this.placeService.urlParam = 'relic';

    //получение типов и места хранения
    this.placeListSubscr = this.placeService.placeListEmitter.subscribe((data) => {
      this.placeList = data;
    });
    this.typeListSubscr = this.typeService.typeListEmitter.subscribe((data) => {
      this.typeList = data;
    });

    this.placeService.getAllPlaceList();
    this.typeService.getAllTypeList();

    //подписка на состаяние уникальности ключа
    this.keyCheckSubscription = this.itemService.isExistKeyInDBEmitter.subscribe((data) => {
      this.itemKeyExistsInBase = data;
    });

    //создание формы
    this.myForm = this.fb.group({
      name: ["", Validators.required],
      author: [""],
      publishYear: [""],
      publisher: [""],
      seria: [""],
      weight: [""],
      size: [""],
      material: [""],
      key: ["", Validators.required],
      description: [""],
      typeName: ["", Validators.required],
      subTypeName: [""],
      placeName: ["", Validators.required],
      subPlaceName: [""],
      pictures: new FormArray([
      ]),
    });

    this.controlsPictures = (<FormArray>this.myForm.get('pictures')).controls;

    //подписки на изменение формы
    this.myForm.get("typeName")?.valueChanges.subscribe((data) => {
      this.tester = this.typeList.filter((type) => {
        return type.name.includes(data);
      });
      this.chosenType = this.tester[0];
      this.itemService.resultItem.type =this.chosenType;
    });

    this.myForm.get("placeName")?.valueChanges.subscribe((data) => {
      this.tester = this.placeList.filter((place) => {
        return place.name.includes(data);
      });
      this.chosenPlace= this.tester[0];
      this.itemService.resultItem.place = this.chosenPlace;
    });

    this.myForm.get("subTypeName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenType.subTypeList.filter((subType) => {
        return subType.name.includes(data);
      });
      this.chosenSubType = this.tester[0];
      this.itemService.resultItem.subType = this.chosenSubType;
    });

    this.myForm.get("subPlaceName")?.valueChanges.subscribe((data) => {
      this.tester = this.chosenPlace.subPlaceList.filter((subPlace) => {
        return subPlace.name.includes(data);
      });
      this.chosenSubPlace = this.tester[0];
      this.itemService.resultItem.subPlace = this.chosenSubPlace;
    });

    this.myForm.get("key")?.valueChanges.subscribe((data) => {
      this.itemService.checkKey(data);
      this.itemService.resultItem.key = data;
    });

    this.myForm.get("name")?.valueChanges.subscribe((data) => {
      this.itemService.resultItem.name= data;
    });

    this.myForm.get("description")?.valueChanges.subscribe((data) => {
      this.itemService.resultItem.description= data;
    });

    this.myForm.get("publishYear")?.valueChanges.subscribe((data) => {
      this.itemService.resultItem.publishYear= data;
    });

    this.myForm.get("seria")?.valueChanges.subscribe((data) => {
      this.itemService.resultItem.seria= data;
    });

    this.myForm.valueChanges.subscribe(() => {
      this.formIsNotValid = !this.myForm.valid;
    });

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
    this.itemService.resultItem.creationDate = new Date();
    this.itemService.resultItem.lastChangeDate= new Date();
    //Переименовка файла после добавления книги
    // сброс формы, удаление всех фото, обнуления массива FormFrray и selectedFiles
    this.itemService.addItem()
    .subscribe(names => {
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


        this.itemService.selectedFiles = [];
        this.itemService.resultItem.pictureList = [];
        this.chosenType = new Type();
        this.chosenPlace = new Place();
        this.chosenSubType = new SubType();
        this.chosenSubPlace = new SubPlace();
        this.itemService.resultItem.subPlace = new SubPlace();
        this.itemService.resultItem.subType= new SubType();

        this.ngOnInit();
        this.formIsNotValid = true;
    });
    // this.myForm.reset();
    // this.myForm.get("bookPictures")?.setValue(new FormArray([]));
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

      // if(event.target.parentNode.parentNode.) {
        event.target.parentNode.parentNode.remove();
      // }
      //удалить обхект картинки из resultItem

      this.itemService.resultItem.pictureList.splice(this.itemService.resultItem.pictureList.length - 1, 1);
    }else {
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
            this.itemService.resultItem.pictureList.push(new Picture());
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
}

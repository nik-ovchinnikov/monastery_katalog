import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {AddBookFormComponent} from "./item-operations/book/add-book/add-book-form/add-book-form.component";
import {BookAddSubmitComponent} from "./item-operations/book/add-book/book-add-submit/book-add-submit.component";
import {ChooseBookDeleteComponent} from "./item-operations/book/delete-book/choose-book-delete/choose-book-delete.component";
import {DeleteBookSubmitComponent} from "./item-operations/book/delete-book/delete-item-submit/delete-book-submit.component";
import {ChooseBookChangeComponent} from "./item-operations/book/change-book/choose-book-change/choose-book-change.component";
import {BookChangeFormComponent} from "./item-operations/book/change-book/book-change-form/book-change-form.component";
import {AfterBookChangeSubmitComponent} from "./item-operations/book/change-book/after-book-change-submit/after-book-change-submit.component";
import {AddBookComponent} from "./item-operations/book/add-book/add-book.component";
import {ChangeBookComponent} from "./item-operations/book/change-book/change-book.component";
import {DeleteBookComponent} from "./item-operations/book/delete-book/delete-book.component";
import {ShowBooksComponent} from "./item-operations/book/show-books/show-books.component";
import {AddTypeFormComponent} from "./shared/components/type-operations/add-type/add-type-form/add-type-form.component";
import {TypeAddSubmitComponent} from "./shared/components/type-operations/add-type/type-add-submit/type-add-submit.component";
import {ChooseTypeDeleteComponent} from "./shared/components/type-operations/delete-type/choose-type-delete/choose-type-delete.component";
import {ChooseTypeChangeComponent} from "./shared/components/type-operations/change-type/choose-type-change/choose-type-change.component";
import {TypeChangeFormComponent} from "./shared/components/type-operations/change-type/type-change-form/type-change-form.component";
import {AfterChangeTypeSubmitComponent} from "./shared/components/type-operations/change-type/after-change-type-submit/after-change-type-submit.component";
import {AddTypeComponent} from "./shared/components/type-operations/add-type/add-type.component";
import {ChangeTypeComponent} from "./shared/components/type-operations/change-type/change-type.component";
import {DeleteTypeComponent} from "./shared/components/type-operations/delete-type/delete-type.component";
import {ShowTypesComponent} from "./shared/components/type-operations/show-types/show-types.component";
import {AddPlaceFormComponent} from "./shared/components/place-operations/add-place/add-place-form/add-place-form.component";
import {PlaceAddSubmitComponent} from "./shared/components/place-operations/add-place/place-add-submit/place-add-submit.component";
import {ChoosePlaceDeleteComponent} from "./shared/components/place-operations/delete-place/choose-place-delete/choose-place-delete.component";
import {DeletePlaceSubmitComponent} from "./shared/components/place-operations/delete-place/delete-place-submit/delete-place-submit.component";
import {ChoosePlaceChangeComponent} from "./shared/components/place-operations/change-place/choose-place-change/choose-place-change.component";
import {PlaceChangeFormComponent} from "./shared/components/place-operations/change-place/place-change-form/place-change-form.component";
import {AfterChangePlaceSubmitComponent} from "./shared/components/place-operations/change-place/after-change-place-submit/after-change-place-submit.component";
import {AddPlaceComponent} from "./shared/components/place-operations/add-place/add-place.component";
import {ChangePlaceComponent} from "./shared/components/place-operations/change-place/change-place.component";
import {DeletePlaceComponent} from "./shared/components/place-operations/delete-place/delete-place.component";
import {ShowPlacesComponent} from "./shared/components/place-operations/show-places/show-places.component";
import {MainMenuComponent} from "./header/main-menu/main-menu.component";
import {ContactsComponent} from "./header/contacts/contacts.component";
import {AboutComponent} from "./header/about/about.component";
import {SendBackupComponent} from "./header/send-backup/send-backup.component";
import {SaveChangesComponent} from "./header/save-changes/save-changes.component";
import {BookComponent} from "./item-operations/book/book.component";
import {TypeOperationsComponent} from "./shared/components/type-operations/type-operations.component";
import {PlaceOperationsComponent} from "./shared/components/place-operations/place-operations.component";
import {DeleteTypeSubmitComponent} from "./shared/components/type-operations/delete-type/delete-type-submit/delete-type-submit.component";
import { LoginComponent } from "./auth/login/login.component";
import { LogoutComponent } from "./auth/logout/logout.component";


import {AddIconFormComponent} from "./item-operations/icon/add-icon/add-icon-form/add-icon-form.component";
import {IconAddSubmitComponent} from "./item-operations/icon/add-icon/icon-add-submit/icon-add-submit.component";
import {AddIconComponent} from "./item-operations/icon/add-icon/add-icon.component";
import { ChooseIconDeleteComponent } from "./item-operations/icon/delete-icon/choose-icon-delete/choose-icon-delete.component";
import { DeleteIconSubmitComponent } from "./item-operations/icon/delete-icon/delete-icon-submit/delete-icon-submit.component";
import { ChooseIconChangeComponent } from "./item-operations/icon/change-icon/choose-icon-change/choose-icon-change.component";
import { IconChangeFormComponent } from "./item-operations/icon/change-icon/icon-change-form/icon-change-form.component";
import { AfterIconChangeSubmitComponent } from "./item-operations/icon/change-icon/after-icon-change-submit/after-icon-change-submit.component";
import { DeleteIconComponent } from "./item-operations/icon/delete-icon/delete-icon.component";
import { ShowIconsComponent } from "./item-operations/icon/show-icons/show-icons.component";
import { ChangeIconComponent } from "./item-operations/icon/change-icon/change-icon.component";


import { RelicComponent } from "./item-operations/relic/relic.component";
import { AddRelicFormComponent } from "./item-operations/relic/add-relic/add-relic-form/add-relic-form.component";
import { RelicAddSubmitComponent } from "./item-operations/relic/add-relic/relic-add-submit/relic-add-submit.component";
import { ChooseRelicDeleteComponent } from "./item-operations/relic/delete-relic/choose-relic-delete/choose-relic-delete.component";
import { DeleteRelicSubmitComponent } from "./item-operations/relic/delete-relic/delete-relic-submit/delete-relic-submit.component";
import { ChooseRelicChangeComponent } from "./item-operations/relic/change-relic/choose-relic-change/choose-relic-change.component";
import { RelicChangeFormComponent } from "./item-operations/relic/change-relic/relic-change-form/relic-change-form.component";
import { AfterRelicChangeSubmitComponent } from "./item-operations/relic/change-relic/after-relic-change-submit/after-relic-change-submit.component";
import { AddRelicComponent } from "./item-operations/relic/add-relic/add-relic.component";
import { ChangeRelicComponent } from "./item-operations/relic/change-relic/change-relic.component";
import { DeleteRelicComponent } from "./item-operations/relic/delete-relic/delete-relic.component";
import { ShowRelicsComponent } from "./item-operations/relic/show-relics/show-relics.component";



import { AddChurchItemFormComponent } from "./item-operations/churchItem/add-churchItem/add-churchItem-form/add-churchItem-form.component";
import { ChurchItemAddSubmitComponent } from "./item-operations/churchItem/add-churchItem/churchItem-add-submit/churchItem-add-submit.component";
import { ChooseChurchItemDeleteComponent } from "./item-operations/churchItem/delete-churchItem/choose-churchItem-delete/choose-churchItem-delete.component";
import { DeleteChurchItemSubmitComponent } from "./item-operations/churchItem/delete-churchItem/delete-churchItem-submit/delete-churchItem-submit.component";
import { ChooseChurchItemChangeComponent } from "./item-operations/churchItem/change-churchItem/choose-churchItem-change/choose-churchItem-change.component";
import { ChurchItemChangeFormComponent } from "./item-operations/churchItem/change-churchItem/churchItem-change-form/churchItem-change-form.component";
import { AfterChurchItemChangeSubmitComponent } from "./item-operations/churchItem/change-churchItem/after-churchItem-change-submit/after-churchItem-change-submit.component";
import { AddChurchItemComponent } from "./item-operations/churchItem/add-churchItem/add-churchItem.component";
import { ChangeChurchItemComponent } from "./item-operations/churchItem/change-churchItem/change-churchItem.component";
import { DeleteChurchItemComponent } from "./item-operations/churchItem/delete-churchItem/delete-churchItem.component";
import { ShowChurchItemsComponent } from "./item-operations/churchItem/show-churchItem/show-churchItems.component";
import { ChurchItemComponent } from "./item-operations/churchItem/churchItem.component";
import { SacredItemComponent } from "./item-operations/sacredItem/sacredItem.component";
import { ShowSacredItemsComponent } from "./item-operations/sacredItem/show-sacredItem/show-sacredItems.component";
import { DeleteSacredItemComponent } from "./item-operations/sacredItem/delete-sacredItem/delete-sacredItem.component";
import { ChangeSacredItemComponent } from "./item-operations/sacredItem/change-sacredItem/change-sacredItem.component";
import { AddSacredItemComponent } from "./item-operations/sacredItem/add-sacredItem/add-sacredItem.component";
import { AfterSacredItemChangeSubmitComponent } from "./item-operations/sacredItem/change-sacredItem/after-sacredItem-change-submit/after-sacredItem-change-submit.component";
import { SacredItemChangeFormComponent } from "./item-operations/sacredItem/change-sacredItem/sacredItem-change-form/sacredItem-change-form.component";
import { ChooseSacredItemChangeComponent } from "./item-operations/sacredItem/change-sacredItem/choose-sacredItem-change/choose-sacredItem-change.component";
import { DeleteSacredItemSubmitComponent } from "./item-operations/sacredItem/delete-sacredItem/delete-sacredItem-submit/delete-sacredItem-submit.component";
import { ChooseSacredItemDeleteComponent } from "./item-operations/sacredItem/delete-sacredItem/choose-sacredItem-delete/choose-sacredItem-delete.component";
import { SacredItemAddSubmitComponent } from "./item-operations/sacredItem/add-sacredItem/sacredItem-add-submit/sacredItem-add-submit.component";
import { AddSacredItemFormComponent } from "./item-operations/sacredItem/add-sacredItem/add-sacredItem-form/add-sacredItem-form.component";

// определение маршрутов
// для предметов (sacredItem)
//добавление
        const addSacredItemRouts: Routes = [
          { path: 'form', component: AddSacredItemFormComponent},
          { path: 'after-submit', component: SacredItemAddSubmitComponent},
        ];

        //удаление
        const deleteSacredItemRouts: Routes = [
          { path: 'choose', component: ChooseSacredItemDeleteComponent},
          { path: 'after-submit', component: DeleteSacredItemSubmitComponent},
        ];


        //изменеие
        const changeSacredItemRouts: Routes = [
          { path: 'choose', component: ChooseSacredItemChangeComponent},
          { path: 'change-form', component: SacredItemChangeFormComponent},
          { path: 'after-submit', component: AfterSacredItemChangeSubmitComponent},
        ];

//общий для предметов
const sacredItemRouts: Routes = [
  { path: 'add', component: AddSacredItemComponent, children: addSacredItemRouts},
  { path: 'change', component: ChangeSacredItemComponent, children: changeSacredItemRouts},
  { path: 'delete', component: DeleteSacredItemComponent, children: deleteSacredItemRouts},
  { path: 'show', component: ShowSacredItemsComponent},
];

// для предметов (sacredItem)
//добавление
const addChurchItemRouts: Routes = [
  { path: 'form', component: AddChurchItemFormComponent},
  { path: 'after-submit', component: ChurchItemAddSubmitComponent},
            ];

            //удаление
            const deleteChurchItemRouts: Routes = [
              { path: 'choose', component: ChooseChurchItemDeleteComponent},
              { path: 'after-submit', component: DeleteChurchItemSubmitComponent},
            ];


            //изменеие
            const changeChurchItemRouts: Routes = [
              { path: 'choose', component: ChooseChurchItemChangeComponent},
              { path: 'change-form', component: ChurchItemChangeFormComponent},
              { path: 'after-submit', component: AfterChurchItemChangeSubmitComponent},
            ];

      //общий для предметов
      const churchItemRouts: Routes = [
        { path: 'add', component: AddChurchItemComponent, children: addChurchItemRouts},
        { path: 'change', component: ChangeChurchItemComponent, children: changeChurchItemRouts},
        { path: 'delete', component: DeleteChurchItemComponent, children: deleteChurchItemRouts},
        { path: 'show', component: ShowChurchItemsComponent},
      ];
      // для предметов (relic)
            //добавление
            const addRelicRouts: Routes = [
              { path: 'form', component: AddRelicFormComponent},
              { path: 'after-submit', component: RelicAddSubmitComponent},
            ];

            //удаление
            const deleteRelicRouts: Routes = [
              { path: 'choose', component: ChooseRelicDeleteComponent},
              { path: 'after-submit', component: DeleteRelicSubmitComponent},
            ];


            //изменеие
            const changeRelicRouts: Routes = [
              { path: 'choose', component: ChooseRelicChangeComponent},
              { path: 'change-form', component: RelicChangeFormComponent},
              { path: 'after-submit', component: AfterRelicChangeSubmitComponent},
            ];

      //общий для предметов
      const relicRouts: Routes = [
        { path: 'add', component: AddRelicComponent, children: addRelicRouts},
        { path: 'change', component: ChangeRelicComponent, children: changeRelicRouts},
        { path: 'delete', component: DeleteRelicComponent, children: deleteRelicRouts},
        { path: 'show', component: ShowRelicsComponent},
      ];
      // для предметов
            //добавление
            const addIconRouts: Routes = [
              { path: 'form', component: AddIconFormComponent},
              { path: 'after-submit', component: IconAddSubmitComponent},
            ];

            //удаление
            const deleteIconRouts: Routes = [
              { path: 'choose', component: ChooseIconDeleteComponent},
              { path: 'after-submit', component: DeleteIconSubmitComponent},
            ];


            //изменеие
            const changeIconRouts: Routes = [
              { path: 'choose', component: ChooseIconChangeComponent},
              { path: 'change-form', component: IconChangeFormComponent},
              { path: 'after-submit', component: AfterIconChangeSubmitComponent},
            ];

      //общий для предметов
      const iconRouts: Routes = [
        { path: 'add', component: AddIconComponent, children: addIconRouts},
        { path: 'change', component: ChangeIconComponent, children: changeIconRouts},
        { path: 'delete', component: DeleteIconComponent, children: deleteIconRouts},
        { path: 'show', component: ShowIconsComponent},
      ];

            //добавление
            const addBookRouts: Routes = [
              { path: 'form', component: AddBookFormComponent},
              { path: 'after-submit', component: BookAddSubmitComponent},
            ];

            //удаление
            const deleteBookRouts: Routes = [
              { path: 'choose', component: ChooseBookDeleteComponent},
              { path: 'after-submit', component: DeleteBookSubmitComponent},
            ];


            //изменеие
            const changeBookRouts: Routes = [
              { path: 'choose', component: ChooseBookChangeComponent},
              { path: 'change-form', component: BookChangeFormComponent},
              { path: 'after-submit', component: AfterBookChangeSubmitComponent},
            ];

      //общий для предметов
      const bookRouts: Routes = [
        { path: 'add', component: AddBookComponent, children: addBookRouts},
        { path: 'change', component: ChangeBookComponent, children: changeBookRouts},
        { path: 'delete', component: DeleteBookComponent, children: deleteBookRouts},
        { path: 'show', component: ShowBooksComponent},
      ];

      // для типов
            //добавление
            const addTypeRouts: Routes = [
              { path: 'form/:urlParam', component: AddTypeFormComponent},
              { path: 'after-submit', component: TypeAddSubmitComponent},
            ];

            //удаление
            const deleteTypeRouts: Routes = [
              { path: 'choose/:urlParam', component: ChooseTypeDeleteComponent},
              { path: 'after-submit', component: DeleteTypeSubmitComponent},
            ];


            //изменение
            const changeTypeRouts: Routes = [
              { path: 'choose/:urlParam', component: ChooseTypeChangeComponent},
              { path: 'change-form', component: TypeChangeFormComponent},
              { path: 'after-submit', component: AfterChangeTypeSubmitComponent},
            ];

      //общий для типов
      const typeRouts: Routes = [
        { path: 'add', component: AddTypeComponent, children: addTypeRouts},
        { path: 'change', component: ChangeTypeComponent, children: changeTypeRouts},
        { path: 'delete', component: DeleteTypeComponent, children: deleteTypeRouts},
        { path: 'show/:urlParam', component: ShowTypesComponent},
      ];

      // для мест
            //добавление
            const addPlaceRouts: Routes = [
              { path: 'form/:urlParam', component: AddPlaceFormComponent},
              { path: 'after-submit', component: PlaceAddSubmitComponent},
            ];

            //удаление
            const deletePlaceRouts: Routes = [
              { path: 'choose/:urlParam', component: ChoosePlaceDeleteComponent},
              { path: 'after-submit', component: DeletePlaceSubmitComponent},
            ];


            //изменение
            const changePlaceRouts: Routes = [
              { path: 'choose/:urlParam', component: ChoosePlaceChangeComponent},
              { path: 'change-form', component: PlaceChangeFormComponent},
              { path: 'after-submit', component: AfterChangePlaceSubmitComponent},
            ];

      //общий для мест
      const placeRouts: Routes = [
        { path: 'add', component: AddPlaceComponent, children: addPlaceRouts},
        { path: 'change', component: ChangePlaceComponent, children: changePlaceRouts},
        { path: 'delete', component: DeletePlaceComponent, children: deletePlaceRouts},
        { path: 'show/:urlParam', component: ShowPlacesComponent},
      ];

const appRoutes: Routes =[
  { path: '', component: MainMenuComponent},
  { path: 'contacts', component: ContactsComponent},
  { path: 'about', component: AboutComponent},
  { path: 'send-backup', component: SendBackupComponent},
  { path: 'save-changes', component: SaveChangesComponent},
  // { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'book', component: BookComponent, children: bookRouts},
  { path: 'icon', component: BookComponent, children: iconRouts},
  { path: 'relic', component: RelicComponent, children: relicRouts},
  { path: 'churchItem', component: ChurchItemComponent, children: churchItemRouts},
  { path: 'sacredItem', component: SacredItemComponent, children: sacredItemRouts},
  { path: 'type', component: TypeOperationsComponent, children: typeRouts},
  { path: 'place', component: PlaceOperationsComponent, children: placeRouts},
];
@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule{}

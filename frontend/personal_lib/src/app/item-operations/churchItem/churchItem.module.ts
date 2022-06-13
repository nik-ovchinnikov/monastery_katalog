import {NgModule} from "@angular/core";
import {ChurchItemComponent} from "./churchItem.component";
import {AddChurchItemComponent} from "./add-churchItem/add-churchItem.component";
import {ChangeChurchItemComponent} from "./change-churchItem/change-churchItem.component";
import {AddChurchItemFormComponent} from "./add-churchItem/add-churchItem-form/add-churchItem-form.component";
import {ChurchItemAddSubmitComponent} from "./add-churchItem/churchItem-add-submit/churchItem-add-submit.component";
import {ChooseChurchItemDeleteComponent} from "./delete-churchItem/choose-churchItem-delete/choose-churchItem-delete.component";
import {DeleteChurchItemSubmitComponent} from "./delete-churchItem/delete-churchItem-submit/delete-churchItem-submit.component";
import {ChooseChurchItemChangeComponent} from "./change-churchItem/choose-churchItem-change/choose-churchItem-change.component";
import {ChurchItemChangeFormComponent} from "./change-churchItem/churchItem-change-form/churchItem-change-form.component";
import { AfterChurchItemChangeSubmitComponent } from './change-churchItem/after-churchItem-change-submit/after-churchItem-change-submit.component';

import { FilterByNamePipe } from "./pipes/filterChurchItem.pipe";

import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterModule} from "@angular/router";
import { ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/shared/shared.module";
import {ShowChurchItemsComponent} from "./show-churchItem/show-churchItems.component";
import {DeleteChurchItemComponent} from "./delete-churchItem/delete-churchItem.component";
import { ChurchItemListFilterComponent } from "./churchItem-list-filter/churchItem-list-filter.component";

@NgModule({
  declarations: [
    ChurchItemComponent,
    AddChurchItemComponent,
    ChangeChurchItemComponent,
    DeleteChurchItemComponent,
    ShowChurchItemsComponent,
    AddChurchItemFormComponent,
    ChurchItemAddSubmitComponent,
    ChooseChurchItemDeleteComponent,
    DeleteChurchItemSubmitComponent,
    ChooseChurchItemChangeComponent,
    ChurchItemChangeFormComponent,
    AfterChurchItemChangeSubmitComponent,

    FilterByNamePipe,
    ChurchItemListFilterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  exports: [
    ChurchItemComponent,
    AddChurchItemComponent,
    ChangeChurchItemComponent,
    DeleteChurchItemComponent,
    ShowChurchItemsComponent,
    AddChurchItemFormComponent,
    ChurchItemAddSubmitComponent,
    ChooseChurchItemDeleteComponent,
    DeleteChurchItemSubmitComponent,
    ChooseChurchItemChangeComponent,
    ChurchItemChangeFormComponent,
    AfterChurchItemChangeSubmitComponent,
  ],
  providers: [],
})
export class ChurchItemModule {

}

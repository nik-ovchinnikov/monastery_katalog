import {NgModule} from "@angular/core";
import {SacredItemComponent} from "./sacredItem.component";
import {AddSacredItemComponent} from "./add-sacredItem/add-sacredItem.component";
import {ChangeSacredItemComponent} from "./change-sacredItem/change-sacredItem.component";
import {AddSacredItemFormComponent} from "./add-sacredItem/add-sacredItem-form/add-sacredItem-form.component";
import {SacredItemAddSubmitComponent} from "./add-sacredItem/sacredItem-add-submit/sacredItem-add-submit.component";
import {DeleteSacredItemSubmitComponent} from "./delete-sacredItem/delete-sacredItem-submit/delete-sacredItem-submit.component";
import {ChooseSacredItemChangeComponent} from "./change-sacredItem/choose-sacredItem-change/choose-sacredItem-change.component";
import {SacredItemChangeFormComponent} from "./change-sacredItem/sacredItem-change-form/sacredItem-change-form.component";
import { AfterSacredItemChangeSubmitComponent } from './change-sacredItem/after-sacredItem-change-submit/after-sacredItem-change-submit.component';

import { FilterByNamePipe } from "./pipes/filterSacredItem.pipe";

import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterModule} from "@angular/router";
import { ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/shared/shared.module";
import {ShowSacredItemsComponent} from "./show-sacredItem/show-sacredItems.component";
import {DeleteSacredItemComponent} from "./delete-sacredItem/delete-sacredItem.component";
import { SacredItemListFilterComponent } from "./sacredItem-list-filter/sacredItem-list-filter.component";
import {ChooseSacredItemDeleteComponent} from "./delete-sacredItem/choose-sacredItem-delete/choose-sacredItem-delete.component";

@NgModule({
  declarations: [
    SacredItemComponent,
    AddSacredItemComponent,
    ChangeSacredItemComponent,
    DeleteSacredItemComponent,
    ShowSacredItemsComponent,
    AddSacredItemFormComponent,
    SacredItemAddSubmitComponent,
    ChooseSacredItemDeleteComponent,
    DeleteSacredItemSubmitComponent,
    ChooseSacredItemChangeComponent,
    SacredItemChangeFormComponent,
    AfterSacredItemChangeSubmitComponent,

    FilterByNamePipe,
    SacredItemListFilterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  exports: [
    SacredItemComponent,
    AddSacredItemComponent,
    ChangeSacredItemComponent,
    DeleteSacredItemComponent,
    ShowSacredItemsComponent,
    AddSacredItemFormComponent,
    SacredItemAddSubmitComponent,
    ChooseSacredItemDeleteComponent,
    DeleteSacredItemSubmitComponent,
    ChooseSacredItemChangeComponent,
    SacredItemChangeFormComponent,
    AfterSacredItemChangeSubmitComponent,
  ],
  providers: [],
})
export class SacredItemModule {

}

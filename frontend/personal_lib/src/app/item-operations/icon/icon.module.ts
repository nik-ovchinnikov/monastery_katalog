import {NgModule} from "@angular/core";
import {IconComponent} from "./icon.component";
import {AddIconComponent} from "./add-icon/add-icon.component";
import {ChangeIconComponent} from "./change-icon/change-icon.component";
import {DeleteIconComponent} from "./delete-icon/delete-icon.component";
import {ShowIconsComponent} from "./show-icons/show-icons.component";
import {AddIconFormComponent} from "./add-icon/add-icon-form/add-icon-form.component";
import {IconAddSubmitComponent} from "./add-icon/icon-add-submit/icon-add-submit.component";
import {ChooseIconDeleteComponent} from "./delete-icon/choose-icon-delete/choose-icon-delete.component";
import {DeleteIconSubmitComponent} from "./delete-icon/delete-icon-submit/delete-icon-submit.component";
import {ChooseIconChangeComponent} from "./change-icon/choose-icon-change/choose-icon-change.component";
import {IconChangeFormComponent} from "./change-icon/icon-change-form/icon-change-form.component";
import { AfterIconChangeSubmitComponent } from './change-icon/after-icon-change-submit/after-icon-change-submit.component';

import { FilterByNamePipe } from "./pipes/filterIcon.pipe";
import {IconListFilterComponent} from "./icon-list-filter/icon-list-filter.component";

import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterModule} from "@angular/router";
import { ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/shared/shared.module";

@NgModule({
  declarations: [
    IconComponent,
    AddIconComponent,
    ChangeIconComponent,
    DeleteIconComponent,
    ShowIconsComponent,
    AddIconFormComponent,
    IconAddSubmitComponent,
    ChooseIconDeleteComponent,
    DeleteIconSubmitComponent,
    ChooseIconChangeComponent,
    IconChangeFormComponent,
    AfterIconChangeSubmitComponent,

    FilterByNamePipe,
    IconListFilterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  exports: [
    IconComponent,
    AddIconComponent,
    ChangeIconComponent,
    DeleteIconComponent,
    ShowIconsComponent,
    AddIconFormComponent,
    IconAddSubmitComponent,
    ChooseIconDeleteComponent,
    DeleteIconSubmitComponent,
    ChooseIconChangeComponent,
    IconChangeFormComponent,
    AfterIconChangeSubmitComponent,
  ],
  providers: [],
})
export class IconModule {

}

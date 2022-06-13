import {NgModule} from "@angular/core";
import {RelicComponent} from "./relic.component";
import {AddRelicComponent} from "./add-relic/add-relic.component";
import {ChangeRelicComponent} from "./change-relic/change-relic.component";
import {ShowRelicsComponent} from "./show-relics/show-relics.component";
import {AddRelicFormComponent} from "./add-relic/add-relic-form/add-relic-form.component";
import {RelicAddSubmitComponent} from "./add-relic/relic-add-submit/relic-add-submit.component";
import {ChooseRelicDeleteComponent} from "./delete-relic/choose-relic-delete/choose-relic-delete.component";
import {ChooseRelicChangeComponent} from "./change-relic/choose-relic-change/choose-relic-change.component";
import {RelicChangeFormComponent} from "./change-relic/relic-change-form/relic-change-form.component";
import { AfterRelicChangeSubmitComponent } from './change-relic/after-relic-change-submit/after-relic-change-submit.component';
import {DeleteRelicComponent} from "./delete-relic/delete-relic.component";
import {DeleteRelicSubmitComponent} from "./delete-relic/delete-relic-submit/delete-relic-submit.component";



import { FilterByNamePipe } from "./pipes/filterRelic.pipe";
import {RelicListFilterComponent} from "./relic-list-filter/relic-list-filter.component";

import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../../app-routing.module";
import {RouterModule} from "@angular/router";
import { ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/shared/shared.module";

@NgModule({
  declarations: [
    RelicComponent,
    AddRelicComponent,
    ChangeRelicComponent,
    DeleteRelicComponent,
    ShowRelicsComponent,
    AddRelicFormComponent,
    RelicAddSubmitComponent,
    ChooseRelicDeleteComponent,
    DeleteRelicSubmitComponent,
    ChooseRelicChangeComponent,
    RelicChangeFormComponent,
    AfterRelicChangeSubmitComponent,

    FilterByNamePipe,
    RelicListFilterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  exports: [
    RelicComponent,
    AddRelicComponent,
    ChangeRelicComponent,
    DeleteRelicComponent,
    ShowRelicsComponent,
    AddRelicFormComponent,
    RelicAddSubmitComponent,
    ChooseRelicDeleteComponent,
    DeleteRelicSubmitComponent,
    ChooseRelicChangeComponent,
    RelicChangeFormComponent,
    AfterRelicChangeSubmitComponent,
  ],
  providers: [],
})
export class RelicModule {

}

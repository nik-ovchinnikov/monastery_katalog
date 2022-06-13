import { Component, Input, OnInit } from '@angular/core';
import { TemplateData } from './templateData';

@Component({
  selector: 'app-template-type-catalog',
  templateUrl: './template-type-catalog.component.html',
  styleUrls: ['./template-type-catalog.component.css']
})
export class TemplateTypeCatalogComponent implements OnInit {

  showBookCatalog = false;
  @Input()
  catalogType = "";
  templateDataMap = new Map([
   ["book", new TemplateData('книг', 'Книги', 'book')],
   ["icon", new TemplateData('Святых Икон', 'Святые Иконы', 'icon')],
   ["relic", new TemplateData('частиц Святых Мощей', 'Святые Мощи', 'relic')],
   ["sacredItems", new TemplateData('Священных предметов', 'Священные предметы', 'sacredItem')],
   ["churchItems", new TemplateData('Церковной утвари', 'Церковная утварь', 'churchItem')],
  ]);
  title: any;
  column: any;
  urlParam: any;
  changeItemUrl = "";
  deleteItemUrl = "";
  addItemUrl = "";
  showItemUrl = "";

  constructor() { }

  ngOnInit(): void {
    this.title = this.templateDataMap.get(this.catalogType)?.typeInTitle;
    this.column= this.templateDataMap.get(this.catalogType)?.typeInColumn;
    this.urlParam= this.templateDataMap.get(this.catalogType)?.typeInURL;
    this.changeItemUrl = this.urlParam + "/change/choose";
    this.deleteItemUrl = this.urlParam + "/delete/choose";
    this.addItemUrl = this.urlParam + "/add/form";
    this.showItemUrl = this.urlParam + "/show";
  }

  onBooksClicked() {
    this.showBookCatalog = !this.showBookCatalog;
  }

}

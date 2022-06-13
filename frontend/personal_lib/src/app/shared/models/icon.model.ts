import { Picture } from "./picture.model";
import { Place } from "./place.model";
import { SubPlace } from "./subPlace.model";
import { SubType } from "./subType.model";
import { Type } from "./type.model";
import { CommonPrototype } from "./common-prototype.interface";
import { ItemPrototype } from "./itemPrototype.interface";

export class Icon implements CommonPrototype, ItemPrototype {
  constructor(
    public name: string = '',
    public author: string = '',
    public publishYear: number = -1,
    public publisher: string = '',
    public seria: string = '',
    public weight: string = '',
    public size: string = '',
    public description: string = '',
    public key: string = '',
    public material: string = '',
    public type: Type = new Type(),
    public subType: SubType = new SubType(),
    public place: Place = new Place(),
    public subPlace: SubPlace = new SubPlace(),
    public pictureList: Picture[] = [],
    public creationDate: Date = new Date(),
    public lastChangeDate: Date = new Date(),
    public id: number = -1,
  ) {

  }
}

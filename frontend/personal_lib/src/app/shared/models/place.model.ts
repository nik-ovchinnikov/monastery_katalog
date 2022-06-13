import { SubPlace } from "./subPlace.model";

export class Place {
  constructor(
    public name: string = "",
    public description: string = "",
    public subPlaceList: SubPlace[] = [],
    public creationDate: Date = new Date(),
    public lastChangeDate: Date = new Date(),
    public id: number = -1,
  ) {

  }
  public subplacesToString(): string {
    let resultString: string = "";
    for(let subPlace of this.subPlaceList) {
      resultString = resultString + " " + subPlace.name;
    }
    return resultString;
  }
}

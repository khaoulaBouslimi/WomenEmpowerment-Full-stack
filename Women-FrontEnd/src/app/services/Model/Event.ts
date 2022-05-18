import { Byte } from "@angular/compiler/src/util";

export class Event{
    asObservable() {
      throw new Error('Method not implemented.');
    }
    id:number;
    eventTopic:string;
    description:string;
    date:Date;
    data:any;
    fileType:String;
    fileName:String;
    videoName:String;
    videoType:String;
    dataVideo:any;
}
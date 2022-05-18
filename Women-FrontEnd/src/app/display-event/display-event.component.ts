import { Component, OnInit } from '@angular/core';
import { EventServiceService } from 'src/app/services/event/event-service.service';
import { Router } from '@angular/router';
import { Event } from 'src/app/services/Model/Event'; 
import { ToastrService } from 'ngx-toastr';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { finalize } from 'rxjs';


@Component({
  selector: 'app-display-event',
  templateUrl: './display-event.component.html',
  styleUrls: ['./display-event.component.css']
})

export class DisplayEventComponent implements OnInit {
  events:Event[]
  event:Event
  event1:Event
  blob:Blob;
  p: number = 1;
  index:number=1;
  searchTerm: string;
  term: string;
  myForm: FormGroup;
  id:number;
  submitted = false;
  showMore=false;
  imgSrc="";
  file:any;
  file1:any;
  urlVideo:any;
  fileTypeVideo:any;
  loading:boolean=false;
  constructor(private router:Router,private eventService:EventServiceService,private toastr: ToastrService,private modalService: NgbModal) { }


  ngOnInit(): void {

    this.getAllEvents();
    this.event=new Event();
    this.myForm= new FormGroup({
      'eventTopic':new FormControl(this.event.eventTopic,Validators.required),
      'date':new FormControl(this.event.date,Validators.required),
      'description':new FormControl(this.event.description,Validators.required),
      'pic':new FormControl(this.event.description)

    })
  }
  onSelectedVideo(event:any,id:number){
    this.file1 = event.target.files[0];
    const fileReader = new FileReader()
    fileReader.readAsDataURL (this.file1);
    fileReader.onload = () => {
      // You'll get the base64 string here
    let data={
      fileName:this.file1.name,
      fileType:this.file1.type,
      data:this.file1
    }
    var blob = new Blob([this.file1], {type: this.file1.type});
    this.event.dataVideo=String(fileReader.result).replace("data:"+this.file1.type+";base64,", "");
    this.event.videoType=this.file1.type;
    this.event.videoName=this.file1.name;
    
    
  }
  }
  onFileSelected(event:any,id:number) {
    
    this.file = event.target.files[0];
    const fileReader = new FileReader()
    fileReader.readAsDataURL(this.file);
    fileReader.onload = () => {
      // You'll get the base64 string here
      
  

    let data={
      fileName:this.file.name,
      fileType:this.file.type,
      data:this.file
    }
   
    this.event.data=String(fileReader.result).replace("data:"+this.file.type+";base64,", "");
    this.event.fileType=this.file.type;
    this.event.fileName=this.file.name;
    
    console.log(this.event)
  }
  }
  showAndHide(){
    if(this.showMore){
      this.showMore=false;
    }else{
      this.showMore=true;
    }
  }
  getAllEvents(){
    this.eventService.getAllEvents().subscribe((res)=>{
      
      this.events=res;

    })
  }

  deleteEvent(id:Number){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.eventService.deleteEvent(id).subscribe((res)=>{
          this.getAllEvents();
          this.toastr.success('Event deleted !','Delete Event');
        }),()=>this.toastr.error('Error !','Delete Event');
      }
    })
    
  }
  updateEvent(id:number,content:any){
    this.submitted = true;
    if (this.myForm.invalid) {
      return;
     }
     let data={

     }
     this.eventService.updateEvent(id,this.myForm.value).subscribe((Event)=>{
       
      this.getAllEvents();
      this.close(content);
      this.toastr.success("Update effected successfuly","Update Event");
     }),()=>()=>this.toastr.error('Error !','Update Event');
  }
  editEvent(id:number,content:any){
    this.getEventById(id);
    this.id=id;
    this.open(content);

  }

  addEventOpen(content:any){
    this.open(content);
  }

  addEvent(content:any){
    this.submitted = true;
    
    if (this.myForm.invalid) {
      return;
     }
     this.loading=true;
     this.eventService.addEvent(this.event).pipe(finalize(() => this.loading = false)).subscribe((res)=>{
      this.toastr.success('Event added successfuly','Added event !');
      this.router.navigate(["/event/all"]);
      this.close(content);
     }),()=>this.toastr.error("Error !","Added event");
     
    
  }

  
  getEventById(id:number){
    this.eventService.getEventById(id).subscribe((Event)=>{
      this.event=Event;
    })
  }
  open(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res:any) => {
     // this.closeResult = `Closed with: ${result}`;
    }, (reason:any) => {
      this.getAllEvents();
      this.event=new Event();
    });
  }
  close(content:any) {
    this.modalService.dismissAll(content);
  }

  diplayVideo(video:any,fileType:any,content:any){
    this.urlVideo=video;
    this.fileTypeVideo=fileType;
    this.open(content);
  }
  image(img:any,fileType:any){
    this.imgSrc='data:'+fileType+';base64,' + img;
    return this.imgSrc;
  }
  
}

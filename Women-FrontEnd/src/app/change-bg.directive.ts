import {  Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appChangeBg]'
})
export class ChangeBgDirective {

  @Input() isCorrect : Boolean = false;
  constructor(private el : ElementRef, private rendrer :Renderer2) { }

  @HostListener('click') answer(){
    if(this.isCorrect){
      this.rendrer.setStyle(this.el.nativeElement, 'background', 'green');
      this.rendrer.setStyle(this.el.nativeElement, 'color', '#fff');
      this.rendrer.setStyle(this.el.nativeElement, 'border', '2px solid grey');
    }else{
      this.rendrer.setStyle(this.el.nativeElement, 'background', 'red');
      this.rendrer.setStyle(this.el.nativeElement, 'color', '#fff');
      this.rendrer.setStyle(this.el.nativeElement, 'border', '2px solid grey');
    }
  }
}

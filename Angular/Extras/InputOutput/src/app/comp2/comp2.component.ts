import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-comp2',
  templateUrl: './comp2.component.html',
  styleUrls: ['./comp2.component.css']
})
export class Comp2Component {

  @Input()
  firstName?:string;

  @Output()
  firstNameChange = new EventEmitter<string>();

  firstNameChanged(value?:string){
    console.log(value);
    this.firstNameChange.emit(value);
  }
}

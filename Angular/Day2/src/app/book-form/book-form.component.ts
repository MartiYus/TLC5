import { Component } from '@angular/core';
import { BookDetailComponent } from '../book-detail/book-detail.component';
import { Book } from '../model/Book';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent {
 book:Book = new Book;

 onSubmit(){
  console.log(this.book);
  this.book = new Book;
 }
}

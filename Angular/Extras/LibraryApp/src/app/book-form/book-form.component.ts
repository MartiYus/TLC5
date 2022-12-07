import { Component, OnInit } from '@angular/core';
import { BookDetailComponent } from '../book-detail/book-detail.component';
import { Book } from '../model/Book';
import { Category } from '../model/Category';
import { BookServiceService } from '../service/book-service.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {

  constructor(private service: BookServiceService){
  }

 ngOnInit(): void {
  this.service.getAllCategories().subscribe(value => this.categories = value);
 }

 book:Book = new Book;
 categories : Category[] = [];
 error?: string;

 onSubmit(){
  this.book.pub_Date = new Date;
  this.book.availability = 'yes';
  this.service.saveNewBook(this.book).subscribe({
    next: value => this.book = new Book,
    error: error => this.error = error
  });
 }
}

import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../model/Book';
import { BookServiceService } from '../service/book-service.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent {
  
  constructor(private route: ActivatedRoute, private service:BookServiceService){
    this.route.params.subscribe(params => this.getBook(params) );
  }

  getBook(params:any){
    if (Object.keys(params).length === 0 ){
      this.book = new Book;
    }
    else {
      this.service.getBookById(params.isbn).subscribe(value => this.book = value )
  }
  }

  book?:Book = new Book;
}

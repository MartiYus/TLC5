import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../model/Book';
import { BookServiceService } from '../service/book-service.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit{

  constructor(private router : Router, private service: BookServiceService){
  }

  ngOnInit(): void {
    this.service.getAllBooks().subscribe(value => {
      this.books = value;
      this.dataSource = this.books;
    })
    
  }

  title:string = "Library books";

  books: Book[] = [];

  displayedColumns: string[] = ['ISBN', 'Title', 'Author', 'Description', 'Publisher'];
  
  dataSource: any;

  getBookDetail(row:any){
    this.router.navigate(['bookDetail',row.isbn] );
  }

}

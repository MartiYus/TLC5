import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from '../model/Book';
import { Category } from '../model/Category';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  private static readonly BOOKS_PATH = '/books';

  private static readonly CATEGORY_PATH = '/categories-all';

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    const url = this.buildUrl(BookServiceService.BOOKS_PATH);
    return this.http.get<Book[]>(url);
  }

  getBookById(isbn?: string): Observable<Book> {
    const url = this.buildUrl(BookServiceService.BOOKS_PATH) + '/' + isbn;
    return this.http.get<Book>(url);
  }

  getAllCategories(): Observable<Category[]>{
    const url = this.buildUrl(BookServiceService.CATEGORY_PATH);
    return this.http.get<Category[]>(url);
  }

  saveNewBook(book:Book): Observable<string>{
    const url = this.buildUrl(BookServiceService.BOOKS_PATH);
    return this.http.post<any>(url, book).pipe(
      catchError(this.handleError)
    );
  }

  private buildUrl(path: string): string {
    return `${environment.baseUrl}${path}`
  }

  private handleError(error: any): Observable<never> {
    throw new Error('Oops something went wrong! Please try again later.');
  }
}

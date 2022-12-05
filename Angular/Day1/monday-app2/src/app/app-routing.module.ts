import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BooksComponent } from './books/books.component';

const routes: Routes = [
  {path :'', redirectTo: 'books', pathMatch: 'full'},
  {path: 'books', component: BooksComponent},
  {path:'bookDetail', component: BookDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

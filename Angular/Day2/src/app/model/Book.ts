import { Category } from "./Category";

export class Book{
    isbn: string = '';
 title: string='';
 author: string ='';
 description : string = '';
 pub_Date: string ='';
 availability: string = '';
 publisher: string ='';
 cat ?: Category;

}
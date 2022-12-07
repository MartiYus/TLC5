import { Category } from "./Category";

export class Book{
    isbn: string = '';
 title: string='';
 author: string ='';
 description : string = '';
 pub_Date?: Date;
 availability: string = '';
 publisher: string ='';
 cat ?: Category;

}
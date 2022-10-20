insert into loan(loan_date, user_id, book_id, expected_date) values (now(), (select user_id from lib_user where first_name = 'Tooth'), (select isbn from book where title = 'Jane Eyre'), now() + interval '3 week')

insert into loan(loan_date, user_id, book_id, expected_date) values ( now(), 3, '3524635', now() + interval '3 week' );





select * from user_detail;

select * from book;

select * from loan;

select * from category;


select * from book where availability='yes'

--get all information about a book
select * from book inner join category
on category_id = id;

select b.isbn, b.title, b.author, b.description, b.availability, c.name
from book b join category c
on category_id = id

select b.isbn, b.title, b.author, b.description, b.availability, c.name
from book b left outer join category c
on category_id = id

--get all information for a lib user
select l.first_name, l.last_name, u.street, u.city, u.phone_number, u.email
from lib_user l inner join user_detail as u 
on l.detail_id = u.detail_id 


--get all information for a loan
select * from loan

select l.loan_date, l.actual_date, b.title, b.author, u.first_name, u.last_name
from loan l 
inner join book b on l.book_id = b.isbn
inner join lib_user u on l.user_id = u.user_id 

--get the history of loans for tooth fairy (user_id 2)
select l.loan_date, l.actual_date, b.title, b.author, u.first_name, u.last_name
from loan l 
inner join book b on l.book_id = b.isbn
inner join lib_user u on l.user_id = u.user_id 
where u.user_id = 2

--see who borrowed Outlander book (isbn = 3524635)
select l.loan_date, l.actual_date, b.title, b.author, u.first_name, u.last_name
from loan l 
inner join book b on l.book_id = b.isbn
inner join lib_user u on l.user_id = u.user_id 
where b.isbn = '3524635'

--find the user who owes the most money
select u.first_name, u.last_name, sum(l.fee) as sum_fees
from loan l 
inner join lib_user u on l.user_id = u.user_id
group by u.first_name, u.last_name 
order by sum_fees desc
fetch first 1 rows only

--loan a book
select * from loan;

--update statement
update book set availability = 'yes' where isbn='2333647'

insert into loan(loan_date, user_id, book_id, expected_date) values (now(), 3, '2333647', now() + interval '3 week')

--delete statement
delete from loan where loan_id = 7

--return a book
update book set availability = 'yes' where isbn='123456'

update loan set actual_date = now() where loan_id=6

--update book set availability  = 'no' where isbn='3524635'



--sub-queries for loan book
update book set availability = 'no' where isbn = (select isbn from book where title='Scala')

insert into loan(loan_date, user_id, book_id, expected_date) 
values( now(), (select user_id from lib_user where first_name='Santa'),
(select isbn from book where title='Scala'), now() + interval '3 week')


--most borrowed books
select count(user_id), book_id from loan 
group by book_id



-- create view for loan table
create view loan_information as
select l.loan_date, l.actual_date, b.title, b.author, u.first_name, u.last_name
from loan l 
inner join book b on l.book_id = b.isbn
inner join lib_user u on l.user_id = u.user_id 

select * from loan_information

select loan_date, title, author from loan_information


--book view 
create view book_view (isbn, title, author, category) as 
select isbn, title, author, name from book join category on book.category_id = category.id
--drop view book_view
select * from book_view


--stored procedure to borrow a book
create or replace procedure borrow_book(
book_id varchar(15),
user_id int )

language plpgsql as $$
begin 
	-- marking book as on loan
	update book set availability = 'no' where isbn = book_id;
	-- creating new loan
	insert into loan(loan_date, user_id, book_id, expected_date) values (now(), user_id, book_id, now() + interval '3 week');

end;$$


call borrow_book('123456', 1)


-- user management

create user martina with password 'martina'

grant connect on database postgres to martina

grant select on all tables in schema public to martina

-- loan_info view 
create view loan_info as
select l.loan_date, l.actual_date, b.title, b.author, u.first_name, u.last_name
from loan l 
inner join book b on l.book_id = b.isbn
inner join lib_user u on l.user_id = u.user_id

select * from loan_info


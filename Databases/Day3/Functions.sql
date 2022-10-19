insert into category(name) values('Spooky');

--select * from book;

insert into book values ('3243525', 'Dracul', 'Dacre Stoker', 'Biographical novel about Dracula and its author', 4, '08-15-2018', 'Black Swan', 'yes');

update book set category_id = 7 where isbn='3243525';

insert into user_detail (street, city, phone_number, email) values ('Deep Forest', 'Forest', '0743256553', 'unicorn@email.com');

insert into lib_user(first_name, last_name, detail_id) values ('Sparkly', 'Unicorn',3);

insert into loan(loan_date, user_id, book_id, expected_date) values ( now(), 3, '3243525', now() + interval '3 week' );

update book set availability  = 'no' where isbn='3243525';

--like
select * from book where title like '_____'

--case insensitive like
select title from book where title ilike 'outlander'

select * from book where title ilike 'o%'


select cast(loan_date as int) from loan;

--time between now and the loan_date
select age(now(), loan_date) from loan;

--create an old loan
insert into loan(loan_date, user_id, book_id, expected_date) values ( '01-01-2022', 1, '4327843', now() + interval '3 week' );

select * from book;



select * from loan where age(now(), loan_date) > interval '21 days'

SELECT TO_CHAR(loan_date , 'dd/mm/yyyy') from loan;

select  now() - loan_date from loan

--title case
select initcap(author) from book; 

select * from book;

--replaces every character matching 'Jane' by corresponding character from '1234'
select translate(title, 'Jane', '1234') from book;


--database starts with position 1
select substr(title, 1 ,7) from book;

select * from lib_user;

select substr(first_name, 1, 1), last_name from lib_user;

--print first and last name of borrowers in the format F. Lastname
select concat( substr(first_name, 1, 1),'. ', last_name ) borrower from lib_user;


-- functions examples

select extract(year from expected_date) from loan;


select concat(first_name, last_name) from lib_user;


--updating fee for the old loan
update loan set fee = 100 where loan_id = 3

select * from loan

select user_id, sum(fee) from loan group by user_id;
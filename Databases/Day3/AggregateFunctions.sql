select * from loan;

--sum
 --sum of fees owed

select sum(fee) from loan;

--avg
 --avg fees owed

select round(avg(fee), 2) from loan; 

--count
 --number of loans
select user_id, count(loan_id) from loan
group by user_id
having count(loan_id) >1
;

--max
 -- highest fee calculated for a user
  select max(fee) from loan;
 
select fee from loan 
order by fee desc;

--min
  -- lowest fee calculated for a user
select min(fee) from loan
where fee>0;

select fee from loan where fee>0
order by fee 
fetch first 1 rows only;


--group by
 -- return total fees by user id
select user_id, fee, max(fee) from loan 
group by user_id, fee 
--having max(fee) >= 200;





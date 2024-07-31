-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 출력하시오
explain analyze 
select name
from customer
where custid in (select custid
				from orders
				where bookid in (select bookid
								from book
								where publisher = "대한미디어")
);

select c.name
from customer c, book b, orders o
where c.custid = o.custid and o.bookid = b.bookid
and b.publisher = "대한미디어";

-- 대한민국에 거주하시는 고객리스트 출력
select *
from customer
where address like "대한민국%";

-- 도서를 주문한 고객리스트 출력 -> 서브쿼리 사용
select *
from customer
where custid in (select custid 
				from orders);
                
-- 대한민국에 거주하는 고객의 이름과 도서를 주문한 고객의 이름을 출력하세요
explain analyze select name
from customer
where address like "대한민국%"
-- union 중복제거된 합집합
-- union all 모든 합집합
union all
select name
from customer
where custid in (select custid from orders);


select *
from customer
union all
select *
from book;

-- 주문이 있는 고객의 이름과 주소를 나타내시오
select name, address
from customer c
where exists (select *
				from orders o
                where c.custid = o.custid);
select * from orders;

create table NewBook(
	bookid integer primary key,
    bookname varchar(20),
    publisher varchar(20),
    price integer
);

-- 복합키 쓰는 경우
-- Code table
-- id_1 : 대분류 -> 0 : 회원관련
-- id_2 : 중분류 -> 0 : 회원가입 1 : 로그인/로그아웃
-- id_3 : 소분류 -> 0 : 가입성공
-- msg : 출력될 내용
-- create table tblCode(
-- 	id_1 char(2) not null,
--     id_2 char(2) not null,
--     id_3 char(3) not null,
--     msg varchar(60) not null,
--     primary key(id_1, id_2, id_3)
-- );

-- insert into tblCode ('00','00','000','회원가입을 환영합니다.');
-- insert into tblCode ('00','01','001','로그인되었습니다.');
-- insert into tblCode ('00','01','002','로그아웃되었습니다.');
-- insert into tblCode ('00','00','001','중복된 아이디입니다.');

create table NewCustomer(
	custid Integer primary key,
    name varchar(40),
    address varchar(40),
    phone varchar(30)
);
 
create table NewOrders(
	orderid integer primary key,
    custid integer not null unique,
    bookid integer not null,
    saleprice integer,
    orderdate date,
    foreign key (custid) references NewCustomer(custid)
);

alter table NewBook add isbn varchar(13);

alter table NewBook modify isbn integer;

alter table NewBook drop isbn;

desc NewBook;

alter table NewBook modify bookname varchar(20) not null;

alter table Newbook add primary key (bookname, publisher);

drop table newcustomer;

-- SELECT column FROM table;
-- UPDATE table SET column;

INSERT INTO book(bookid, bookname, publisher, price)
		VALUES(11, '스포츠 의학', '한솔의학서적', 90000);
        

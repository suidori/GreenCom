use madangdb;

-- select custid as '아이디', count(*) as '총수량', SUM(saleprice) as '총가격'
-- from orders 
-- where (saleprice >= 8000)
-- group by custid
-- having count(*)>=2;

-- select customer.name, bookname
-- from orders, customer, book
-- where orders.custid = customer.custid && orders.bookid = book.bookid
-- order by book.bookname;

-- select customer.name, book.bookname
-- from orders, customer, book
-- where orders.custid = customer.custid && orders.bookid = book.bookid && book.price>=20000
-- order by book.bookname;

select book.bookname
from book where book.bookid = 1;
-- 도서번호가 1인 도서의 이름

select book.bookname
from book where book.price >= 20000;
-- 가격이 2만원 이상인 도서의 이름

select SUM(orders.saleprice) as '총구매금액'
from orders, customer
where orders.custid = customer.custid && customer.name = '박지성';
-- 박지성의 총구매금액

select count(*) as '총구매갯수'
from orders, customer
where orders.custid = customer.custid && customer.name = '박지성';
-- 박지성이 구매한 도서의 수

select count(book.publisher) as '출판사갯수'
from orders, customer, book
where orders.custid = customer.custid && customer.name = '박지성' && orders.bookid = book.bookid;
-- 박지성이 구매한 도서의 출판사 수

select book.bookname as '도서명', book.price as '가격' , book.price-orders.saleprice as '정가와 판매가의 차이'
from orders, customer, book
where orders.custid = customer.custid && customer.name = '박지성' && orders.bookid = book.bookid;
-- 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이

select book.bookname as '도서명'
from orders, customer, book
where orders.custid = customer.custid && customer.name != '박지성' && orders.bookid = book.bookid;
-- 박지성이 구매하지 않은 도서의 이름

select count(*)
from book;
-- 마당서점 도서의 총개수

select count(distinct book.publisher)
from book;
-- 마당서점에 도서를 납품하는 출판사의 총개수

select customer.name as '이름' , customer.address as '주소'
from customer;
-- 모든 고객의 이름, 주소

select book.bookname as '도서명'
from book, orders
where orders.bookid = book.bookid && orders.orderdate in('2024-07-04', '2024-07-05', '2024-07-06', '2024-07-07');
-- 2024년 7월 4일부터 2024년 7월 7일 사이에 주문된 도서의 목록

select customer.name as '이름', customer.address as '주소'
from customer
where customer.name like '김%';
-- 성이 김씨인 고객의 이름과 주소

select customer.name as '이름', customer.address as '주소'
from customer
where customer.name like '김%' && customer.name like '%아';
-- 성이 김씨이고 이름이 아로 끝나는 고객의 이름과 주소

select SUM(orders.saleprice) as '총액', avg(orders.saleprice) as '평균금액'
from orders;
-- 주문 금액의 총액과 평균금액

select customer.name as '이름', SUM(orders.saleprice) as '구매액'
from orders, customer
where orders.custid = customer.custid
group by customer.custid;
-- 고객의 이름과 고객별 구매액

select customer.name as '이름', book.bookname as '도서명'
from orders, customer, book
where orders.bookid=book.bookid && orders.custid = customer.custid
order by customer.custid;
-- 고객의 이름과 고객이 구매한 도서목록

select bookname from book
where price = (select max(price) from book);
-- 가장 비싼 책

select name
from customer
where custid in (select distinct custid from orders);
-- 책을 구매한 적 있는 고객의 이름

select name
from customer
where custid in (select custid 
				from orders
				where bookid in(select bookid
								from book
								where publisher like '대한미디어')
);

-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 출력하세요.

select name from customer
where address like '대한민국%'
union
select name from customer
where custid in (select custid from orders);
-- 대한민국에 거주하는 고객의 이름과 도서를 주문한 고객의 이름을 출력하세요

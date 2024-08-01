SELECT ABS(-78), ABS(78);

SELECT round(4.875, 1);

SELECT custid, round(AVG(saleprice), -2)
from orders
GROUP BY orders.custid;

SELECT CONCAT('마당', '서점');
SELECT LOWER('POWER');
SELECT UPPER('nopower');
SELECT LPAD('PAGE 1', 10, '*');
SELECT REPLACE('JACK & JUE', 'J', 'B');
SELECT RPAD('AbC', 5, '*');
SELECT SUBSTR('ABCDEF', 3, 4);
SELECT TRIM('=' FROM '==BROWNING==');
SELECT ASCII('D');
SELECT LENGTH('CANDIDE');
SELECT CHAR_LENGTH('데이터');

SELECT bookid, REPLACE(bookname, '야구', '농구')
FROM book;

SELECT bookname AS '제목', CHAR_LENGTH(bookname) AS '문자 수', LENGTH(bookname) AS '바이트 수'
FROM book WHERE publisher = '굿스포츠';

SELECT SUBSTR(name,1,1) '성', COUNT(*) '인원'
FROM customer
GROUP BY 성;

SELECT ADDDATE('2024-07-01', INTERVAL -5 DAY) before5,
ADDDATE('2024-07-01', INTERVAL 5 DAY) after5;

SELECT orderid '주문번호', orderdate '주문일자',  ADDDATE(orderdate, INTERVAL 10 DAY) '확정일자'
FROM orders;
-- 마당서점은 주문일로부터 10일 후에 매출을 확정한다. 각 주문의 확정일자를 구하세요.

SELECT orderid 주문번호, DATE_FORMAT(orderdate, '%y%m%d') '주문일1', DATE_FORMAT(orderdate, '%M %d %Y') '주문일2', DATE_FORMAT(orderdate, '%Y-%m-%d %a') '주문일3', custid '고객ID', orders.bookid '도서ID'
FROM book, orders
WHERE orders.bookid = book.bookid AND orderdate = '2024-07-04';

select * from Vorders;

select * from vw_Customer;

select * from Vbookorder;

SELECT orderid 주문번호, bookname 도서명, saleprice 주문액
FROM Vbookorder
WHERE name = '김연아';

SELECT COUNT(phone) FROM customer;

CREATE TABLE Mybook(
bookid INT PRIMARY KEY,
price INT
);

INSERT INTO Mybook(bookid) VALUES(3);

SELECT * FROM Mybook;

-- 오빠 Char* 뽑았다 NULL; 데리러가
-- NaN Char라리 root고있는 삐error가 좋아
-- Binary는 호남선 Num Row Column Char에

SELECT price+100
from Mybook
where bookid=3;
-- NULL에 3을 더해도 NULL

SELECT SUM(price), AVG(price), COUNT(*), COUNT(price)
from Mybook
WHERE bookid>=4;

SELECT COUNT(*) FROM Mybook
WHERE price IS NULL;

SELECT name '이름', IFNULL(phone, '없음') '전화번호'
FROM customer;

SELECT bookid, IFNULL(price, '가격 미입력') '가격'
FROM Mybook;
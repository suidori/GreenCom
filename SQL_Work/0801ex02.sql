CREATE VIEW Vorders
AS SELECT orderid, orders.custid, name, orders.bookid, bookname, saleprice, orderdate
FROM customer, orders, book
WHERE customer.custid = orders.custid AND book.bookid = orders.bookid;

CREATE VIEW vw_Customer
AS SELECT custid, name, address, phone
FROM customer
WHERE address like '대한민국%';

CREATE VIEW Vbookorder
AS SELECT orderid, orders.custid, name, saleprice, orderdate, orders.bookid, bookname
FROM orders, book, customer
WHERE orders.bookid = book.bookid AND orders.custid=customer.custid;

DROP VIEW vw_customer;
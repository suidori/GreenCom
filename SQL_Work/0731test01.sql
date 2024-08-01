SELECT DISTINCT customer.name
FROM customer, book, orders
WHERE orders.custid = customer.custid AND orders.bookid = book.bookid AND book.publisher IN (
	SELECT book.publisher
    FROM orders,book
    WHERE orders.bookid = book.bookid AND orders.custid = (select custid from customer where name = '박지성')
);
-- 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름


SELECT name
FROM orders, book, customer
WHERE orders.bookid = book.bookid AND orders.custid = customer.custid
GROUP BY orders.custid
HAVING COUNT(DISTINCT book.publisher) >= 2;

-- 서로 다른 출판사에서 각각 도서를 구매한 고객의 이름

SELECT bookname
FROM orders, customer, book
WHERE orders.custid = customer.custid AND orders.bookid = book.bookid
GROUP BY orders.bookid
HAVING COUNT(DISTINCT orders.custid) > (SELECT COUNT(*) FROM customer)/10*3;

-- 전체 고객의 30% 이상이 구매한 도서
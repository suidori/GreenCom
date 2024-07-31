select distinct name
from customer, book
where bookid in (select bookid
				from book
                where publisher in (select publisher
									from book
									where bookid in (select bookid
													from orders
													where custid = (select custid
																	from customer
                                                                    where name = '박지성')
                                                                    )
													)
					)
;
-- 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

SELECT name
FROM customer
WHERE custid IN (
	SELECT orders.custid
	FROM orders, book
	WHERE orders.bookid = book.bookid
	GROUP BY orders.custid
	HAVING COUNT(DISTINCT book.publisher) >= 2
);

-- 서로 다른 출판사에서 각각 도서를 구매한 고객의 이름

SELECT bookname
FROM book
WHERE bookid IN (
	SELECT orders.bookid
    FROM orders, customer
    WHERE orders.custid = customer.custid
    GROUP BY orders.bookid
    HAVING COUNT(DISTINCT orders.custid) > (3/10));

-- 전체 고객의 30% 이상이 구매한 도서
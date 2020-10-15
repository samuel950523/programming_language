SELECT customer_name
FROM customer 
WHERE customer_id in (
	SELECT customer_id
    FROM customer_order
);

SELECT c.customer_name
FROM customer c
WHERE exists (
	SELECT o.customer_id
    FROM customer_order o
    WHERE c.customer_id = o.customer_id
);

SELECT customer_name
FROM customer
WHERE customer_id not in (
	SELECT customer_id
    FROM customer_order
);

SELECT c.customer_name
FROM customer c
WHERE not exists (
	SELECT o.customer_id
    FROM customer_order o
    WHERE c.customer_id = o.customer_id
);


/*NOT IN WITH NUll*/
ALTER TABLE `my_db`.`customer_order` 
CHANGE COLUMN `customer_id` `customer_id` INT NULL ;

update customer_order set customer_id = null where order_seq = 3;

SELECT customer_name
FROM customer
WHERE customer_id not in (
	SELECT customer_id
    FROM customer_order
    WHERE customer_id IS NOT NULL
);

SELECT c.customer_name
FROM customer c
WHERE not exists (
	SELECT o.customer_id
    FROM customer_order o
    WHERE c.customer_id = o.customer_id
);
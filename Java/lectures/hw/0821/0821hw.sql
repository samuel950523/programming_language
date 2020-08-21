CREATE SCHEMA employee_db;

USE employee_db;

-- 제품번호, 제품명, 가격, 재고
CREATE TABLE employee (
    emp_no INT PRIMARY KEY,
    emp_name VARCHAR(100),
    emp_position VARCHAR(30),
    emp_dept VARCHAR(10)
);

SELECT * FROM employee;

DROP table employee; 
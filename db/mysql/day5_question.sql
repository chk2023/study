-- DAY5: QUESTION
-- Q1.
SELECT
	emp_name AS EMP_NAME, 
	CONCAT_WS('-', SUBSTRING(phone, 1, 3), SUBSTRING(phone, 4, 4), SUBSTRING(phone, 8, 4)) AS PHONE
FROM
	employee.employee;
	
-- Q2.
SELECT
	emp_name AS 직원명,
    DATE_FORMAT(hire_date, '%Y년 %c월 %e일') AS 입사일,
    FORMAT(salary, 0) AS 급여
FROM
	employee.employee
ORDER BY
	hire_date ASC,
    salary DESC;
    
-- Q3.
SELECT
	emp_name AS EMP_NAME,
    FORMAT(salary, 0) AS SALARY,
    CONCAT(FORMAT(bonus*100, 0), '%') AS BONUS,
    FORMAT(ROUND(salary*(1+IFNULL(bonus,1))), 0) AS TOTAL_SALARY
FROM
employee.employee
ORDER BY
	ROUND(salary*(1+IFNULL(bonus,1))) DESC;
    

-- Q4. 
SELECT 
	emp_name AS EMP_NAME,
    LPAD(EMAIL, 18, ' ') AS EMAIL
FROM
	employee.employee;

SELECT
	emp_name AS EMP_NAME,
	LPAD(EMAIL, 
		(SELECT MAX(LENGTH(email)) FROM employee.employee), 
        ' ') AS EMAIL
FROM
	employee.employee;

-- Q5.

-- NAME_TAG: employee.emp_name + job.job_name
-- EMP_NO: emp_no
-- BELONG: nation.national_name + department.dept_title + %소속
-- MANAGER_NAME: employee.manage_id = emp.id

SELECT
	CONCAT(e1.employee.emp_name, (SELECT
    b.job_name
FROM
	employee e2
JOIN job b ON e2.job_code = b.job_code
WHERE e2.emp_id = e1.emp_id)) AS emp_job
FROM
	employee e1;
    


SELECT * FROM employee;
SELECT * FROM department;
SELECT * FROM job;
SELECT * FROM location;
SELECT * FROM nation;










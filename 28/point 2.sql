-- 2. Из таблиц employees и departments выбрать имена сотрудников (first_name, last name) 
--    и названия подразделений (department_name) в которых они работают.

USE hr;

SELECT e.first_name, e.last_name, d.department_name FROM employees AS e
JOIN departments AS d
WHERE e.department_id = d.department_id;
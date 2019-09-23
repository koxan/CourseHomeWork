-- 3. Из таблиц locations, employees и departments выбрать имена (first_name, last_name), должность (job_id), номер подразделения (department_id), 
--   и названия подразделения для сотрудников из города London

USE hr;

SELECT e.first_name, e.last_name, e.job_id, d.department_id, d.department_name FROM employees AS e
JOIN locations AS l, departments AS d
WHERE e.department_id = d.department_id AND l.city = 'London';
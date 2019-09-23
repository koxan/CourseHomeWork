-- 4. Из таблиц employees, departments и locations выбрать названия подразделений (department_name), имя сотрудника (first_name), и город (city)

USE hr;

SELECT d.department_name, e.first_name, l.city FROM employees AS e
JOIN departments AS d, locations AS l
WHERE e.department_id = d.department_id AND d.location_id = l.location_id;
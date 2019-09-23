-- 1. Из таблиц locations и countries выбрать адреса (location_id, street_address, city, state_province, country_name) всех подразделений
USE hr;

SELECT d.department_id, d.department_name, l.location_id, l.street_address, l.city, l.state_province, c.country_name FROM departments AS d
JOIN locations AS l, countries AS c
WHERE d.location_id = l.location_id AND l.country_id = c.country_id;
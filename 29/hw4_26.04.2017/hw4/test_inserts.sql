SHOW DATABASES;

USE to_do_list;

SHOW TABLES;

SELECT * FROM status;
SELECT * FROM category;
SELECT * FROM task;

INSERT INTO category VALUES(1, 'Домашнее задание', default);
INSERT INTO category VALUES(2, 'Спорт', default);
INSERT INTO task VALUES(1, 'Программирование', null, 1, null, '2017-05-08', '2017-05-10', 1, default);
INSERT INTO task VALUES(2, 'Присед', null, 2, null, '2017-05-08', '2017-05-10', 2, default);

SELECT t.id, t.title, t.description, c.name AS category, t.created, t.date_start, t.date_end, s.name AS status FROM task AS t
JOIN category AS c, status AS s
WHERE t.category_id = c.id AND t.status_id = s.id;

UPDATE task SET title = 'prog', description = 'desc' WHERE id = 1;
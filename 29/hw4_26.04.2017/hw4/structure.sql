CREATE DATABASE IF NOT EXISTS to_do_list;

USE to_do_list;

CREATE TABLE IF NOT EXISTS category
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 deleted INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS status
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS task
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(255) NOT NULL,
 description TEXT,
 category_id INT,
 created TIMESTAMP,
 date_start DATE,
 date_end DATE,
 status_id INT,
 deleted INT DEFAULT 0,
 CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category(id),
 CONSTRAINT status_fk FOREIGN KEY (status_id) REFERENCES status(id)
);

INSERT IGNORE INTO status VALUES(1, 'не начата');
INSERT IGNORE INTO status VALUES(2, 'активная');
INSERT IGNORE INTO status VALUES(3, 'выполнена');
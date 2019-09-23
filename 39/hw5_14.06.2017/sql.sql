CREATE DATABASE hw5_web;

USE hw5_web;

CREATE TABLE student
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 first_name VARCHAR(20),
 last_name VARCHAR(20),
 age INT,
 gender SET('male', 'female', 'unknown')
);

SELECT * FROM student;

INSERT INTO student VALUES(NULL, "Vasya", "Pupkin", 10, "male");
INSERT INTO student VALUES(NULL, "Mila", "Pupkin", 14, "female");
INSERT INTO student VALUES(NULL, "Ivan", "Kopan", 24, "male");
GRANT ALL ON hw7.* TO 'movie_admin' IDENTIFIED BY 'movie_admin' WITH GRANT OPTION;

GRANT SELECT ON hw7.* TO 'movie_user' IDENTIFIED BY 'movie_user';

USE mysql;
SELECT * FROM user;

-- test for user movie_admin AND movie_user
SHOW DATABASES;
USE hw7;
SHOW TABLES;
SELECT * FROM Actors;

INSERT INTO Actors VALUES(NULL, 'Vasya', 'Pupkin', 'Germany', '1966-06-06');
SELECT * FROM Actors;

UPDATE Actors SET FirstName = 'Masha' WHERE ActorID = LAST_INSERT_ID();
SELECT * FROM Actors;

DELETE FROM Actors WHERE ActorID = LAST_INSERT_ID();
SELECT * FROM Actors;
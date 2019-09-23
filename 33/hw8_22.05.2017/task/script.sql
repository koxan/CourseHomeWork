DELIMITER $
CREATE TRIGGER city_insert
  AFTER INSERT
  ON city
  FOR EACH ROW
  BEGIN
    INSERT INTO backup(city_name, city_id, action)
      VALUES (new.name, new.city_id, 'insert');
  END $

DELIMITER $
CREATE TRIGGER city_update
AFTER UPDATE
  ON city
FOR EACH ROW
  BEGIN
    INSERT INTO backup(city_name, city_id, action)
    VALUES (old.name, old.city_id, 'update');
  END $

DELIMITER $
CREATE TRIGGER city_delete
AFTER DELETE
  ON city
FOR EACH ROW
  BEGIN
    INSERT INTO city(name) VALUES (old.name);
  END $

DELIMITER $
CREATE TRIGGER city_insert_check_length
AFTER INSERT
  ON city
FOR EACH ROW
  BEGIN
    if length(new.name) <= 5 then
      DELETE FROM city WHERE city_id=new.city_id;
    END IF ;
  END $

DELIMITER ;

SHOW TRIGGERS;

INSERT INTO city(name) VALUES ('Ivan');

UPDATE city SET name = "Ивано Франковск" WHERE city_id=11;

DELETE FROM city WHERE city_id=11;

DROP TRIGGER city_insert;

GRANT SELECT ON people.* TO 'reader'@'localhost'
  IDENTIFIED BY 'reader';

GRANT INSERT ON people.* TO 'reader'@'localhost'
IDENTIFIED BY 'reader';

FLUSH PRIVILEGES ;

set PASSWORD for 'reader'@'localhost' = password('reader');
-- отобрать права вставки
REVOKE INSERT ON people.* FROM 'reader'@'localhost';

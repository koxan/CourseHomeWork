
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`city_id`),
  UNIQUE KEY `name` (`name`)
) DEFAULT CHARSET=utf8;

INSERT INTO `city` VALUES (1,'Dnipro'),(2,'Kiev'),(7,'lkajafklj'),(10,'London'),(4,'Lviv'),(3,'New York'),(9,'XXXXXXX');

CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `email` (`email`),
  KEY `city_fk` (`city_id`),
  CONSTRAINT `city_fk` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) DEFAULT CHARSET=utf8;

INSERT INTO `person` VALUES (2,'Vasja','Pupkin','vasilij@mail.ua',1),(5,'XXX','XXX','XXX@XXX',1),(6,'roma','romanov','mail@mail.com',1),(7,'sam','romanov','mail@mail.uk',10),(8,'Nikita','LKJkljafa','Nikita@mail.com',1),(10,'KJlkj','LJLJk','LKJKLJ@mail.com',3);

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `dummy`(invar int) RETURNS int(11)
BEGIN
    -- set inoutvar = invar + inoutvar;
    -- set outvar = 10;
    RETURN invar*10;
  END ;;

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_person`(in fname VARCHAR(255),
                               in lname VARCHAR(255),
                               in mail VARCHAR(255),
                               in vcity VARCHAR(255),
                               out id int)
BEGIN
    DECLARE c_id int;
    SELECT city_id into c_id  from city WHERE name = vcity;
    IF c_id IS NULL THEN
      INSERT INTO city(name) VALUES (vcity);
      SELECT city_id into c_id  from city WHERE name = vcity;
    END IF;
    INSERT person(first_name, last_name, email, city_id) VALUES (fname, lname, mail, c_id);
    SELECT person_id INTO id FROM person WHERE first_name=fname 
                                               and last_name=lname 
                                               and email=mail 
                                               and person.city_id=c_id;
  END ;;
DELIMITER ;


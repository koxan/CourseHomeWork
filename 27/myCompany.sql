drop database transport_company;
CREATE DATABASE IF NOT EXISTS transport_company;
USE transport_company;

CREATE TABLE client
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(10) NOT NULL
);

CREATE TABLE city
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL
);

CREATE TABLE loading
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(15) NOT NULL,
 weight INT NOT NULL
);

CREATE TABLE manager
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(10) NOT NULL
);


CREATE TABLE carrier
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 max_weight INT NOT NULL
);

CREATE TABLE rate
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 uah_per_kilo INT NOT NULL
);

CREATE TABLE flight
(
 id INT PRIMARY KEY AUTO_INCREMENT,
 city_from INT NOT NULL,
 city_to INT NOT NULL,
 loading INT NOT NULL,
 client INT NOT NULL,
 manager INT NOT NULL,
 carrier INT NOT NULL,
 calc INT NOT NULL,
 CONSTRAINT city_fk_from FOREIGN KEY (city_from) REFERENCES city(id),
 CONSTRAINT city_fk_to FOREIGN KEY (city_to) REFERENCES city(id),
 CONSTRAINT loading_fk FOREIGN KEY (loading) REFERENCES loading(id),
 CONSTRAINT client_fk FOREIGN KEY (client) REFERENCES client(id),
 CONSTRAINT manager_fk FOREIGN KEY (manager) REFERENCES manager(id),
 CONSTRAINT carrier_fk FOREIGN KEY (carrier) REFERENCES carrier(id)
);

ALTER TABLE carrier ADD COLUMN name VARCHAR(15) NOT NULL;
ALTER TABLE rate CHANGE COLUMN uah_per_kilo uah_per_kilo FLOAT NOT NULL;
ALTER TABLE flight CHANGE COLUMN calc calc FLOAT NOT NULL;
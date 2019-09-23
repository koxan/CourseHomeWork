USE transport_company;
INSERT INTO manager(name) VALUES('Vasya');
INSERT INTO manager(name) VALUES('Petja');

INSERT INTO client(name) VALUES('Masha');
INSERT INTO client(name) VALUES('Vitaliy');

INSERT INTO city(name) VALUES('Dnipro');
INSERT INTO city(name) VALUES('Kiev');
INSERT INTO city(name) VALUES('Kharkiv');
INSERT INTO city(name) VALUES('Lviv');

INSERT INTO carrier(max_weight, name) VALUES(1000, 'NovaPoshta');
INSERT INTO carrier(max_weight, name) VALUES(2000, 'Intime');

INSERT INTO loading(name, weight) VALUES('bicycle', 36);
INSERT INTO loading(name, weight) VALUES('computer', 20);

INSERT INTO rate(uah_per_kilo) VALUES(1.2);

INSERT INTO flight
VALUES(null, 1, 2, 1, 1, 1, 1, 
(SELECT uah_per_kilo FROM rate WHERE id = 1) * (SELECT weight FROM loading WHERE id = 1)
);

INSERT INTO flight
VALUES(null, 3, 4, 2, 2, 2, 2, 
(SELECT uah_per_kilo FROM rate WHERE id = 1) * (SELECT weight FROM loading WHERE id = 2)
);
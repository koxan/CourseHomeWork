USE hw7;

SELECT * FROM logging;

CALL add_film("Экстрасенсы", "2017-06-01", 6.6, "Доктор-экстрасенс Джон Клэнси работает вместе со специальным агентом ФБР", "01:20:00",
              "Драмы",
              "Энтони", "Хопкинс", "Американец", "1950-01-01",
              "Афонсо", "Пойарт", "Португалец", "1960-01-01");
              
SELECT m.MovieID, m.Title, m.ReleaseYear, m.Rating, m.Plot, m.MovieLength, g.GenreName, a.LastName AS Actor, d.LastName AS Director FROM Movies AS m
INNER JOIN Genres AS g, Actors AS a, Directors AS d, MovieActor AS ma, MovieGenres AS mg
WHERE m.DirectorID = d.DirectorID AND
      m.MovieID = mg.MovieID AND g.GenreID = mg.GenreID AND
      a.ActorID = ma.ActorID AND m.MovieID = ma.MovieID;
            
UPDATE Movies SET Title = "new title" WHERE MovieID = 1;

ALTER TABLE Movies DROP FOREIGN KEY DirectorID_fk;
ALTER TABLE Movies ADD CONSTRAINT DirectorID_fk FOREIGN KEY(DirectorID) REFERENCES Directors(DirectorID) ON DELETE CASCADE;

ALTER TABLE MovieActor DROP FOREIGN KEY MovieID_fk;
ALTER TABLE MovieActor DROP FOREIGN KEY ActorID_fk;
ALTER TABLE MovieActor ADD CONSTRAINT MovieID_fk FOREIGN KEY(MovieID) REFERENCES Movies(MovieID) ON DELETE CASCADE;
ALTER TABLE MovieActor ADD CONSTRAINT ActorID_fk FOREIGN KEY(ActorID) REFERENCES Actors(ActorID) ON DELETE CASCADE;

ALTER TABLE MovieGenres DROP FOREIGN KEY MovieID_fk2;
ALTER TABLE MovieGenres DROP FOREIGN KEY GenreID_fk;
ALTER TABLE MovieGenres ADD CONSTRAINT MovieID_fk2 FOREIGN KEY(MovieID) REFERENCES Movies(MovieID) ON DELETE CASCADE;
ALTER TABLE MovieGenres ADD CONSTRAINT GenreID_fk FOREIGN KEY(GenreID) REFERENCES Genres(GenreID) ON DELETE CASCADE; 

DELETE FROM Movies WHERE MovieID = 1;

SELECT * FROM logging;
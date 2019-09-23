USE hw7;

SELECT * FROM Actors;
SELECT * FROM Genres;
SELECT * FROM Directors;

CALL add_film("Экстрасенсы", "2017-06-01", 6.6, "Доктор-экстрасенс Джон Клэнси работает вместе со специальным агентом ФБР", "01:20:00",
              "Драмы",
              "Энтони", "Хопкинс", "Американец", "1950-01-01",
              "Афонсо", "Пойарт", "Португалец", "1960-01-01");
              
SELECT m.Title, m.ReleaseYear, m.Rating, m.Plot, m.MovieLength, g.GenreName, a.LastName AS Actor, d.LastName AS Director FROM Movies AS m
INNER JOIN Genres AS g, Actors AS a, Directors AS d, MovieActor AS ma, MovieGenres AS mg
WHERE m.DirectorID = d.DirectorID AND
      m.MovieID = mg.MovieID AND g.GenreID = mg.GenreID AND
      a.ActorID = ma.ActorID AND m.MovieID = ma.MovieID;
   
SELECT calc_age(Birth) FROM Actors LIMIT 1;
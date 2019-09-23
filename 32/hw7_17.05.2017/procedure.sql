USE hw7;

DELIMITER $
CREATE PROCEDURE add_film(inTitle VARCHAR(20), inReleaseYear DATE, inRating DECIMAL(2,1), inPlot TEXT, inMovieLength TIME,
                          inGenreName VARCHAR(20),
                          inActorFirstName VARCHAR(20), inActorLastName VARCHAR(20), inActorNationality VARCHAR(20), inActorBirth DATE,
                          inDirectorFirstName VARCHAR(20), inDirectorLastName VARCHAR(20), inDirectorNationality VARCHAR(20), inDirectorBirth DATE)
 BEGIN
  DECLARE locGenreID INT;
  DECLARE locActorID INT;
  DECLARE locDirectorID INT;
  DECLARE locMovieID INT;
  
  SELECT GenreID INTO locGenreID FROM Genres WHERE GenreName = inGenreName;
  IF locGenreID IS NULL THEN
   INSERT INTO Genres VALUES(NULL, inGenreName);
   SET locGenreID = LAST_INSERT_ID();
  END IF;
  
  SELECT ActorID INTO locActorID FROM Actors WHERE FirstName = inActorFirstName AND
                                   LastName = inActorLastName AND
                                   Nationality = inActorNationality AND
                                   Birth = inActorBirth;
  IF locActorID IS NULL THEN
   INSERT INTO Actors VALUES(NULL, inActorFirstName, inActorLastName, inActorNationality, inActorBirth);
   SET locActorID = LAST_INSERT_ID();
  END IF;
  
  SELECT DirectorID INTO locDirectorID FROM Directors WHERE FirstName = inDirectorFirstName AND
                                   LastName = inDirectorLastName AND
                                   Nationality = inDirectorNationality AND
                                   Birth = inDirectorBirth;
  IF locDirectorID IS NULL THEN
   INSERT INTO Directors VALUES(NULL, inDirectorFirstName, inDirectorLastName, inDirectorNationality, inDirectorBirth);
   SET locDirectorID = LAST_INSERT_ID();
  END IF;
  
  INSERT INTO Movies VALUES(NULL, locDirectorID, inTitle, inReleaseYear, inRating, inPlot, inMovieLength);
  SET locMovieID = LAST_INSERT_ID();
  
  INSERT INTO MovieActor VALUES(locMovieID, locActorID);
  INSERT INTO MovieGenres VALUES(locMovieID, locGenreID);
  
 END $
DELIMITER ;
CREATE DATABASE movie_db;
USE movie_db;

CREATE TABLE movies (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        director VARCHAR(100) NOT NULL,
                        year INT NOT NULL
);

DELIMITER //
CREATE PROCEDURE add_movie(IN title_in VARCHAR(255), IN director_in VARCHAR(100), IN year_in INT)
BEGIN
    INSERT INTO movies (title, director, year) VALUES (title_in, director_in, year_in);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE list_movies()
BEGIN
    SELECT * FROM movies;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE update_movie(IN id_in INT, IN title_in VARCHAR(255), IN director_in VARCHAR(100), IN year_in INT)
BEGIN
    UPDATE movies
    SET title = title_in, director = director_in, year = year_in
    WHERE id = id_in;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE delete_movie(IN id_in INT)
BEGIN
    DELETE FROM movies WHERE id = id_in;
END //
DELIMITER ;

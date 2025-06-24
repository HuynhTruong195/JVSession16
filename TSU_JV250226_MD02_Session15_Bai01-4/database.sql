USE `databaseex01`;
CREATE TABLE `Students`
(
    `student_id`    int AUTO_INCREMENT PRIMARY KEY ,
    `full_name`     varchar(100) NOT NULL,
    `date_of_birth` DATE         NOT NULL,
    `email`         varchar(100) NOT NULL UNIQUE
);


INSERT INTO `Students` (`full_name`, `date_of_birth`, `email`)
VALUES ('Nguyen Van A', '2001-05-21', 'a.nguyen@example.com'),
       ('Tran Thi B', '2000-09-15', 'b.tran@example.com'),
       ('Le Van C', '1999-12-30', 'c.le@example.com'),
       ('Pham Thi D', '2002-03-10', 'd.pham@example.com'),
       ('Hoang Van E', '2001-07-01', 'e.hoang@example.com'),
       ('Do Thi F', '2000-01-25', 'f.do@example.com'),
       ('Nguyen Van G', '1998-11-09', 'g.nguyen@example.com'),
       ('Tran Thi H', '2002-06-18', 'h.tran@example.com'),
       ('Le Van I', '2001-10-05', 'i.le@example.com'),
       ('Pham Thi K', '1999-04-22', 'k.pham@example.com');


DELIMITER //
CREATE PROCEDURE `get_all_students`()
BEGIN
    SELECT `s`.`student_id`, `full_name`, `date_of_birth`, `email` FROM `Students` `s`;
END //

CREATE PROCEDURE `add_student`(`int_full_name` varchar(100), `in_date_of_birth` DATE, `in_email` varchar(100))
BEGIN
    INSERT INTO `Students`(`full_name`, `date_of_birth`, `email`)
    VALUES (`int_full_name`, `in_date_of_birth`, `in_email`);
END //

CREATE PROCEDURE `update_student`(`id_edit` int, `int_full_name` varchar(100), `in_date_of_birth` DATE,
                                  `in_email` varchar(100))
BEGIN
    UPDATE `Students`
    SET `full_name`     = `int_full_name`,
        `date_of_birth` = `in_date_of_birth`,
        `email`         = `in_email`
    WHERE `student_id` = `id_edit`;
END //

CREATE PROCEDURE `find_student_byId`(`find_id` int)
BEGIN
    SELECT `s`.`student_id`, `s`.`full_name`, `s`.`date_of_birth`, `s`.`email`
    FROM `Students` `s`
    WHERE `student_id` = `find_id`;
END //

CREATE PROCEDURE `delete_student`(`del_byId` int)
BEGIN
    DELETE FROM `Students` WHERE `student_id` = `del_byid`;
END //
DELIMITER ;
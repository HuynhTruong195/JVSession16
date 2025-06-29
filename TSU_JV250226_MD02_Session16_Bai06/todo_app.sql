CREATE DATABASE IF NOT EXISTS todo_app;
USE todo_app;

CREATE TABLE IF NOT EXISTS tasks (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     task_name VARCHAR(255) NOT NULL,
    status ENUM('chưa hoàn thành', 'đã hoàn thành') NOT NULL
    );
DELIMITER //
CREATE PROCEDURE add_task(IN taskName VARCHAR(255), IN taskStatus VARCHAR(20))
BEGIN
INSERT INTO tasks(task_name, status) VALUES (taskName, taskStatus);
END;
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE list_tasks()
BEGIN
SELECT * FROM tasks;
END;
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE update_task_status(IN taskId INT, IN newStatus VARCHAR(20))
BEGIN
UPDATE tasks SET status = newStatus WHERE id = taskId;
END;
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE delete_task(IN taskId INT)
BEGIN
DELETE FROM tasks WHERE id = taskId;
END;
//
DELIMITER ;
DELIMITER //
CREATE PROCEDURE search_task_by_name(IN nameKeyword VARCHAR(255))
BEGIN
SELECT * FROM tasks WHERE task_name LIKE CONCAT('%', nameKeyword, '%');
END;
//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE task_statistics()
BEGIN
SELECT status, COUNT(*) AS total FROM tasks GROUP BY status;
END;
//
DELIMITER ;

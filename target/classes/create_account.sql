delimiter ;
DROP SCHEMA IF EXISTS `university_app`; 

CREATE SCHEMA `university_app` ;

CREATE USER 'smavuleti17081'@'localhost' IDENTIFIED BY 'universityapp';

GRANT ALL PRIVILEGES ON university_app.* TO 'smavuleti17081'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'smavuleti17081'@'localhost';

CREATE TABLE `university_app`.`account` (
  `account_id` INT NOT NULL,
  `account_balance` VARCHAR(45) NULL,
  `account_date` DATETIME NOT NULL);


INSERT INTO `university_app`.`account` (`account_id`, `account_balance`, `account_date`) VALUES ('1', '8.90', '2016-11-08');
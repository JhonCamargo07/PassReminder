-- drop database if exists passreminder;
CREATE DATABASE PassReminder;

USE PassReminder;

CREATE TABLE USER (
    id_user INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    email_user VARCHAR (150) UNIQUE NOT NULL,
    password_user VARCHAR (265) NOT NULL
);

CREATE TABLE pass (
    id_pass INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    page_pass VARCHAR (250) NOT NULL,
    name_pass VARCHAR (250) NOT NULL,
    pass VARCHAR (265) NOT NULL,
    id_user_FK INT NOT NULL
);

ALTER TABLE pass ADD CONSTRAINT pass_user FOREIGN KEY (id_user_FK) REFERENCES USER (id_user) ON
UPDATE
    CASCADE ON DELETE CASCADE
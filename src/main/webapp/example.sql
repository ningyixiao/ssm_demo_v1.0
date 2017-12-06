SET NAMES 'utf8mb4';
DROP DATABASE IF EXISTS example;
CREATE DATABASE example DEFAULT character SET utf8mb4 collate utf8mb4_unicode_ci;
USE example;

CREATE TABLE Example(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64),
    password VARCHAR(64)
);




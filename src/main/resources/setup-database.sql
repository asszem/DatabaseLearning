CREATE DATABASE testDatabase;
CREATE USER 'testUser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON testDatabase.* TO 'testUser'@'localhost';
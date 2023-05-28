CREATE DATABASE delivery;

CREATE USER 'pozo'@'%' IDENTIFIED BY 'pozo';

GRANT ALL ON spring-courier.* TO 'pozo'@'%';

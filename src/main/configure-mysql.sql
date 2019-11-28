## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE spawn_dev;
CREATE DATABASE spawn_prod;

#Create database service accounts
CREATE USER 'spawn_dev_user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'spawn_prod_user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'spawn_dev_user'@'%' IDENTIFIED BY 'password';
CREATE USER 'spawn_prod_user'@'%' IDENTIFIED BY 'password';

#Database grants
GRANT SELECT ON spawn_dev.* to 'spawn_dev_user'@'localhost';
GRANT INSERT ON spawn_dev.* to 'spawn_dev_user'@'localhost';
GRANT DELETE ON spawn_dev.* to 'spawn_dev_user'@'localhost';
GRANT UPDATE ON spawn_dev.* to 'spawn_dev_user'@'localhost';
GRANT SELECT ON spawn_prod.* to 'spawn_prod_user'@'localhost';
GRANT INSERT ON spawn_prod.* to 'spawn_prod_user'@'localhost';
GRANT DELETE ON spawn_prod.* to 'spawn_prod_user'@'localhost';
GRANT UPDATE ON spawn_prod.* to 'spawn_prod_user'@'localhost';
GRANT SELECT ON spawn_dev.* to 'spawn_dev_user'@'%';
GRANT INSERT ON spawn_dev.* to 'spawn_dev_user'@'%';
GRANT DELETE ON spawn_dev.* to 'spawn_dev_user'@'%';
GRANT UPDATE ON spawn_dev.* to 'spawn_dev_user'@'%';
GRANT SELECT ON spawn_prod.* to 'spawn_prod_user'@'%';
GRANT INSERT ON spawn_prod.* to 'spawn_prod_user'@'%';
GRANT DELETE ON spawn_prod.* to 'spawn_prod_user'@'%';
GRANT UPDATE ON spawn_prod.* to 'spawn_prod_user'@'%';
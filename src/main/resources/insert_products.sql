-- docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=password mysql:8.4.2
-- db init: mysql, user: root, password: password

-- create schema db_springboot_cloud;

create table db_springboot_cloud.products(
     id int auto_increment not null ,
     name varchar(255),
     price decimal(11, 2),
     create_at date,
     primary key (id)
);

/*INSERT INTO products (name, price, create_at) VALUES('Panasonic', 800, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony', 700, NOW());
INSERT INTO products (name, price, create_at) VALUES('Apple', 1000, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony Notebook', 1000, NOW());
INSERT INTO products (name, price, create_at) VALUES('Hewlett Packard', 500, NOW());
INSERT INTO products (name, price, create_at) VALUES('Bianchi', 600, NOW());
INSERT INTO products (name, price, create_at) VALUES('Nike', 100, NOW());
INSERT INTO products (name, price, create_at) VALUES('Adidas', 200, NOW());
INSERT INTO products (name, price, create_at) VALUES('Reebok', 300, NOW());*/

select * from products;

-- commit;
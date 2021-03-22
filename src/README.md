# Sử dụng và cấu hình images MySql docker:

Install images run lên sau : docker pull mysql.

## Sử dụng docker created mySQL.

Có 2 option run docker :

### 1. Run mặc định và không có cấu hình :

Created default images : `docker run --name=[container_name] -d mysql/mysql-server:latest`

Trong đó `[container_name]` là tên mà bạn chọn đặt cho container mySQL, nếu bạn không đặt tên thì mặc định docker sẽ random cho bạn 1 cái tên.

### 2. Run container có cấu hình. Configure MySQL Container:

Cách cấu hình :

#### 2.1. Tạo volume cho file cấu hình :

- Chạy lệnh sau để tạo 1 thư mục chứa file config trên phía máy local.
  `mkdir -p /Users/macbook/Volume_DBdocker/mysql/[container_name]/conf.d`

- Tạo và chỉnh sửa thông tin file cấu hình :
  `nano /Users/macbook/Volume_DBdocker/mysql/[container_name]/conf.d/my-custom.cnf`

* nội dung file cấu hình sẽ được config như sau :

```
[mysqld]
max_connections=250
max_allowed_packet=500M
```

- Tiến hành save và exit lại file `my-custom.cnf`.

#### 2.2. Tạo volume cho data storage :

- chạy lệnh sau có tác dụng sinh ra 1 dir để chứa tất cả các dữ liệu BD lại tại máy local :`mkdir -p /Users/macbook/Volume_DBdocker/mysql/[container_name]/mysql-data`

#### 2.3. Now start the container.

`docker run --detach --name=[container_name] --env="MYSQL_ROOT_PASSWORD=my_password" --publish 3306:3306 --volume=/Users/macbook/Volume_DBdocker/mysql/[container_name]/conf.d:/etc/mysql/conf.d --volume=/Users/macbook/Volume_DBdocker/mysql/[container_name]/mysql-data:/var/lib/mysql mysql`

#### Note me :

- Ta có thể sử dụng lệnh : `docker inspect [container_name]` để xem thông tin của 1 container vừa tạo.

- Connect to the MySQL Docker Container : sử dụng `docker exec -it [container_name] mysql -uroot -p` để cấu hình thông mysql vừa tạo thông qua mysql shell vd :
  `mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '[newpassword]';` với `[newpassword]` là password mới ta muốn đặt lại cho DB.

Đây là cách cấu hình cơ bản, để lưu lại các cấu hình và cấu hình nhiều hơi vui lòng sử dụng file .yml
Link bài viết tham khảo : ( https://phoenixnap.com/kb/mysql-docker-container ).
Tương tự với context này có thẻ cấu hình cho các hệ cơ sở dũ liệu khác.

### Sử dụng mysql Shell để thực hiện truy vấn tạo DB cũng như created bảng.

#### Tạo Database

```sql
CREATE DATABASE micro_db;
use micro_db;
CREATE TABLE `user` ( `id` bigint(20) NOT NULL AUTO_INCREMENT, `hp` int NULL DEFAULT NULL, `stamina` int DEFAULT NULL, `atk`int DEFAULT NULL, `def`int DEFAULT NULL, `agi`int DEFAULT NULL, PRIMARY KEY (`id`));

DELIMITER $$
CREATE PROCEDURE generate_data()
BEGIN
  DECLARE i INT DEFAULT 0;
  WHILE i < 100 DO
    INSERT INTO `user` (`hp`,`stamina`,`atk`,`def`,`agi`) VALUES (i,i,i,i,i);
    SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

CALL generate_data();
```

#### Cấu hình Spring

_application.properties_

```java
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/micro_db?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=admin

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

logging.level.org.hibernate = ERROR
```

Bài đọc được trích tại đây để thực hiện học hiểu jpa : link-spring-boot-11]: https://loda.me/spring-boot-11-huong-dan-spring-boot-jpa-my-sql-loda1558687596060

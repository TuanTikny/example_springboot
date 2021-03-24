# Các option trong ví dụ tại branch này :

## Sử dụng DB cấu hình như sau :

#### Tạo Database :

_script.sql_

```sql
CREATE SCHEMA IF NOT EXISTS `todo_db` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE IF NOT EXISTS `todo_db`.`todo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `detail` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
```

Thêm 1 record vào DB

```sql
INSERT INTO `todo_db`.`todo` (`title`, `detail`) VALUES ('Task 1', 'Nội dung chú thích cho task 1');
```

Các bài viết tham khảo :

spring-boot-13 : https://loda.me/spring-boot-13-special-chi-tiet-spring-boot-thymeleaf-my-sql-i18n-web-demo-loda1558758475731/
spring-boot-14 : https://loda.me/spring-boot-14-restful-api-rest-controller-path-variable-request-body-loda1558775921707/
spring-boot-15 : https://loda.me/spring-boot-15-exception-handling-exception-handler-rest-controller-advice-controller-advice-response-status-loda1558838525127/

Fix lỗi @Transactional : https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
=> thêm anotation này vào TodoRepository

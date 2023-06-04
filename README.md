# computer_shop

###### Описание проекта
Небольшое приложение на базе Spring Boot, которое имеет HTTP методы
выполняющие:
1. Добавление товара
2. Редактирование товара
3. Просмотр всех существующих товаров по типу
4. Просмотр товара по идентификатору


Вы можете собрать проект, запустив команду : **mvn clean package**

### Основа  
- Java 11
- Maven

### Стек технологий:
* Spring boot
* Hibernate
* Liquibase
* Lombok
* OrikaMapper
* Swagger

Все конечные точки для операций CRUD можно увидеть в Swagger:
http://localhost:8080/swagger-ui.html#


### Настроить БД
Настройте базу данных в соответствии с [application.properties]
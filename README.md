# Book-Store
A small project for practicing Vue + Spring boot.

This is the back end project.

该项目使用 Spring Boot 框架，目的在于熟悉使用 Spring Boot 及其相关技术，适用于第一次接触 Spring Boot 框架的纯小白练手，包括我。

# 数据库设计

![book](https://github.com/miawua/BookStore-back/blob/main/1.assets/image-20210113141744197.png)



![user](https://github.com/miawua/BookStore-back/blob/main/1.assets/image-20210113142336686.png)



![record](https://github.com/miawua/BookStore-back/blob/main/1.assets/image-20210113142422811.png)

# 框架目录

```
|-bookstore
	|-BookstoreApplication			启动类*
	|-ServletInitializer			Servlet初始化类*
	|-entity				实体
		|-Book.java
		|-BookJSON.java			用于与前端交互，以下两个xxJSON同理
		|-Record.java
		|-RecordJSON.java
		|-User.java
		|-UserJSON.java
	|-dao					数据库交互
		|-BookDAO.java
		|-RecordDAO.java
		|-UserDAO.java
	|-controller				处理前端请求
		|-BookController.java
		|-UserController.java
		|-RecordController.java
	|-service				主要逻辑实现
		|-BookService.java
		|-UserService.java
		|-RecordService.java
```

当然，在 `test` 目录下包含了几个测试使用的代码。
`*` 表示框架自建。

## entity 层

存放实体类，其中 `Book.java`, `User.java`, `Record.java` 分别对应数据库内的三张表；另外 `BookJSON.java`, `UserJSON.java`, `RecordJSON.java` 用于前后端交互数据的统一、将操作数据化。

## dao 层

Dao 层主要是做数据持久层的工作，负责与数据库的联系。此项目中使用 `Jpa` 持久化数据库，基本增删改查使用 `@Query` 注释声明原生 `SQL` 语句。

## service 层

Service 层是主要业务逻辑的实现，包括处理前端需求，请求后端数据，计算数据变化，通过 Dao 层更新查询数据库，处理异常与非法请求。

## controller 层

Controller 层负责具体的业务模块流程的控制，在此层里面要调用 Service 层的接口来控制业务流程。主要映射 `url` 请求，获取 `JSON` 数据，通过 Service 层获取返回数据，再将数据发回给前端。


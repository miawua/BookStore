# Book-Store
A small project for practicing Vue + Spring boot.

This is the back end project.

该项目使用 Spring Boot 框架，目的在于熟悉使用 Spring Boot 及其相关技术，适用于第一次接触 Spring Boot 框架的纯小白练手，包括我。

# 框架目录

```
|-bookstore
	|-BookstoreApplication			启动类*
	|-ServletInitializer			Servlet初始化类*
	|-entity						实体
		|-Book.java
		|-BookJSON.java				用于与前端交互，以下两个xxJSON同理
		|-Record.java
		|-RecordJSON.java
		|-User.java
		|-UserJSON.java
	|-dao							数据库交互
		|-BookDAO.java
		|-RecordDAO.java
		|-UserDAO.java
	|-controller					处理前端请求
		|-BookController.java
		|-UserController.java
		|-RecordController.java
	|-service						主要逻辑实现
		|-BookService.java
		|-UserService.java
		|-RecordService.java
```

当然，在 `test` 目录下包含了几个测试使用的代码。
## 码匠社区


## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)    
[elastic](https://elasticsearch.cn/)  
[Github OAuth](https://docs.github.com/en/developers/apps/building-oauth-apps/creating-an-oauth-app)  
[Bootstrap](https://v3.bootcss.com/)  
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html) MySql教程  
[Thymeleaf](https://www.thymeleaf.org/) 开发Web和独立环境项目的服务器端的Java模版引擎    

## 工具

[Git](https://git-scm.com/downloads)  
[Visual paradigm](https://www.visual-paradigm.com/cn/) ：画图工具  
[Flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven) ：应用、管理并跟踪数据库变更的数据库版本管理工具   
[Lombok](https://projectlombok.org/) ：Lombok 是一种 Java™ 实用工具，可用来帮助开发人员消除 Java 的冗长，尤其是对于简单的 Java 对象（POJO）。它通过注解实现这一目的。


## 脚本
```sql
create table USER
(
	ID BIGINT auto_increment
		primary key,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(50),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate
```
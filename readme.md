# spring-todolist

## 项目介绍
   使用Java语言编写的todolist应用，无前端页面，提供了基于restful风格的http接口调用。    
   支持对于基本的todoitem增删改查的管理，可以为todoitem增加一些tag，并支持基于tag的查询。    

## 接口设计
   提供了6个http接口，分别为：    
   1. `POST: /todo`，增加一个todoitem；    
   2. `GET: /todo/{id}`，根据id获取某个todoitem；    
   3. `PUT: /todo/{id}`，根据id更新某todoitem的内容、状态、tag；    
   4. `DELETE: /todo/{id}`，根据id删除某todoitem；    
   5. `GET: /todo`，根据状态或tag搜索todolist，分页结果；    
   6. `POST: /todo/clearup`，清除所有状态为已完成的todoitems。    
   Controller见[TodoController](https://github.com/guerbai/spring-todolist/blob/master/src/main/java/guerbai/springtodolist/controller/TodoController.java).    

## 技术栈
   + 一个Spring Boot应用简化大量配置；    
   + Spring MVC实现REST接口；    
   + Mybatis(xml配置)做持久化；    
   + logback实现滚动日志收集；    
   + aop实现log记录与接口耗时统计；    
   + 使用Enum字段表示状态，[参考文章](https://yulaiz.com/java-mysql-enum/);    
   + @Transactional事务管理；    
   + Postman组织测试各接口可用性；    

## 代码结构
   使用工程化组织。    
   sql文件夹存放初始化建表语句；    
   src下:    
   aspect为切面代码，其中有对每次http请求的耗时统计、入参返回的log；    
   controller为面向http接口层面的代码；    
   service为服务，分接口定义与impl子文件夹，可以提供各种实现；    
   dao为数据层，与数据库打交道；    
   domain为领域对象，pojo；    
   resource中mapper下为sql语句；    
   test/resources文件夹下为postman导出请求文件，可导出postman用于测试接口。    

   Domain作为参数在各层间传递，controller autowired进service接口，service的impl上加@Service被bean管理器发现成为实际被注入到controller中的bean，service中autowired进dao。    
   调用链路为：http到servlet，servlet给controller，controller调service，service调service与dao，dao通过配置被mybatis指向某sql语句，再调用到mysql，今次返回结果，完成功能。    

## License
   MIT

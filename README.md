# JBPM demo project with Springboot and mysql
this is learning from other project ， Just for learning jbpm and springboot, welcome for share and fork this project.

## JBPM7.7 + StringBoot + Mysql5.7.18
Demo project for JBPM (java Business Process Management) with SpringBoot and mysql


## 运行步骤：
1. git clone本项目到本地；
2. 创建数据库表 jbpm 并导入数据库文件 /doc/jbpm2019.sql
3. 修改配置文件 application.yml，config/spring-transaction.xml 中的相关数据库配置信息为你自己创建的配置信息。
4. 运行cn.tekin.jbpm.demo.Application .
5. 浏览器访问 http://localhost:8088/home  
登录账号： admin  密码：88888

数据库密码加密方式为sha256， 其他欢迎fork！


Enjoy yourself :)


> 项目版本

    SpringBoot 2.0.9.RELEASE
    jBPM7.7.0 Final 
   
    
> 项目中已包含数据库创建脚本 

    /doc/jbpm.sql(原始) 
    /doc/jbpm2019.sql(结合业务生成)
    
> 目录结构
    
     /doc/jbpm.sql 脚本
     /resources/com./rules/ 规则文件
     /resources/com./config/ spring 配置文件
     









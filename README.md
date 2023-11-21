# 用户中心



## 企业做项目流程

需求分析 = > 设计（概要设计、详细设计）=>技术选型 = > 

初始化/引入需要的技术 =>写demo = >写代码 （实现业务逻辑）=>测试(单元测试) =>代码提交/代码评审部署 =>发布

### 需求分析

1.**登录/注册**

2.**用户管理（仅管理员可见）对用户的查询、修改**

3.用户校验（**仅星球用户**）

### 技术选型

前端:三件套+ React +组件库 Ant Design +Umi +Ant Design Pro(现成的管理系统)

后端：

- java  
- spring（依赖注入框架，帮助你管理Java对象，集成一些其他的内容）
- springmvc（web框架，提供接口访问，restful接口等能力）
- mybatis（Java操作数据库的框架，持久层框架，对jdbc的封装）
- mybatis-plus（对mybatis的增强，不用写sql也能实现增删查改）
- springboot（快速启动/快速集成项目，不用自己管理spring配置，不用自己整合各种框架）
- junit单元测试库
- MySQL数据库

部署：服务器/容器（平台）

### 计划

1.初始化项目

1. 前端初始化

   1. 初始化项目**✓**

      ![image-20231103191353467](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103191353467.png)

      **要用node.js 16.20.0的版本才可以运行项目**	  

      添加umiUI

      ![image-20231103205028323](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103205028323.png) 

   2. 引入一些组件之类的**✓**

   3. 框架介绍/瘦身**✓**

      1. 移除国际化标准
      2. ![image-20231103211159822](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103211159822.png)
      3. ![image-20231103211233607](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103211233607.png)

2. 后端初始化**✓**

   1. 准备环境（MySQL）**✓**
      1. 连接自己的数据库**✓**
      2. 写sql
      3. ![image-20231104235234406](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231104235234406.png)
      4. 插入数据![image-20231104235748063](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231104235748063.png)
      5. 添加项目名称，添加端口

3. 数据库设计

   1. 引入框架（整合框架）

**2.登录/注册**  20min

1. 后端 20min
   1. 规整项目目录 
   2. 实现基本数据库操作（操作user表）
      1. 模型user对象 =>和数据库的字段关联，自动生成

   3. 登陆逻辑

2. 前端 30min
   1. 删除多余代码


3.用户管理（仅管理员可见） 20min

1. 前端
2. 后端

# 笔记

三种初始化Java项目的方式

1. GitHub搜现成的代码

2. SpringBoot官方的模板生成器（https://start.spring.io/）

3. 直接在IDEA中生成

   1. 直接生成

      ![image-20231103220745262](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103220745262.png)

mySQL依赖

![image-20231103220909405](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103220909405.png)

web

![image-20231103220957540](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103220957540.png)

MyBatis

![image-20231103221029587](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231103221029587.png)

如果要引入java的包，可以去maven的中心仓库寻找（https://mvnrepository.com/）

# 数据库设计 30min

什么是数据库？存数据的

数据库里有什么？数据表（理解为excel表格）

java操作数据库，代替人工



什么是设计数据库表？

有哪些表（模型 ）？表中有哪些字段？字段的类型？数据库字段添加索引？

表与表之间的 关联~

性别不需要添加索引



用户表：

id(主键)  <font color=red>bigint</font>

username昵称<font color=red> varchar</font>

userAccount登陆账号

avatarUrl头像 <font color=red> varchar</font>

gender性别 <font color=red> **tinyint**</font>

userPassword密码 <font color=red> varchar</font>

phone电话 <font color=red> varchar</font>

email邮箱 <font color=red> varchar</font>

userStatus用户状态int  0-正常

userRole用户角色   0-普通用户 1-管理员

------

createTime创建时间 (数据插入时间)  datetime

updateTime更新时间（数据更新时间）datetime

isDelete是否删除0 1（逻辑删除）tinyint

## 自动生成器的使用

MyBatisX插件，自动更根据数据库生成 domain实体对象 ， mapper（操作数据库的对象）

、mpper.xml(定义了mapper对象和数据库的关联，可以在里面自己写SQL)、service(包含常用的增删改查)、serviceImpl(具体实现service)

### 注册逻辑

1. 用户在前端输入账户和密码，以及校验码（todo）
2. 校验用户的账户，密码、校验密码，是否符合要求
   1. 账户的话**不小于**4位 （非空）
   2. 密码长度**不小于**8位
   3. 账户不能重复
   4. 账户不包含特殊字符
   5. 密码和校验密码相同
   6. 其他的校验
3. 对密码进行加密（密码千万不要直接明文存储到数据库中）
4. 向数据库插入用户数据

### 登陆逻辑

接受参数：用户账户、密码

请求类型：POST

请求体： JSON格式的数据

1. 请求参数很长不建议用get

返回值：用户信息（**脱敏**）

### 逻辑

1. 检验用户账户和密码是否合法
   1. 账户的话**不小于**4位 （非空）
   2. 密码长度**不小于**8位
   3. 账户不包含特殊字符
2. 校验密码是否输入正确，要和数据库中的密文密码去对比
3. 用户信息脱敏，隐藏敏感信息，防止数据库中的字段泄露
4. 我们要记录用户的登陆状态（session），将其存到服务器上（用后端SpringBoot 框架封装的服务器tomcat去记录）cookie
5. 返回脱敏后的用户信息

### 控制层Controller封装请求

application.yml指定接口全局api

```java
servlet:
context-path: /api
```

```java
@RestController 适用于编写 restful风格的api ,返回值默认
    为json类型
```

**controller层倾向于对请求参数本身的校验，不涉及业务逻辑本身（越少越好）**

service层是对业务逻辑的校验（有可能被controller之外的类调用)

### 如何知道是哪个用户登录了？

（javaWeb）

1. 连接服务器端后，得到一个session1状态（匿名会话）返回给前端
2. 登陆成功后，得到登陆成功的session，并且给该session设置一些值（比如用户信息），返回给前端一个设置的cookie的命令

​		session => cookie

1. 前端接受到后端的时候（相同的域名），在请求头中带上cookie去请求
2. 后端拿到前端传来的cookie，找到对应的session
3. 后端从session中可以取出基于session存储的变量（用户的登录信息、登录名）

### 今日计划

1. 开发完成后端登陆功能 20min（单机登陆 => 后续改造为分布式/第三方登陆）<font color=red>**✓**</font>
2. 开发后端用户的管理接口    5min （用户的查询、状态更改）<font color=red>**✓**</font>
3. 后端接口测试<font color=red>**✓**</font>
4. 开发前端用户登陆注册功能 
5. 讨论如何检验用户（星球小伙伴可以使用）

## 用户管理接口

！！！必须鉴权

1. 查询用户
   1. 允许根据用户名查询
2. 删除用户

##### 框架分层

controller 请求层目录层 只需要接受请求

service 业务逻辑 比如登陆注册

mapper或dao 查询数据 数据访问层

model 数据模型 封装类

utils工具类

### 写代码流程





#### 数据库插件

1.mybatisX

![image-20231112223437450](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112223437450.png)

![image-20231112223611147](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112223611147.png)

具体选择

如果不会可以：https://blog.csdn.net/weixin_52574640/article/details/129446461

![image-20231112225202165](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112225202165.png)

创建测试

![image-20231112225816653](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112225816653.png)

![image-20231112225830311](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112225830311.png)

引入测试注解

![image-20231112230238347](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112230238347.png)

通过generate插件一键生成对象set方法

![image-20231112231127195](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112231127195.png)

![image-20231112232946166](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112232946166.png)

创建用户

![image-20231112235147914](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112235147914.png)

密码校验时添加

![image-20231112235747496](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112235747496.png)

![image-20231112235845981](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231112235845981.png)

密码校验正则表达式

https://www.cnblogs.com/yasong-zhang/p/4916462.html

安装插件

![image-20231113180047877](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231113180047877.png)



2023.11.14

使用idea自带的测试

![image-20231114155446781](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231114155446781.png)



2023.11.15

### 前后端交互

前端需要向后端发送请求

前端ajax来请求后端

axios封装了ajax

request是ant design项目又封装了一次

追踪request源码，用到了umi的插件、是一个requestConifg配置



### 代理

------

正向代理：替客户端向服务器发送请求

如下图：

![image-20231118142948554](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231118142948554.png)

反向代理：替服务器接受请求，你有三台服务器，

![image-20231118143016282](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231118143016282.png)

怎么弄代理？

Nginx代理

Node.js代理



原本请求：http://localhost:8000/api/user/login



首先在proxy.ts，修改代理地址

![image-20231117005508119](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231117005508119.png)

然后在前端的api接口文件加上api

![image-20231117005630937](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231117005630937.png)

最后在全局配置中

设置请求，请求时间不要太短

![image-20231117005747708](C:\Users\李作浪\AppData\Roaming\Typora\typora-user-images\image-20231117005747708.png)

------

# 今日任务—2023.11.17

1. 完成注册功能的前端开发 15-20min **✓**
2. 获取用户的登录态，**获取当前登录用户信息接口****✓**
3. 完成 用户管理后台的前端开发 20-30min
4. 前端代码瘦身&优化 20min
5. 后端代码优化 20min
6. 新需求-讨论及开发星球用户校验（简易） 
7. 项目扩展思路

#### Ant Design Pro（Umi框架）

apptsx项目全局入口文件，定义了整个项目中使用的公共数据（比如用户信息）

access.ts控制用户的访问权限



首次访问页面（刷洗页面），进入app.tsx。执行getlnitialState方法，，该方法返回值就是全局可用的状态值。



**二级表格组件**

https://procomponents.ant.design/components/table?tab=api&current=1&pageSize=5



### ProComponents高级表单

1. 通过columns定义表格有哪些列
2. columns属性
   - datalndex对应返回对象的属性
   - title表格列名
   - copyable: 是否允许复制
     ellipsis: 是否允许缩略
   - valueType:用于声明这一列的类型（dataTime 、select）

### 待优化点todo

- 前端密码重复提示（可能有别的优化方式）
- 注册没有很好的提示



MSFU：前端编译优化

Ant Desion组件库 => React

Ant Desion Procomponents => Ant Desion 

Ant Desion Pro 后台管理系统 => Ant Desion ,React

Ant Desion Procomponents、其他的库

------

# 2023-11-19

1. 开发用户注销前端/后端
2. 补充用户注册校验逻辑前端/后端
3. 后端代码优化
4. 前端代码优化
5. 项目部署上线
   1. 买服务器
   2. 原生部署
   3. 容器部署
   4. 绑定域名
   5. 排查问题




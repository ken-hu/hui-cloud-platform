# hui-cloud-platform

企业级微服务项目基础服务的骨架，集成各种组件。做到真正的快速开发，尽量做到基础服务能容易扩展

## log 
2019-10 
- 新增sleuth日志链路
- 修改了logback配置，对应多环境的log不同输出
- 新增集成quartz后的简单实例

## 目标
1. 集成微服务的各种基础组件
2. 集成监控等服务，做到快速辅助开发和线上调试
3. 分层必须清晰，做到真正负责任的开源
4. 也是个开发/架构的学习过程，边学习边纠错
5. 基础服务真正考虑到实际业务。例如权限/授权/调度/分布式事务等..


## Author

```
 作者：HuHui
 转载：欢迎一起讨论web和大数据问题,转载请注明作者和Github链接，感谢
```

## 开发环境
- JDK1.8
- IDEA
- Maven
- Git
- Redis
- RabbitMQ
- Hadoop
- Spark
- kafka
- elasticSearch
- .... （随思路和开发进度更新）

## Branches


|         branche         | springcloud-version |                       note                        |
| :---------------------: | :-----------------: | :-----------------------------------------------: |
|        `master`         |  Greenwich.RELEASE  |                  !暂时只有一条分支!                |


## 服务集成

| 功能特性 | 功能服务 |           技术选型           | 进度 |                  备注                  |
| :------: | :------: | :--------------------------: | :--: | :------------------------------------: |
|          | 注册中心 | springcloud-consul-discovery |  √   |                                        |
|          | 配置中心 |  springcloud-consul-config   |  √   |                                        |
|          | 网关中心 |     springcloud-gateway      |  √   |                                        |
|          | 服务调用 |    springcloud-openfeign     |  √   |                                        |
|          | 服务监控 |       springboot-admin       |  ×   |                                        |
|          | 链路追踪 |      springcloud-seluth      |  √   |                                        |
|          | 文档管理 |           swagger2           |  √   | 已经用springcloud聚合swagger2做API文档 |
|          | 日志管理 |             elk              |  ×   |                                        |

## 组件集成

|   service    | service-name | port |                  Note                  |
| :----------: | :----------: | :--: | :------------------------------------: |
| 关系型数据库 |    mysql     | 3306 |        开发的时候使用了5.8版本         |
| NOSQL数据库  |    redis     | 6379 | 供TX-LCN-MANAGER使用/oauth2token的存储 |
|   消息队列   |   RabbitMQ   | 5672 |          提供给MQ和Stream组件          |



## 启动教程

### 0.初始化数据库 & 组件安装
【usercenter-service】-> resources/sql/uc_init_sql.sql

【auth-service】-> resources/sql/auth_init_sql.sql

【schedule-service】-> resources/sql/schedule_init.sql

```shell
#安装+运行consul
$ docker pull consul
$ docker run -d --name=dev-consul -p8500:8500 consul

#安装+运行redis
$ docker pull redis
$ docker run -d --name=dev-redis -p6379:6379 redis
```

### 1.系统服务介绍

|     service      | service-name |             features             | note |
| :--------------: | :--------------------------------: | :------------------------------: | :--: |
|     注册中心     |    springcloud-consul-discovery    | 注册中心，服务发现和治理          |      |
|     配置中心     |     springcloud-consul-config      | 配置中心，动态获取配置，灵活配置  |      |
| 分布式事务TX-LCN |        txlcn-service               |                                  |      |
|     网关中心     |         gateway-service            | 网关中心，配置路由映射,全局过滤   |      |
|     授权服务     |           auth-service             |                                  |      |
|     用户中心     |      usercenter-service            |                                  |      |
|     调度中心     |        schedule-service            | 调度中心，定时任务，任务管控      |      |

### 2.服务启动顺序

gateway-service => auth-service => usercenter-service

### 3.认证授权访问API

方法1：

访问 (gateway聚合swagger文档) localhost:9000/swagger-ui.html

选择usercenter-service

选择sys-user =》logincontroller

post请求：localhost:8001/sys-user/login

Header:  key:Authorization Val: Basic dXNlcmNlbnRlci1zZXJ2aWNlOjEyMzQ1Ng==   (注意这里是把  clientid和client_secret以  clientid:client_secret的形式做Base64编码)

获取tokenJson

```json
{
    "code": 200,
    "msg": "SUCCESS",
    "data": {
        "userName": "admin1",
        "userId": 2222222222222222,
        "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXNlcmNlbnRlci1zZXJ2aWNlIl0sInVzZXJfbmFtZSI6ImFkbWluMSIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1NzAzODcwNzEsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI2M2Q0ODE1YS0yMWVmLTQ5YjMtODJkOS0xYjA3MzIyYjEwNjkiLCJjbGllbnRfaWQiOiJ1c2VyY2VudGVyLXNlcnZpY2UifQ.rIofvqn44p2wbjrbZVz-edzYn8BG4zpIM--b-uXSLfg",
        "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXNlcmNlbnRlci1zZXJ2aWNlIl0sInVzZXJfbmFtZSI6ImFkbWluMSIsInNjb3BlIjpbImFsbCJdLCJhdGkiOiI2M2Q0ODE1YS0yMWVmLTQ5YjMtODJkOS0xYjA3MzIyYjEwNjkiLCJleHAiOjE1NzI5MzU4NzEsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI5YjI2ZjJmNC1jNGVlLTQ5MGUtYmNkZi0yODFjZWZjMTE0NjAiLCJjbGllbnRfaWQiOiJ1c2VyY2VudGVyLXNlcnZpY2UifQ.BkHh3GO0mhJsT28yWo-CaQWIW5EfxjXGTdJs81fm9-o",
        "tokenType": "bearer",
        "expiresIn": 43048,
        "scope": "all",
        "jti": "63d4815a-21ef-49b3-82d9-1b07322b1069"
    }
}
```

访问需要鉴权的API

Header：

key:Authorization 

Val: Bearer  eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidXNlcmNlbnRlci1zZXJ2aWNlIl0sInVzZXJfbmFtZSI6ImFkbWluMSIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE1NzAzNDIzNTIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJkNWM0YmJlYy0yYTQ3LTRhNDktYWM4Ny0xM2I1MGI3NGMxZjIiLCJjbGllbnRfaWQiOiJ1c2VyY2VudGVyLXNlcnZpY2UifQ.ECTGI5bYL-UD6hcjqjbf-1WXDxkcFDUyBXsjGVQbcg8

方法2： 使用postman

## 软件架构

1. 该项目是基于springcloud的微服务项目骨架
2. 除了tx-lcn外基本都采用了spring的全家桶，所有的package都可以从maven仓库下载（拒绝搞这些乱七八糟的封装之后还要下载其他私有仓库包）
3. springcloud版本为Greenwich.RELEASE
4. 服务发现采用了Consul
5. 配置中心采用了spring-cloud-starter-consul-config
6. 网关采用springcloud-gateway
7. 分布式事务处理增加tx-lcn（同步分布式事务解决方案）

## 架构图
待完善~

## 项目结构

```xml
├─cloud-admin
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─hui
│  │  │  │          └─cloud
│  │  │  │              └─admin
│  │  │  └─resources
│  │  └─test
│  │      └─java
│  └─target
│      ├─classes
│      │  └─com
│      │      └─hui
│      │          └─cloud
│      │              └─admin
│      └─generated-sources
│          └─annotations
├─cloud-auth
│  ├─cloud-auth-api
│  │  ├─src
│  │  │  ├─main
│  │  │  │  ├─java
│  │  │  │  │  └─com
│  │  │  │  │      └─hui
│  │  │  │  │          └─cloud
│  │  │  │  │              └─auth
│  │  │  │  │                  ├─api
│  │  │  │  │                  └─dto
│  │  │  │  └─resources
│  │  │  └─test
│  │  │      └─java
│  │  └─target
│  │      ├─classes
│  │      │  └─com
│  │      │      └─hui
│  │      │          └─cloud
│  │      │              └─auth
│  │      │                  ├─api
│  │      │                  └─dto
│  │      └─generated-sources
│  │          └─annotations
│  └─cloud-auth-web
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─hui
│      │  │  │          └─cloud
│      │  │  │              └─auth
│      │  │  │                  ├─config
│      │  │  │                  ├─controller
│      │  │  │                  ├─entity
│      │  │  │                  ├─handler
│      │  │  │                  ├─mapper
│      │  │  │                  ├─service
│      │  │  │                  │  ├─bo
│      │  │  │                  │  ├─exception
│      │  │  │                  │  └─impl
│      │  │  │                  └─utils
│      │  │  └─resources
│      │  │      ├─mapper
│      │  │      │  └─auth
│      │  │      └─sql
│      │  └─test
│      │      └─java
│      └─target
│          ├─classes
│          │  ├─com
│          │  │  └─hui
│          │  │      └─cloud
│          │  │          └─auth
│          │  │              ├─config
│          │  │              ├─controller
│          │  │              ├─entity
│          │  │              ├─handler
│          │  │              ├─mapper
│          │  │              ├─service
│          │  │              │  ├─bo
│          │  │              │  ├─exception
│          │  │              │  └─impl
│          │  │              └─utils
│          │  ├─mapper
│          │  │  └─auth
│          │  └─sql
│          └─generated-sources
│              └─annotations
├─cloud-common
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─hui
│  │  │  │          └─cloud
│  │  │  │              └─common
│  │  │  │                  ├─codegen
│  │  │  │                  ├─config
│  │  │  │                  ├─exception
│  │  │  │                  ├─handler
│  │  │  │                  ├─model
│  │  │  │                  └─utils
│  │  │  └─resources
│  │  └─test
│  │      └─java
│  └─target
│      ├─classes
│      │  └─com
│      │      └─hui
│      │          └─cloud
│      │              └─common
│      │                  ├─codegen
│      │                  ├─config
│      │                  ├─exception
│      │                  ├─handler
│      │                  ├─model
│      │                  └─utils
│      └─generated-sources
│          └─annotations
├─cloud-gateway
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─hui
│  │  │  │          └─cloud
│  │  │  │              └─gateway
│  │  │  │                  ├─config
│  │  │  │                  ├─filter
│  │  │  │                  └─handler
│  │  │  └─resources
│  │  └─test
│  │      └─java
│  └─target
│      ├─classes
│      │  └─com
│      │      └─hui
│      │          └─cloud
│      │              └─gateway
│      │                  ├─config
│      │                  └─handler
│      └─generated-sources
│          └─annotations
├─cloud-schedule
│  ├─cloud-schedule-api
│  │  └─src
│  │      ├─main
│  │      │  ├─java
│  │      │  └─resources
│  │      └─test
│  │          └─java
│  └─cloud-schedule-web
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─hui
│      │  │  │          └─cloud
│      │  │  │              └─schedule
│      │  │  │                  └─config
│      │  │  └─resources
│      │  │      └─sql
│      │  └─test
│      │      └─java
│      └─target
│          ├─classes
│          │  ├─com
│          │  │  └─hui
│          │  │      └─cloud
│          │  │          └─schedule
│          │  └─sql
│          └─generated-sources
│              └─annotations
├─cloud-tx-lcn
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─com
│  │  │  │      └─hui
│  │  │  │          └─cloud
│  │  │  │              └─txlcn
│  │  │  └─resources
│  │  └─test
│  │      └─java
│  └─target
│      ├─classes
│      │  └─com
│      │      └─hui
│      │          └─cloud
│      │              └─txlcn
│      └─generated-sources
│          └─annotations
├─cloud-usercenter
│  ├─cloud-usercenter-api
│  │  ├─src
│  │  │  ├─main
│  │  │  │  ├─java
│  │  │  │  │  └─com
│  │  │  │  │      └─hui
│  │  │  │  │          └─cloud
│  │  │  │  │              └─uc
│  │  │  │  │                  ├─api
│  │  │  │  │                  ├─dto
│  │  │  │  │                  └─vo
│  │  │  │  └─resources
│  │  │  └─test
│  │  │      └─java
│  │  └─target
│  │      ├─classes
│  │      │  └─com
│  │      │      └─hui
│  │      │          └─cloud
│  │      │              └─uc
│  │      │                  ├─api
│  │      │                  ├─dto
│  │      │                  └─vo
│  │      └─generated-sources
│  │          └─annotations
│  └─cloud-usercenter-web
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─hui
│      │  │  │          └─cloud
│      │  │  │              └─uc
│      │  │  │                  ├─config
│      │  │  │                  ├─constant
│      │  │  │                  ├─controller
│      │  │  │                  ├─entity
│      │  │  │                  ├─exception
│      │  │  │                  ├─mapper
│      │  │  │                  └─service
│      │  │  │                      └─impl
│      │  │  └─resources
│      │  │      ├─mapper
│      │  │      │  └─uc
│      │  │      └─sql
│      │  └─test
│      │      ├─java
│      │      │  └─com
│      │      │      └─hui
│      │      │          └─cloud
│      │      │              └─uc
│      │      │                  └─service
│      │      └─resources
│      │          └─db
│      └─target
│          ├─classes
│          │  ├─com
│          │  │  └─hui
│          │  │      └─cloud
│          │  │          └─uc
│          │  │              ├─config
│          │  │              ├─constant
│          │  │              ├─controller
│          │  │              ├─entity
│          │  │              ├─exception
│          │  │              ├─mapper
│          │  │              └─service
│          │  │                  └─impl
│          │  ├─mapper
│          │  │  └─uc
│          │  └─sql
│          ├─generated-sources
│          │  └─annotations
│          ├─generated-test-sources
│          │  └─test-annotations
│          └─test-classes
│              ├─com
│              │  └─hui
│              │      └─cloud
│              │          └─uc
│              │              └─service
│              └─db
└─logs
    ├─auth-service
    ├─gateway-service
    ├─MODEL_NAME_IS_UNDEFINED
    ├─schedule-service
    └─usercenter-service

```







# hui-cloud-platform

企业级微服务项目基础服务的骨架，集成各种组件。做到真正的快速开发，尽量做到基础服务能容易扩展

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

| 功能特性 | 功能服务 |       对应分支        |      技术选型       | 进度 | 备注 |
| :------: | :------: | :-------------------: | :-----------------: | :--: | :--: |
|          | 注册中心 | springcloud-greenwich |       Eureka        |  √   |      |
|          | 配置中心 | springcloud-greenwich | SpringCloud-Config  |  √   |      |
|          | 网关中心 | springcloud-greenwich | SpringCloud-Gateway |  √   |      |
|          | 服务调用 | springcloud-greenwich |      OpenFeign      |  √   |      |
|          | 服务监控 |          ALL          |  SpringBoot Admin   |  ×   |      |
|          | 链路追踪 |          ALL          |                     |  ×   |      |
|          | 文档管理 |          ALL          |      Swagger2       |  √   |      |
|          | 日志管理 |                       |                     |  ×   |      |

## 启动教程

### 0.初始化数据库

SQL/init_table.sql

### 1. 基础服务

|   service    | service-name | port |          Note           |
| :----------: | :----------: | :--: | :---------------------: |
| 关系型数据库 |    mysql     | 3306 | 开发的时候使用了5.6版本 |
| NOSQL数据库  |    redis     | 6379 |  供TX-LCN-MANAGER使用   |
|   消息队列   |   RabbitMQ   | 5672 |  提供给MQ和Stream组件   |

### 2.系统服务

|     service      | service-name（Greenwich/Finchley） |             features             | note |
| :--------------: | :--------------------------------: | :------------------------------: | :--: |
|     注册中心     |              Consul                | 注册中心，服务发现和治理          |      |
|     配置中心     |              Consul                | 配置中心，动态获取配置，灵活配置  |      |
| 分布式事务TX-LCN |        LcnServerApplication        |                                  |      |
|     网关中心     |         GatewayApplication         | 网关中心，配置路由映射,全局过滤   |      |      
|   授权服务       |           AuthApplication          |                                  |      |
|   用户中心       |              UcApplication         |                                  |      |

```
## 软件架构

1. 该项目是基于springcloud的微服务项目骨架
2. 除了tx-lcn外基本都采用了spring的全家桶，所有的package都可以从maven仓库下载
3. springcloud版本为Greenwich.RELEASE
4. 服务发现采用了Consul
5. 配置中心采用了spring-cloud-starter-consul-config
6. 网关采用springcloud-gateway
7. 分布式事务处理增加tx-lcn（同步分布式事务解决方案）

## 架构图
待完善~

## 项目结构
``` xml
├─cloud-admin
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─hui
│          │          └─cloud
│          │              └─admin
│          └─resources
├─cloud-auth
│  ├─cloud-auth-api
│  ├─cloud-auth-web
│  │  └─src
│  │      └─main
│  │          ├─java
│  │          │  └─com
│  │          │      └─hui
│  │          │          └─cloud
│  │          │              └─auth
│  │          │                  ├─config
│  │          │                  └─oauth
│  │          │                      ├─controller
│  │          │                      ├─handler
│  │          │                      ├─mapper
│  │          │                      ├─model
│  │          │                      │  ├─bo
│  │          │                      │  └─entity
│  │          │                      └─service
│  │          │                          └─impl
│  │          └─resources
│  │              └─sql
│  └─src
│      └─main
│          └─java
│              └─com
│                  └─hui
│                      └─cloud
│                          └─auth
│                              └─oauth
│                                  └─model
│                                      └─entity
├─cloud-common
│  ├─src
│  │  └─main
│  │      └─java
│  │          └─com
│  │              └─hui
│  │                  └─cloud
│  │                      └─common
│  │                          ├─codegen
│  │                          ├─config
│  │                          ├─handler
│  │                          ├─model
│  │                          └─utils
│  └─target
│      ├─classes
│      │  ├─com
│      │  │  └─hui
│      │  │      └─cloud
│      │  │          └─common
│      │  │              ├─codegen
│      │  │              ├─config
│      │  │              ├─handler
│      │  │              ├─model
│      │  │              └─utils
│      │  └─META-INF
│      └─generated-sources
│          └─annotations
├─cloud-gateway
│  └─src
│      └─main
│          ├─java
│          │  └─com
│          │      └─hui
│          │          └─cloud
│          │              └─gateway
│          │                  ├─config
│          │                  └─filter
│          └─resources
└─cloud-usercenter
    ├─cloud-usercenter-api
    │  └─src
    │      └─main
    │          └─java
    │              └─com
    │                  └─hui
    │                      └─cloud
    │                          └─uc
    │                              └─user
    │                                  ├─api
    │                                  └─dto
    └─cloud-usercenter-web
        ├─src
        │  ├─main
        │  │  ├─java
        │  │  │  └─com
        │  │  │      └─hui
        │  │  │          └─cloud
        │  │  │              └─uc
        │  │  │                  ├─config
        │  │  │                  └─user
        │  │  │                      ├─controller
        │  │  │                      ├─mapper
        │  │  │                      ├─model
        │  │  │                      │  ├─constant
        │  │  │                      │  └─entity
        │  │  │                      └─service
        │  │  │                          ├─bo
        │  │  │                          └─impl
        │  │  └─resources
        │  │      ├─mapper
        │  │      │  └─user
        │  │      └─sql
        │  └─test
        │      ├─java
        │      │  └─com
        │      │      └─hui
        │      │          └─cloud
        │      │              └─uc
        │      │                  └─user
        │      │                      └─service
        │      └─resources
        └─target
            ├─classes
            │  ├─com
            │  │  └─hui
            │  │      └─cloud
            │  │          └─uc
            │  │              ├─config
            │  │              └─user
            │  │                  ├─controller
            │  │                  ├─mapper
            │  │                  ├─model
            │  │                  │  ├─constant
            │  │                  │  └─entity
            │  │                  └─service
            │  │                      └─impl
            │  ├─mapper
            │  │  └─user
            │  └─sql
            ├─generated-sources
            │  └─annotations
            ├─generated-test-sources
            │  └─test-annotations
            └─test-classes
                └─com
                    └─hui
                        └─cloud
                            └─uc
                                └─user
                                    └─service
  







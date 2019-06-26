# 基于SpringClound的天气预报项目

## 技术栈:
技术|版本|
--|:--:|--:
Springboot|2.1.6.RELEASE/M3
SpringCloud|Greenwich.SR1/Finchley.M2
Redis|3.2.100
JDK| 8
Gradle|4.4
Eureka|Greenwich.SR1/Finchley.M2
OpenFeign|Greenwich.SR1/Finchley.M2
Zuul|Greenwich.SR1/Finchley.M2
Hystrix| Greenwich.SR1/Finchley.M2
Apache HttpClient| 4.5.3
Quartz Scheduler|2.3.0 模板引擎
Thymeleaf|3.0.7.RELEASE
Bootstrap| 4.0.0-beta.2
Ribbon| Greenwich.SR1/Finchley.M2

## 项目服务分隔
  1. 天气数据采集微服务（数据采集、数据存储）
  2. 天气预报微服务（数据查询）
  3. 天气数据API微服务（数据展示）
  4. 城市数据API微服务（数据展示）


## 项目架构
![架构图](https://github.com/YoungBanian/Resources/blob/master/Weather.png?raw=true)
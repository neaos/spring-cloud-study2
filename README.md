# spring-cloud-study2
> 基于Spring Boot 2.0.x与Spring Cloud Finchley

**服务网关**: gateway

- 演示`ZuulFilter`中的前置过滤器: token验证

**服务发现与注册中心**

- Eureka Server: eureka

**用户微服务: cloudlink-user**

- 数据操作和访问

**巡检微服务: cloudlink-inspection**

- 数据操作和访问
- 演示服务间调用
  - RestTemplate方式
  - Feign Client 方式
- 演示Feign Hystrix超时熔断的回调方法
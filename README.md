# myBoot
SpringBoot 系列笔记


### mybatis集成

- 数据库datasource配置在application.properties中
- 开启 mapperscan，指定扫描路径
- 写mapper接口
- 测试用例

#### XML 配置方式

- 在application.properties中配置
    mybatis.config-locations=classpath:mybatis/mybatis-config.xml
    mybatis.mapper-locations=classpath:mybatis/mapper/*.xml

- 写XXXmapper.java
- 写XXXmapper.xml
- 单元测试


### mybatis 多数据源集成

- 多个数据库配置信息
- 数据源配置类 DataSource1Config、DataSource2Config



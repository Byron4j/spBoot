## 自定义查询
- 自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称
- 基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy
- 也使用一些加一些关键字And、 Or
## jpa 不支持返回原始类型

## 分页查询
- 分页查询在实际使用中非常普遍了，spring data jpa已经帮我们实现了分页的功能，在查询的方法中，需要传入参数Pageable
- Pageable 是spring封装的分页实现类，使用的时候需要传入页数、每页条数和排序规则 3 个参数

## 限制查询
时候我们只需要查询前N个元素，或者支取前一个实体
- User findTopByOrderByNickNameDesc();

- Page<User> queryFirst10ByNickName(String nickName, Pageable pageable);

- List<User> findFirst10ByNickName(String nickName, Sort sort);

- List<User> findTop10ByNickName(String nickName, Pageable pageable);


## 自定义SQL查询

>在SQL的查询方法上面使用 ```@Query```注解，如涉及到删除和修改在需要加上 ```@Modifying```.
也可以根据需要添加 ```@Transactional``` 对事物的支持，查询超时的设置等

使用的是映射的实体类对象 User，不是表名user，大小写是敏感的。
```java
@Query("select u from User u where u.id = ?1")
Integer findUserById(Long id);
```

## 多表查询

多表查询在spring data jpa中有两种实现方式，第一种是利用hibernate的级联查询来实现，
第二种是创建一个结果集的接口来接收连表查询后的结果。

## 异构数据库多源支持

比如我们的项目中，即需要对mysql的支持，也需要对mongodb的查询等。

实体类声明 ```@Entity``` 关系型数据库支持类型、声明 ```@Document``` 为mongodb支持类型，不同的数据源使用不同的实体就可以了。

如果实体类既使用mysql又使用mongodb，则可以混合使用。

```
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

/**
 * created by BYRON.Y.Y at 2018/9/29 9:11
 */
@Entity
@Document
public class Person {

}
```





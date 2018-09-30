package com.example.myboot.repository;

import com.example.myboot.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

    /*
    自定义查询
    自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
     */
    List<User> findByNickName(String nickName);
    // 不支持返回原始类型，返回int ---> error
    Integer readByUserName(String userName);

    /*
    分页查询
     */
    List<User> findByUserName(String userName, Pageable pageable);


    /*
    限制插叙
     */
    User findTopByOrderByNickNameDesc();
    Page<User> queryFirst10ByNickName(String nickName, Pageable pageable);
    List<User> findFirst10ByNickName(String nickName, Sort sort);
    List<User> findTop10ByNickName(String nickName, Pageable pageable);

    /*
    自定义SQL查询
     */
    @Query("select u from User u where u.id = ?1")
    Integer findUserById(Long id);
}

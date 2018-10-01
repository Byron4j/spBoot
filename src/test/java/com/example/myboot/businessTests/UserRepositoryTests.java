package com.example.myboot.businessTests;

import com.example.myboot.domain.User;
import com.example.myboot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    private static Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTests.class);
    @Autowired
    private UserRepository userRepository;

    @Test
    @Ignore
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));

        Assert.assertEquals(9, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }

    @Test
    public void jpaTest(){
        User user= User.builder()
                .email("123@126.com")
                .nickName("Nick")
                .passWord("25tsg56564@344")
                .userName("Nick")
                .regTime("2018-01-01 12:00:00")
                .build();
        userRepository.findAll();
        userRepository.save(user);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userRepository.findByUserNameOrEmail("username", "email");
        userRepository.readByUserName("aa");
        userRepository.findByNickName("abc");
        userRepository.delete(user);
        userRepository.count();


        // 限制查询
        userRepository.findTopByOrderByNickNameDesc();


        // 分页查询--使用Pageable的实现类PageRequest
        int page = 1; int pageSize = 10;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        userRepository.findByUserName("aa1", pageRequest);

        // 分页查询--使用匿名类
        userRepository.findByUserName("aa1", new Pageable() {
            @Override
            public int getPageNumber() {
                return 1;
            }

            @Override
            public int getPageSize() {
                return 10;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return new Sort(Sort.Direction.ASC, "id");
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        });

        Assert.assertEquals(3, userRepository.findAll().size());


        // 自定义SQL查询
        userRepository.findUserById(1L);

    }

}

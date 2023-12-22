package com.example.bookshop.service;

import com.example.bookshop.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
class UserServiceTest {
    UserService service = new UserService();
    @BeforeAll
    static void setUp() {
        log.info("UserServiceTest set up");
    }

    @AfterAll
    static void tearDown() {
        log.info("UserServiceTest tear down");
    }

    @Test
    void register() {
        User user = new User("xas","cas","ca","csc","ca","ca");
        log.info(String.valueOf(service.register(user)));
    }

    @Test
    void login() {
        log.info(service.login("admin","admin").toString());
    }

    @Test
    void selectById() {
        log.info(service.selectById(1).toString());
    }

    @Test
    void updateUserAddress() {
        User user = new User("1","1", "1", "1", "1","1");
        service.updateUserAddress(user);
    }

    @Test
    void updatePwd() {
        User user = new User();
        user.setId(9);
        user.setPassword("111");
        service.updatePwd(user);
    }

    @Test
    void getUserPage() {
        log.info(service.getUserPage(1).toString());
    }

    @Test
    void delete() {
        service.delete(13);
    }
}
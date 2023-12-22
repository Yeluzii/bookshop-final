package com.example.bookshop.service;

import com.example.bookshop.mapper.TypeMapper;
import com.example.bookshop.model.Type;
import com.example.bookshop.utils.MyBatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
class TypeServiceTest {
    private final TypeService service = new TypeService();
    @BeforeAll
    static void setUp() {
        log.info("TypeServiceTest set up");
    }

    @AfterAll
    static void tearDown() {
        log.info("TypeServiceTest tear down");
    }

    @Test
    void getAllType() {
        service.GetAllType().forEach(System.out::println);
    }

    @Test
    void selectTypeNameByID() {
        log.info(service.selectTypeNameByID(10).toString());
    }

    @Test
    void select() {
        log.info(service.select(1).toString());
    }

    @Test
    void insert() {
        service.insert(new Type(17,"Web应用测试"));
    }

    @Test
    void update() {
        service.update(new Type(17, "Web"));
    }

    @Test
    void delete() {
        MyBatisUtils.executeUpdate(sqlSession -> sqlSession.getMapper(TypeMapper.class).delete(17));
    }
}
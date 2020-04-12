package com.jay.sell;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.ServletTestExecutionListener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.TreeSet;

@MapperScan("com.jay.sell.dao")
@SpringBootTest
class SellApplicationTests {

    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.toString());

        System.out.println("==================");

        System.out.println(logger.getName());
        System.out.println(logger.getClass());


    }

}

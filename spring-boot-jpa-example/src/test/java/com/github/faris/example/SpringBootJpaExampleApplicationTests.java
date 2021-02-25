package com.github.faris.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
@Rollback(value = true)
@EnableTransactionManagement
class SpringBootJpaExampleApplicationTests {

    @Test
    void contextLoads() {
    }
}

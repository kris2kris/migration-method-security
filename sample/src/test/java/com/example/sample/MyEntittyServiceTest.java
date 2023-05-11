package com.example.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import({MyEntittyService.class})
class MyEntittyServiceTest {

    @Autowired
    private MyEntittyService myEntittyService;

    @WithMockUser
    @Test
    void findAll() {
        myEntittyService.findAll("");
    }
}
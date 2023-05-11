package com.example.sample;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
public class MyEntittyService {

    public MyEntittyService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
        for(int i = 0; i< 5;i++) {
            MyEntity m = new MyEntity();
            m.setId((long) i);
            m.setName("name");
            this.myEntityRepository.save(m);
        }
    }

    private final MyEntityRepository myEntityRepository;

    @Transactional
    @PreAuthorize("hasPermission(#name, 'test', 'test')")
    public Stream<MyEntity> findAll(String name) {
        return myEntityRepository.findByName("name");
    }
}

package com.example.sample;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.stream.Stream;

@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    private final MyEntityRepository myEntityRepository;

    public MyPermissionEvaluator(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return myEntityRepository.findAll().isEmpty();
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        Stream<MyEntity> m = myEntityRepository.findByName("");
        return m.noneMatch(s -> s.getName().equals("n"));
    }
}

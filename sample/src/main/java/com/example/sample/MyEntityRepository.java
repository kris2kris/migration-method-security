package com.example.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
    Stream<MyEntity> findByName(String name);
}

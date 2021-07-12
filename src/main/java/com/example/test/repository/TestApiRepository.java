package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.model.TestApi;

public interface TestApiRepository extends JpaRepository<TestApi, Long> {

}

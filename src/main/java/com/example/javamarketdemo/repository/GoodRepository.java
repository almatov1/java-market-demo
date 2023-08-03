package com.example.javamarketdemo.repository;

import com.example.javamarketdemo.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, String> {
}

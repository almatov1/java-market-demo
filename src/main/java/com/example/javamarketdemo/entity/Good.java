package com.example.javamarketdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class Good {
    //    @Id
//    @GenericGenerator(name = "uuid2")
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
//    @Column(length = 36, nullable = false, updatable = false)
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
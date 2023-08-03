package com.example.javamarketdemo.service;

import com.example.javamarketdemo.dto.GoodDto;
import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GoodService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    String kafkaTopic = "basic-topic";


    private final GoodRepository goodRepository;

    public Good save(GoodDto goodDto) {
        Good good = new Good()
                .setName(goodDto.getName())
                .setCreatedAt(LocalDateTime.now());

        return goodRepository.save(good);
    }

    public Iterable<Good> getAll(int offset, int limit) {
        kafkaTemplate.send(kafkaTopic, "hello");

        return goodRepository.findAll(PageRequest.of(offset, limit));
    }
}

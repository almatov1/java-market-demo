package com.example.javamarketdemo.service;

import com.example.javamarketdemo.dto.GoodDto;
import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class GoodService {

    private final GoodRepository goodRepository;
    private final KafkaSenderService kafkaSenderService;

    public Good save(GoodDto goodDto) {
        Good good = new Good()
                .setName(goodDto.getName())
                .setCreatedAt(LocalDateTime.now());
        return goodRepository.save(good);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "getAllGood", key = "#offset-#limit", condition = "!#updateCache")
            },
            put = {
                    @CachePut(value = "getAllGood", key = "#offset-#limit", condition = "#updateCache")
            }
    )
    public Iterable<Good> getAll(int offset, int limit, boolean updateCache) {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        kafkaSenderService.sendMessage("Hello world!");
        log.info("All goods showed");
        return goodRepository.findAll(PageRequest.of(offset, limit));
    }
}

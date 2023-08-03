package com.example.javamarketdemo.service;

import com.example.javamarketdemo.dto.GoodDto;
import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GoodService {

    private final GoodRepository goodRepository;

    public Good save(GoodDto goodDto) {
        Good good = new Good()
                .setName(goodDto.getName())
                .setCreatedAt(LocalDateTime.now());

        return goodRepository.save(good);
    }

    public Iterable<Good> getAll(int offset, int limit) {
        return goodRepository.findAll(PageRequest.of(offset, limit));
    }
}

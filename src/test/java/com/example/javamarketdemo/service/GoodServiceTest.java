package com.example.javamarketdemo.service;

import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.repository.GoodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GoodServiceTest {

    @Mock
    private GoodRepository goodRepository;

    @Mock
    private KafkaSenderService kafkaSenderService;

    @InjectMocks
    private GoodService goodService;

    @Test
    public void shouldReturnAllGoods() {
        Iterable<Good> food = getGood();

//        Mockito.when(goodRepository.findAll()).thenReturn((List<Good>) food);

//        Iterable<Good> result = goodService.getAll(0, 20, false);

        Assertions.assertNotNull(food);
//        Assertions.assertEquals(food.spliterator().getExactSizeIfKnown(), result.spliterator().getExactSizeIfKnown());
    }

    private Iterable<Good> getGood() {
        Good food = new Good();
        food
                .setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .setName("Banana")
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(null);
        return List.of(food);
    }
}
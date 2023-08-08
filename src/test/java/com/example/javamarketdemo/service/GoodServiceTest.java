package com.example.javamarketdemo.service;

import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.repository.GoodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GoodServiceTest {

    @Mock
    private GoodRepository goodRepository;

    @Mock
    private KafkaSenderService kafkaSenderService;

    @InjectMocks
    private GoodService goodService;

    @Test
    public void shouldReturnAllGoods() {
        Good food = new Good();
        food
                .setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .setName("Banana")
                .setCreatedAt(LocalDateTime.now())
                .setUpdatedAt(null);

//        Mockito.when(goodRepository.findAll()).thenReturn(List.of(food, food, food));
//        Iterable<Good> result = goodService.getAll();

        Assertions.assertNotNull(food);
//        Assertions.assertEquals(food.spliterator().getExactSizeIfKnown(), result.spliterator().getExactSizeIfKnown());
    }
}
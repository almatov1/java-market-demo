package com.example.javamarketdemo.controller;

import com.example.javamarketdemo.dto.GoodDto;
import com.example.javamarketdemo.entity.Good;
import com.example.javamarketdemo.service.GoodService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
@RequiredArgsConstructor
public class GoodController {

    private final GoodService goodService;

    @PostMapping
    public Good save(@RequestBody GoodDto goodDto) {
        return goodService.save(goodDto);
    }

    @GetMapping
    public Iterable<Good> getAll(
            @RequestParam(
                    name = "offset",
                    defaultValue = "0"
            )
            @Min(0)
            Integer offset,

            @RequestParam(
                    name = "limit",
                    defaultValue = "20"
            )
            @Min(1)
            @Max(100)
            Integer limit
    ) {
        return goodService.getAll(offset, limit);
    }
}

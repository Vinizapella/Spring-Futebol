package com.weg.soccer.controller;

import com.weg.soccer.dto.stadium.StadiumRequestDto;
import com.weg.soccer.dto.stadium.StadiumResponseDto;
import com.weg.soccer.service.StadiumService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }
    @PostMapping
    public StadiumResponseDto saveStadium(
            @Valid @RequestBody StadiumRequestDto stadiumRequestDto
    ) {
        return stadiumService.saveStadium(stadiumRequestDto);
    }
    @GetMapping
    public List<StadiumResponseDto> listStadiums() {
        return stadiumService.listStadiums();
    }
    @GetMapping("/{id}")
    public StadiumResponseDto searchOne(
            @PathVariable Integer id
    ) {
        return stadiumService.searchOne(id);
    }
    @PutMapping("/{id}")
    public StadiumResponseDto updateStadium(
            @Valid @RequestBody StadiumRequestDto stadiumRequestDto,
            @PathVariable Integer id
    ) {
        return stadiumService.updateStadium(stadiumRequestDto, id);
    }
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        stadiumService.delete(id);
    }
}

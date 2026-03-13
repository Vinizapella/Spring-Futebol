package com.weg.soccer.controller;

import com.weg.soccer.dto.club.ClubRequestDto;
import com.weg.soccer.dto.club.ClubResponseDto;
import com.weg.soccer.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/club")
@RestController
public class ClubController {

    private final ClubService clubService;

    public ClubController(
            ClubService clubService
    ){
        this.clubService = clubService;
    }
    @PostMapping
    public ClubResponseDto saveClub(
            @Valid @RequestBody ClubRequestDto clubRequestDto
    ) {
        return clubService.saveClub(clubRequestDto);
    }
    @GetMapping
    public List<ClubResponseDto> listClub() {
        return clubService.listClub();
    }
    @GetMapping("/{id}")
    public ClubResponseDto searchOne(
            @PathVariable Integer id
    ) {
        return clubService.searchOne(id);
    }
    @PutMapping("/{id}")
    public ClubResponseDto updateClub(
            @Valid @RequestBody ClubRequestDto clubRequestDto,
            @PathVariable Integer id
    ) {
        return clubService.updateClub(clubRequestDto, id);
    }
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        clubService.delete(id);
    }
}

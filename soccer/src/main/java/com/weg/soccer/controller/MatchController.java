package com.weg.soccer.controller;

import com.weg.soccer.dto.match.MatchRequestDto;
import com.weg.soccer.dto.match.MatchResponseDto;
import com.weg.soccer.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/match")
@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @PostMapping
    public MatchResponseDto saveMatch(
            @Valid @RequestBody MatchRequestDto matchRequestDto
    ) {
        return matchService.saveMatch(matchRequestDto);
    }
    @GetMapping
    public List<MatchResponseDto> listMtch() {
        return matchService.listMtch();
    }
    @GetMapping("/{id}")
    public MatchResponseDto searchOne(
            @PathVariable Integer id
    ) {
        return matchService.searchOne(id);
    }
    @PutMapping("/{id}")
    public MatchResponseDto updateMatch(
            @Valid @RequestBody MatchRequestDto matchRequestDto,
            @PathVariable Integer id
    ) {
        return matchService.updateMatch(matchRequestDto, id);
    }
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        matchService.delete(id);
    }
}

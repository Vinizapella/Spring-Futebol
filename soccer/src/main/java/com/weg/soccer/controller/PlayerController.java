package com.weg.soccer.controller;

import com.weg.soccer.dto.player.PlayerRequestDto;
import com.weg.soccer.dto.player.PlayerResponseDto;
import com.weg.soccer.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController (
            PlayerService playerService
    ){
        this.playerService = playerService;
    }

    @PostMapping
    public PlayerResponseDto savePlayer(
            @Valid @RequestBody PlayerRequestDto playerRequestDto
    ){
      return playerService.savePlayer(playerRequestDto);
    }

    @GetMapping
    public List<PlayerResponseDto> listPlayers(){
        return playerService.listPlayer();
    }

    @GetMapping("/{id}")
    public PlayerResponseDto searchOne(
            @PathVariable Integer id
    ){
        return playerService.searchOne(id);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto playerUpdate(
            @Valid @RequestBody PlayerRequestDto playerRequestDto,
            @PathVariable Integer id
    ){
        return playerService.updatePlayer(playerRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(
            @PathVariable  Integer id
    ){
        playerService.delete(id);
    }
}

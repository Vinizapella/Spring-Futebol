package com.weg.soccer.controller;

import com.weg.soccer.dto.player.PlayerRequestDto;
import com.weg.soccer.dto.player.PlayerResponseDto;
import com.weg.soccer.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

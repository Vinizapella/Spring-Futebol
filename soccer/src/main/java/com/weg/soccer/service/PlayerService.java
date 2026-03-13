package com.weg.soccer.service;

import com.weg.soccer.dto.player.PlayerRequestDto;
import com.weg.soccer.dto.player.PlayerResponseDto;
import com.weg.soccer.mapper.PlayerMapper;
import com.weg.soccer.model.Player;
import com.weg.soccer.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(
            PlayerRepository playerRepository,
            PlayerMapper playerMapper
    ){
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public PlayerResponseDto savePlayer(
            PlayerRequestDto playerRequestDto
    ){
        Player player = playerMapper.toEntity(playerRequestDto);
        Player playerSave = playerRepository.save(player);
        return playerMapper.toResponse(playerSave);
    }
}

package com.weg.soccer.service;

import com.weg.soccer.dto.player.PlayerRequestDto;
import com.weg.soccer.dto.player.PlayerResponseDto;
import com.weg.soccer.mapper.PlayerMapper;
import com.weg.soccer.model.Player;
import com.weg.soccer.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<PlayerResponseDto> listPlayer(){
        List<Player> players = playerRepository.findAll();

        return players.stream()
                .map(playerMapper::toResponse)
                .toList();
    }

    public PlayerResponseDto searchOne(
            Integer id
    ){
        return playerRepository.findById(id)
                .map(playerMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Player not found " +id));
    }

    public PlayerResponseDto updatePlayer(
            PlayerRequestDto playerRequestDto,
            Integer id
    ){
        Player player = playerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Player not found"));

        player.setName(playerRequestDto.name());
        player.setOld(playerRequestDto.old());
        player.setPosition(playerRequestDto.position());
        player.setMarket_value(playerRequestDto.market_value());
        player.setShirt(playerRequestDto.shirt());

        Player playerUpdate = playerRepository.save(player);

        return playerMapper.toResponse(playerUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!playerRepository.existsById(id)){
           throw new RuntimeException("Player not found");
        }

        playerRepository.deleteById(id);
    }
}

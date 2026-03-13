package com.weg.soccer.mapper;

import com.weg.soccer.dto.player.PlayerRequestDto;
import com.weg.soccer.dto.player.PlayerResponseDto;
import com.weg.soccer.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public Player toEntity(
            PlayerRequestDto playerRequestDto
    ){
        return new Player(
                null,
                playerRequestDto.name(),
                playerRequestDto.old(),
                playerRequestDto.position(),
                playerRequestDto.market_value(),
                playerRequestDto.shirt()
        );
    }

    public PlayerResponseDto toResponse(
            Player player
    ){
        return new PlayerResponseDto(
                player.getId(),
                player.getName(),
                player.getOld(),
                player.getPosition(),
                player.getMarket_value(),
                player.getShirt()
        );
    }

}

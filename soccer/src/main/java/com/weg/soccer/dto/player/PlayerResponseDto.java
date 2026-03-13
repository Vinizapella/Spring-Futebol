package com.weg.soccer.dto.player;

public record PlayerResponseDto(
        Integer id,
        String name,
        Integer old,
        String position,
        Double market_value,
        Integer shirt
) {
}

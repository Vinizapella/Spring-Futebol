package com.weg.soccer.dto.club;

import java.time.LocalDate;

public record ClubResponseDto(
        Integer id,
        String name,
        String acronym,
        LocalDate foundationDate,
        String city,
        String division
) {
}

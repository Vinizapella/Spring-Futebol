package com.weg.soccer.dto.stadium;

import java.time.LocalDate;

public record StadiumResponseDto(
        Integer id,
        String name,
        Integer capacity,
        String city,
        String state,
        String turfType,
        LocalDate inaugurationDate
) {
}

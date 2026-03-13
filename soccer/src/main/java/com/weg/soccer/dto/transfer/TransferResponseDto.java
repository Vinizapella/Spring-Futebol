package com.weg.soccer.dto.transfer;

import java.time.LocalDate;

public record TransferResponseDto(
        Integer id,
        String playerName,
        String clubOrigin,
        String clubDestination,
        Double valueRate,
        LocalDate dateTransference,
        Boolean international
) {
}

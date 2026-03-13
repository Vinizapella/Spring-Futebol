package com.weg.soccer.dto.match;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record MatchRequestDto(
        @NotBlank(message = "Home team is mandatory")
        String homeTeam,

        @NotBlank(message = "Visiting team is mandatory")
        String visitingTeam,

        @NotNull(message = "Home team goals is mandatory")
        @PositiveOrZero(message = "Goals cannot be negative")
        Integer homeTeamGoals,

        @NotNull(message = "Visiting team goals is mandatory")
        @PositiveOrZero(message = "Goals cannot be negative")
        Integer visitingTeamGoals,

        @NotNull(message = "Match date and time is mandatory")
        LocalDateTime departureDateTime,

        @NotBlank(message = "Stadium name is mandatory")
        String stadiumName
) {}


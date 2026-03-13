package com.weg.soccer.dto.match;

import java.time.LocalDateTime;

public record MatchResponseDto(
        Integer id,
        String hometeam,
        String visitingTeam,
        Integer homeTeamGoals,
        Integer visitingTeamGoals,
        LocalDateTime departureDateTime,
        String stadiumName
) {
}

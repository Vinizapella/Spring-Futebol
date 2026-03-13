package com.weg.soccer.mapper;

import com.weg.soccer.dto.match.MatchRequestDto;
import com.weg.soccer.dto.match.MatchResponseDto;
import com.weg.soccer.model.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public Match toEntity(MatchRequestDto dto) {
        return new Match(
                null,
                dto.homeTeam(),
                dto.visitingTeam(),
                dto.homeTeamGoals(),
                dto.visitingTeamGoals(),
                dto.departureDateTime(),
                dto.stadiumName()
        );
    }

    public MatchResponseDto toResponse(Match match) {
        return new MatchResponseDto(
                match.getId(),
                match.getHomeTeam(),
                match.getVisitingTeam(),
                match.getHomeTeamGoals(),
                match.getVisitingTeamGoals(),
                match.getDepartureDateTime(),
                match.getStadiumName()
        );
    }
}

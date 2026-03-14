package com.weg.soccer.service;

import com.weg.soccer.dto.match.MatchRequestDto;
import com.weg.soccer.dto.match.MatchResponseDto;
import com.weg.soccer.mapper.MatchMapper;
import com.weg.soccer.model.Match;
import com.weg.soccer.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    public MatchService(MatchRepository matchRepository, MatchMapper matchMapper) {
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
    }

    public MatchResponseDto saveMatch(
            MatchRequestDto matchRequestDto
    ){
        Match match = matchMapper.toEntity(matchRequestDto);
        Match matchSave = matchRepository.save(match);
        return matchMapper.toResponse(matchSave);
    }

    public List<MatchResponseDto> listMtch(){
        List<Match> matchs = matchRepository.findAll();

        return matchs.stream()
                .map(matchMapper::toResponse)
                .toList();
    }

    public MatchResponseDto searchOne(
            Integer id
    ){
        return matchRepository.findById(id)
                .map(matchMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Match not found"));
    }

    public MatchResponseDto updateMatch(
            MatchRequestDto matchRequestDto,
            Integer id
    ){
        Match match = matchRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Match not found"));

        match.setHomeTeam(matchRequestDto.homeTeam());
        match.setVisitingTeam(matchRequestDto.visitingTeam());
        match.setHomeTeamGoals(matchRequestDto.homeTeamGoals());
        match.setVisitingTeamGoals(matchRequestDto.visitingTeamGoals());
        match.setDepartureDateTime(matchRequestDto.departureDateTime());
        match.setStadiumName(matchRequestDto.stadiumName());

        Match matchUpdate = matchRepository.save(match);
        return matchMapper.toResponse(matchUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!matchRepository.existsById(id)){
            throw new RuntimeException("Match not found");
        }
        matchRepository.deleteById(id);
    }

}

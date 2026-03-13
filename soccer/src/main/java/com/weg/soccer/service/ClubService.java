package com.weg.soccer.service;

import com.weg.soccer.dto.club.ClubRequestDto;
import com.weg.soccer.dto.club.ClubResponseDto;
import com.weg.soccer.mapper.ClubMapper;
import com.weg.soccer.model.Club;
import com.weg.soccer.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public ClubService(
            ClubRepository clubRepository,
            ClubMapper clubMapper
    ){
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public ClubResponseDto saveClub(
            ClubRequestDto clubRequestDto
    ){
        Club club = clubMapper.toEntity(clubRequestDto);
        Club clubSave = clubRepository.save(club);
        return clubMapper.toResponse(clubSave);
    }

    public List<ClubResponseDto> listClub(){
        List<Club> clubs = clubRepository.findAll();

        return clubs.stream()
                .map(clubMapper::toResponse)
                .toList();
    }

    public ClubResponseDto searchOne(
            Integer id
    ){
        return clubRepository.findById(id)
                .map(clubMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Club not found " +id));
    }

    public ClubResponseDto updateClub(
            ClubRequestDto clubRequestDto,
            Integer id
    ){
        Club club = clubRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Club not found"));

        club.setName(clubRequestDto.name());
        club.setAcronym(clubRequestDto.acronym());
        club.setFoundationDate(clubRequestDto.foundationDate());
        club.setCity(clubRequestDto.city());
        club.setDivision(clubRequestDto.division());

        Club clubUpdate = clubRepository.save(club);
        return clubMapper.toResponse(clubUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!clubRepository.existsById(id)){
            throw new RuntimeException("Club not found");
        }
        clubRepository.deleteById(id);
    }

}

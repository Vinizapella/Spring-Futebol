package com.weg.soccer.service;

import com.weg.soccer.dto.stadium.StadiumRequestDto;
import com.weg.soccer.dto.stadium.StadiumResponseDto;
import com.weg.soccer.mapper.StadiumMapper;
import com.weg.soccer.model.Stadium;
import com.weg.soccer.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumService(
            StadiumRepository stadiumRepository,
            StadiumMapper stadiumMapper
    ){
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    public StadiumResponseDto saveStadium(
            StadiumRequestDto stadiumRequestDto
    ){
        Stadium stadium = stadiumMapper.toEntity(stadiumRequestDto);
        Stadium stadiumSave = stadiumRepository.save(stadium);
        return stadiumMapper.toResponse(stadiumSave);
    }

    public List<StadiumResponseDto> listStadiums(){
        List<Stadium> stadiums = stadiumRepository.findAll();

        return stadiums.stream()
                .map(stadiumMapper::toResponse)
                .toList();
    }

    public StadiumResponseDto searchOne(
            Integer id
    ){
        return stadiumRepository.findById(id)
                .map(stadiumMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Stadium not found"));
    }

    public StadiumResponseDto updateStadium(
            StadiumRequestDto stadiumRequestDto,
            Integer id
    ){
        Stadium stadium = stadiumRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Staium not found"));

        stadium.setName(stadiumRequestDto.name());
        stadium.setCapacity(stadiumRequestDto.capacity());

        Stadium stadiumUpdate = stadiumRepository.save(stadium);
        return stadiumMapper.toResponse(stadiumUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!stadiumRepository.existsById(id)){
            throw new RuntimeException("Club not found");
        }

        stadiumRepository.deleteById(id);
    }
}

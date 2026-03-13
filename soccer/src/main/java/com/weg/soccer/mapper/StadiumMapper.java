package com.weg.soccer.mapper;

import com.weg.soccer.dto.stadium.StadiumRequestDto;
import com.weg.soccer.dto.stadium.StadiumResponseDto;
import com.weg.soccer.model.Stadium;

public class StadiumMapper {

    public Stadium toEntity(StadiumRequestDto dto) {
        return new Stadium(
                null,
                dto.name(),
                dto.capacity()
        );
    }

    public StadiumResponseDto toResponse(Stadium stadium) {
        return new StadiumResponseDto(
                stadium.getId(),
                stadium.getName(),
                stadium.getCapacity()
        );
    }
}

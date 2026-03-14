package com.weg.soccer.mapper;

import com.weg.soccer.dto.stadium.StadiumRequestDto;
import com.weg.soccer.dto.stadium.StadiumResponseDto;
import com.weg.soccer.model.Stadium;
import org.springframework.stereotype.Component;

@Component
public class StadiumMapper {

    public Stadium toEntity(StadiumRequestDto dto) {
        return new Stadium(
                null,
                dto.name(),
                dto.capacity(),
                dto.city(),
                dto.state(),
                dto.turfType(),
                dto.inaugurationDate()
        );
    }

    public StadiumResponseDto toResponse(Stadium stadium) {
        return new StadiumResponseDto(
                stadium.getId(),
                stadium.getName(),
                stadium.getCapacity(),
                stadium.getCity(),
                stadium.getState(),
                stadium.getTurfType(),
                stadium.getInaugurationDate()
        );
    }
}

    package com.weg.soccer.mapper;

    import com.weg.soccer.dto.club.ClubRequestDto;
    import com.weg.soccer.dto.club.ClubResponseDto;
    import com.weg.soccer.model.Club;
    import org.springframework.stereotype.Component;

    @Component
    public class ClubMapper {

        public Club toEntity(
                ClubRequestDto clubRequestDto
        ){
            return new Club(
                    null,
                    clubRequestDto.name(),
                    clubRequestDto.acronym(),
                    clubRequestDto.foundationDate(),
                    clubRequestDto.city(),
                    clubRequestDto.division()
            );
        }

        public ClubResponseDto toResponse(
                Club club
        ){
            return new ClubResponseDto(
                    club.getId(),
                    club.getName(),
                    club.getAcronym(),
                    club.getFoundationDate(),
                    club.getCity(),
                    club.getDivision()
            );
        }

    }

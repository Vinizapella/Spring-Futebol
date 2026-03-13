package com.weg.soccer.mapper;

import com.weg.soccer.dto.transfer.TransferRequestDto;
import com.weg.soccer.dto.transfer.TransferResponseDto;
import com.weg.soccer.model.Transfer;

public class TransferMapper {

    public Transfer toEntity(TransferRequestDto dto) {
        return new Transfer(
                null,
                dto.playerName(),
                dto.clubOrigin(),
                dto.clubDestination(),
                dto.valueRate(),
                dto.dateTransference(),
                dto.international()
        );
    }

    public TransferResponseDto toResponse(Transfer transfer) {
        return new TransferResponseDto(
                transfer.getId(),
                transfer.getPlayerName(),
                transfer.getClubOrigin(),
                transfer.getClubDestination(),
                transfer.getValueRate(),
                transfer.getDateTransference(),
                transfer.getInternational()
        );
    }
}

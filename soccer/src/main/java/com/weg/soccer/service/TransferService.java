package com.weg.soccer.service;

import com.weg.soccer.dto.transfer.TransferRequestDto;
import com.weg.soccer.dto.transfer.TransferResponseDto;
import com.weg.soccer.mapper.TransferMapper;
import com.weg.soccer.model.Transfer;
import com.weg.soccer.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper;

    public TransferService(
            TransferRepository transferRepository,
            TransferMapper transferMapper
    ){
        this.transferRepository = transferRepository;
        this.transferMapper = transferMapper;
    }

    public TransferResponseDto saveTransfer(
            TransferRequestDto transferRequestDto
    ){
        Transfer transfer = transferMapper.toEntity(transferRequestDto);
        Transfer transferSave = transferRepository.save(transfer);
        return transferMapper.toResponse(transferSave);
    }

    public List<TransferResponseDto> listTransfer(){
        List<Transfer> transfers = transferRepository.findAll();

        return transfers.stream()
                .map(transferMapper::toResponse)
                .toList();
    }

    public TransferResponseDto searchOne(
            Integer id
    ){
        return transferRepository.findById(id)
                .map(transferMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Transfer not found"));
    }

    public TransferResponseDto updateTransfer(
            TransferRequestDto transferRequestDto,
            Integer id
    ){
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transfer not found"));

        transfer.setPlayerName(transferRequestDto.playerName());
        transfer.setClubOrigin(transferRequestDto.clubOrigin());
        transfer.setClubDestination(transferRequestDto.clubDestination());
        transfer.setValueRate(transferRequestDto.valueRate());
        transfer.setDateTransference(transferRequestDto.dateTransference());
        transfer.setInternational(transferRequestDto.international());

        Transfer transferUpdate = transferRepository.save(transfer);
        return transferMapper.toResponse(transferUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!transferRepository.existsById(id)){
            throw new RuntimeException("Transfer not found");
        }
        transferRepository.deleteById(id);
    }
}

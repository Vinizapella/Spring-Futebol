package com.weg.soccer.controller;

import com.weg.soccer.dto.transfer.TransferRequestDto;
import com.weg.soccer.dto.transfer.TransferResponseDto;
import com.weg.soccer.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
    @PostMapping
    public TransferResponseDto saveTransfer(
            @Valid @RequestBody TransferRequestDto transferRequestDto
    ) {
        return transferService.saveTransfer(transferRequestDto);
    }
    @GetMapping
    public List<TransferResponseDto> listTransfer() {
        return transferService.listTransfer();
    }
    @GetMapping("/{id}")
    public TransferResponseDto searchOne(
            @PathVariable Integer id
    ) {
        return transferService.searchOne(id);
    }
    @PutMapping("/{id}")
    public TransferResponseDto updateTransfer(
            @Valid @RequestBody TransferRequestDto transferRequestDto,
            @PathVariable Integer id
    ) {
        return transferService.updateTransfer(transferRequestDto, id);
    }
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ) {
        transferService.delete(id);
    }
}

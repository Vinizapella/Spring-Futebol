package com.weg.soccer.dto.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record TransferRequestDto(
        @NotBlank(message = "Player name is mandatory")
        String playerName,

        @NotBlank(message = "Origin club is mandatory")
        String clubOrigin,

        @NotBlank(message = "Destination club is mandatory")
        String clubDestination,

        @NotNull(message = "Transfer value is mandatory")
        @Positive(message = "The value must be greater than zero")
        Double valueRate,

        @NotNull(message = "Transfer date is mandatory")
        @PastOrPresent(message = "Transfer date cannot be in the future")
        LocalDate dateTransference,

        @NotNull(message = "International status is mandatory")
        Boolean international
) {}


package com.weg.soccer.dto.stadium;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StadiumRequestDto(
        @NotBlank(message = "Stadium name is mandatory")
        @Size(min = 3, max = 100)
        String name,

        @NotNull(message = "Capacity is mandatory")
        @Min(value = 1, message = "Capacity must be greater than 0")
        Integer capacity
) {}


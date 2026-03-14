package com.weg.soccer.dto.stadium;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record StadiumRequestDto(
        @NotBlank(message = "Stadium name is mandatory")
        @Size(min = 3, max = 100)
        String name,

        @NotNull(message = "Capacity is mandatory")
        @Min(value = 1, message = "Capacity must be greater than 0")
        Integer capacity,

        @NotBlank(message = "City is mandatory")
        String city,

        @NotBlank(message = "State is mandatory")
        @Size(min = 2, max = 2)
        String state,

        @NotBlank(message = "Turf type is mandatory")
        String turfType,

        @NotNull(message = "Inauguration date is mandatory")
        LocalDate inaugurationDate
) {}

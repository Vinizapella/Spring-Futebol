package com.weg.soccer.dto.club;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ClubRequestDto(

        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 80, message = "The minimum number of characters is 2 and the maximum is 80")
        String name,
        @Size(min = 1, max = 5, message = "The minimum number of characters is 1 and the maximum is 5")
        @NotBlank(message = "Acronym is mandatory")
        String acronym,
        @NotNull(message = "Foundation date is mandatory")
        @PastOrPresent(message = "Foundation date cannot be in the future")
        LocalDate foundationDate,
        @NotBlank(message = "City is mandatory")
        @Size(min = 3, max = 80, message = "The minimum number of characters is 3 and the maximum is 80")
        String city,
        @NotBlank(message = "Division is mandatory")
        @Size(min = 6, max = 7, message = "The formatting is Serie A the name 'series' with a space and the division number")
        String division
) {
}

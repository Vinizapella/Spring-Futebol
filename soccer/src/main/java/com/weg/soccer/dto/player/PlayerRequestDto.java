package com.weg.soccer.dto.player;

import jakarta.validation.constraints.*;

public record PlayerRequestDto(
        @NotBlank(message = "Name is mandatory")
        @Size(min = 3, max = 80, message = "The minimum number of characters is 3 and the maximum is 80")
        String name,
        @NotNull(message = "Age is mandatory")
        @Max(value = 60, message = "A player can play until they are 60 years old at the latest")
        @Min(value = 14, message = "A player must be at least 14 years old")
        Integer old,
        @NotBlank(message = "Position is mandatory")
        String position,
        @NotNull(message = "Market value is mandatory")
        @Positive(message = "Market value must be positive")
        Double market_value,
        @NotNull(message = "Shirt is mandatory")
        @Positive(message = "The value must be greater than 0")
        Integer shirt
) {

}

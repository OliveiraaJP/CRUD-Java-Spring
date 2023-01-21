package com.carsapi.api.dto;

import java.util.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record CarDTO(
        
        @NotBlank
        String modelo,

        @NotBlank
        String fabricante,

        @Past
        Date dataFabricacao,

        @NotNull
        @DecimalMin("0.0")
        Double valor,

        @NotBlank
        String anoModelo) {

}

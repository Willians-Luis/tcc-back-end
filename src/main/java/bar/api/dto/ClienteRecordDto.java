package bar.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ClienteRecordDto(
        @NotBlank String nome,
        String telefone,
        LocalDate dataRegistro
) {}

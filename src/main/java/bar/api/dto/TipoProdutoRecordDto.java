package bar.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoProdutoRecordDto(
        @NotBlank String nome
) {}

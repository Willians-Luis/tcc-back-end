package bar.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DespesasRecordDto(
        @NotNull Double valor,
        @Min(1) @Max(12) @NotNull Integer mes,
        @Min(2000) @NotNull Integer ano
) {
}

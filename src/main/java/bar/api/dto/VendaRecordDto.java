package bar.api.dto;

import bar.api.model.VendaFk;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VendaRecordDto(
        @Valid @NotNull VendaFk pk,
        @NotNull Integer quantidade,
        Boolean status
) {}

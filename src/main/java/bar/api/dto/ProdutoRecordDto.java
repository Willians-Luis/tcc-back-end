package bar.api.dto;

import bar.api.model.TipoProduto;
import bar.api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDto(
        @NotBlank String nome,
        @NotNull TipoProduto tipo,
        @NotNull Integer quantidade,
        @NotNull Double valorCusto,
        @NotNull Double valorVenda,
        String textColor,
        String backgroundColor,
        String descricao
) {}

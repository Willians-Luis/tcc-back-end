package bar.api.repository;

import bar.api.model.Produto;
import bar.api.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Boolean existsByNomeAndTipo(String nome, TipoProduto tipo);
}

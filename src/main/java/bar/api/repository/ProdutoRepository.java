package bar.api.repository;

import bar.api.model.Produto;
import bar.api.model.TipoProduto;
import bar.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Boolean existsByNomeAndTipo(String nome, TipoProduto tipo);

    List<Produto> findByUser(User user);
}

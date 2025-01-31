package bar.api.repository;

import bar.api.model.TipoProduto;
import bar.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {
    Boolean existsByNome(String nome);

    List<TipoProduto> findByUser(User user);
}

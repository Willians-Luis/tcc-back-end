package bar.api.repository;

import bar.api.model.Despesas;
import bar.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {
    List<Despesas> findByUser(User user);
}

package bar.api.repository;

import bar.api.model.Cliente;
import bar.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Boolean existsByNome(String nome);

    List<Cliente> findByUser(User user);
}

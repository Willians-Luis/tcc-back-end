package bar.api.repository;

import bar.api.model.Cliente;
import bar.api.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByFkCliente(Cliente cliente);
    List<Venda> findByFkClienteAndStatus(Cliente cliente, boolean status);
}

package bar.api.service;

import bar.api.model.Cliente;
import bar.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;;
    public List<Cliente> getAll() {
        return repository.findAll();
    }
    @Transactional //se ouver erros, mantem os dados a salvo, de antes do erro.
    public Cliente gravar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> getId(Integer id) {
        return repository.findById(id);
    }
    @Transactional
    public void deletar(Optional<Cliente> cliente) {
        repository.delete(cliente.get());
    }
    public Boolean existsNome(String nome) {
        return repository.existsByNome(nome);
    }
}

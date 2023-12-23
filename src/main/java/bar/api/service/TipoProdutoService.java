package bar.api.service;

import bar.api.model.TipoProduto;
import bar.api.repository.TipoProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProdutoService {
    @Autowired
    private TipoProdutoRepository repository;;
    public List<TipoProduto> getAll() {
        return repository.findAll();
    }
    @Transactional
    public TipoProduto gravar(TipoProduto tipo) {
        return repository.save(tipo);
    }

    public Optional<TipoProduto> getId(Integer id) {
        return repository.findById(id);
    }
    @Transactional
    public void deletar(Optional<TipoProduto> tipo) {
        repository.delete(tipo.get());
    }

    public Boolean existsNome(String nome) {
        return repository.existsByNome(nome);
    }
}

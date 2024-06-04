package bar.api.service;

import bar.api.model.Produto;
import bar.api.model.User;
import bar.api.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findProdutoByUser(User user) {
        return repository.findByUser(user);
    }

    @Transactional
    public Produto gravar(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> getId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void deletar(Optional<Produto> produto) {
        repository.delete(produto.get());
    }

    public Boolean existsProduto(Produto p) {
        return repository.existsByNomeAndTipo(p.getNome(), p.getTipo());
    }
}

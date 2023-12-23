package bar.api.service;

import bar.api.model.Cliente;
import bar.api.model.Produto;
import bar.api.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidacaoService {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendaService vendaService;

    public Object validarProduto(Integer id) {
        Optional<Produto> p = produtoService.getId(id);
        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return p;
    }

    public Object validarCliente(Integer id) {
        Optional<Cliente> c = clienteService.getId(id);
        if (c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return c;
    }

    public Object validarVenda(Integer id) {
        Optional<Venda> v = vendaService.getId(id);
        if (v.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada!");
        }
        return v;
    }
}

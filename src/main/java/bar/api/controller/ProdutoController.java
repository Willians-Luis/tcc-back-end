package bar.api.controller;

import bar.api.dto.ProdutoRecordDto;
import bar.api.model.Produto;
import bar.api.model.TipoProduto;
import bar.api.repository.UserRepository;
import bar.api.service.ProdutoService;
import bar.api.service.TipoProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @Autowired
    private TipoProdutoService tipoProdutoService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos(JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findProdutoByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable(value = "id") Long id) {

        Optional<Produto> p = service.getId(id);

        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid ProdutoRecordDto produtoRecordDto, JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        var newProduto = new Produto();
        BeanUtils.copyProperties(produtoRecordDto, newProduto);
        Optional<TipoProduto> tipo = tipoProdutoService.getId(newProduto.getTipo().getId());
        if (tipo.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do produto não encontrado!");}

        newProduto.setTipo(tipo.get());
        newProduto.setUser(user.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newProduto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        Optional<Produto> p = service.getId(id);

        if (p.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");}

        Optional<TipoProduto> tipo = tipoProdutoService.getId(produtoRecordDto.tipo().getId());

        if (tipo.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do produto não encontrado!");}

        Produto newProduto = p.get();
        newProduto.setNome(produtoRecordDto.nome());
        newProduto.setTipo(tipo.get());
        newProduto.setQuantidade(produtoRecordDto.quantidade());
        newProduto.setValorCusto(produtoRecordDto.valorCusto());
        newProduto.setValorVenda(produtoRecordDto.valorVenda());
        newProduto.setTextColor(produtoRecordDto.textColor());
        newProduto.setBackgroundColor(produtoRecordDto.backgroundColor());
        newProduto.setBorderColor(produtoRecordDto.borderColor());
        newProduto.setDescricao(produtoRecordDto.descricao());

        if (!p.get().getNome().equalsIgnoreCase(produtoRecordDto.nome())) {
            if (service.existsProduto(newProduto)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto repetido!");
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id) {

        Optional<Produto> p = service.getId(id);

        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        service.deletar(p);

        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso!");
    }
}

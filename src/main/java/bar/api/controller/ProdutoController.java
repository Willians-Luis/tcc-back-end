package bar.api.controller;

import bar.api.dto.ProdutoRecordDto;
import bar.api.model.Produto;
import bar.api.model.TipoProduto;
import bar.api.service.ProdutoService;
import bar.api.service.TipoProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable(value = "id") Integer id) {
        Optional<Produto> p = service.getId(id);
        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
        var produtoModel = new Produto();
        BeanUtils.copyProperties(produtoRecordDto, produtoModel);
        Optional<TipoProduto> tipo = tipoProdutoService.getId(produtoModel.getTipo().getId());
        if (tipo.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do produto não encontrado!");}
        produtoModel.setTipo(tipo.get());
        if (service.existsProduto(produtoModel)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto repetido!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(produtoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id, @RequestBody @Valid ProdutoRecordDto produtoRecordDto) {
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
        newProduto.setDescricao(produtoRecordDto.descricao());
        if (!p.get().getNome().equalsIgnoreCase(produtoRecordDto.nome())) {
            if (service.existsProduto(newProduto)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto repetido!");
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Integer id) {
        Optional<Produto> p = service.getId(id);
        if (p.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        service.deletar(p);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso!");
    }
}

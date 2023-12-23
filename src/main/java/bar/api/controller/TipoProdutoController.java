package bar.api.controller;

import bar.api.dto.TipoProdutoRecordDto;
import bar.api.model.TipoProduto;
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
@RequestMapping("/tipoProduto")
public class TipoProdutoController {
    @Autowired
    private TipoProdutoService service;

    @GetMapping
    public ResponseEntity<List<TipoProduto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") Integer id) {
        Optional<TipoProduto> t = service.getId(id);
        if (t.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid TipoProdutoRecordDto tipoProdutoRecordDto) {
        if (service.existsNome(tipoProdutoRecordDto.nome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O nome do tipo de produto já existe!");
        }
        var tipoModel = new TipoProduto();
        BeanUtils.copyProperties(tipoProdutoRecordDto, tipoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(tipoModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id, @RequestBody @Valid TipoProdutoRecordDto tipoProdutoRecordDto) {
        Optional<TipoProduto> p = service.getId(id);
        if (p.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");}
        if (!p.get().getNome().equalsIgnoreCase(tipoProdutoRecordDto.nome())) {
            if (service.existsNome(tipoProdutoRecordDto.nome())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("O nome do tipo de produto já existe!");
            }
        }
        TipoProduto newTipo = p.get();
        newTipo.setNome(tipoProdutoRecordDto.nome());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newTipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Integer id) {
        Optional<TipoProduto> t = service.getId(id);
        if (t.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");
        }
        service.deletar(t);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo removido com sucesso!");
    }
}

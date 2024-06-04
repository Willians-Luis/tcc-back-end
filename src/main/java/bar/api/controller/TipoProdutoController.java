package bar.api.controller;

import bar.api.dto.TipoProdutoRecordDto;
import bar.api.model.TipoProduto;
import bar.api.repository.UserRepository;
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
import java.util.UUID;

@RestController
@RequestMapping("/tipoProduto")
public class TipoProdutoController {
    @Autowired
    private TipoProdutoService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<TipoProduto>> getAll(JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findTipoByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") Long id) {

        Optional<TipoProduto> t = service.getId(id);

        if (t.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid TipoProdutoRecordDto tipoProdutoRecordDto, JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        var newTipo = new TipoProduto();

        BeanUtils.copyProperties(tipoProdutoRecordDto, newTipo);

        newTipo.setUser(user.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newTipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody @Valid TipoProdutoRecordDto tipoProdutoRecordDto) {

        Optional<TipoProduto> p = service.getId(id);

        if (p.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");}


        TipoProduto newTipo = p.get();
        newTipo.setNome(tipoProdutoRecordDto.nome());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newTipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id) {

        Optional<TipoProduto> t = service.getId(id);

        if (t.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não encontrado!");
        }

        service.deletar(t);

        return ResponseEntity.status(HttpStatus.OK).body("Tipo removido com sucesso!");
    }
}

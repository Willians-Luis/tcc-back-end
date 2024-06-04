package bar.api.controller;

import bar.api.dto.DespesasRecordDto;
import bar.api.model.Despesas;
import bar.api.repository.UserRepository;
import bar.api.service.DespesasService;
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
@RequestMapping("/despesas")
public class DespesasController {
    @Autowired
    private DespesasService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Despesas>> buscarDespesas(JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findDespesasByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarDespesas(@PathVariable(value = "id") Long id) {

        Optional<Despesas> d = service.getId(id);

        if (d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesas não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(d);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid DespesasRecordDto despesasRecordDto, JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        var newDespesa = new Despesas();

        BeanUtils.copyProperties(despesasRecordDto, newDespesa);

        newDespesa.setUser(user.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newDespesa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody @Valid DespesasRecordDto despesasRecordDto) {

        Optional<Despesas> d = service.getId(id);

        if (d.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesas não encontrado!");}

        Despesas newDespesa = d.get();
        newDespesa.setValor(despesasRecordDto.valor());
        newDespesa.setAno(despesasRecordDto.ano());
        newDespesa.setMes(despesasRecordDto.mes());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newDespesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id) {

        Optional<Despesas> d = service.getId(id);

        if (d.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Despesa não encontrado!");
        }

        service.deletar(d);

        return ResponseEntity.status(HttpStatus.OK).body("Despesa removida com sucesso!");
    }
}

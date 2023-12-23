package bar.api.controller;

import bar.api.dto.ClienteRecordDto;
import bar.api.model.Cliente;
import bar.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCliente(@PathVariable(value = "id") Integer id) {
        Optional<Cliente> c = service.getId(id);
        if (c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        if (service.existsNome(clienteRecordDto.nome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O nome " + clienteRecordDto.nome() + " ja esta sendo utilizado!");
        }
        var clienteModel = new Cliente();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        if (clienteModel.getDataRegistro() == null) {clienteModel.setDataRegistro(LocalDate.now());}
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(clienteModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id, @RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        Optional<Cliente> c = service.getId(id);
        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}
        if (!c.get().getNome().equalsIgnoreCase(clienteRecordDto.nome())) {
            if (service.existsNome(clienteRecordDto.nome())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("O nome " + clienteRecordDto.nome() + " ja esta sendo utilizado!");
            }
        }
        Cliente newCliente = c.get();
        newCliente.setNome(clienteRecordDto.nome());
        newCliente.setTelefone(clienteRecordDto.telefone());
        newCliente.setDataRegistro(clienteRecordDto.dataRegistro());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Integer id) {
        Optional<Cliente> cliente = service.getId(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        service.deletar(cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso!");
    }
}

package bar.api.controller;

import bar.api.dto.ClienteRecordDto;
import bar.api.model.Cliente;
import bar.api.repository.UserRepository;
import bar.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarClientes(JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findClienteByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCliente(@PathVariable(value = "id") Long id) {

        Optional<Cliente> c = service.getId(id);

        if (c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid ClienteRecordDto clienteRecordDto, JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        var newCliente = new Cliente();

        BeanUtils.copyProperties(clienteRecordDto, newCliente);

        newCliente.setUser(user.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newCliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id, @RequestBody @Valid ClienteRecordDto clienteRecordDto) {

        Optional<Cliente> c = service.getId(id);

        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}

        Cliente newCliente = c.get();
        newCliente.setNome(clienteRecordDto.nome());
        newCliente.setTelefone(clienteRecordDto.telefone());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id) {

        Optional<Cliente> cliente = service.getId(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        service.deletar(cliente);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso!");
    }
}

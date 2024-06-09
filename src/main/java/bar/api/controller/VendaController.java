package bar.api.controller;

import bar.api.dto.VendaRecordDto;
import bar.api.model.*;
import bar.api.repository.UserRepository;
import bar.api.service.ClienteService;
import bar.api.service.ProdutoService;
import bar.api.service.VendaService;
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

@RestController
@RequestMapping("/venda")
public class VendaController {
    @Autowired
    private VendaService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Venda>> buscarVendas(JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findVendaByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarVenda(@PathVariable(value = "id") Long id) {

        Optional<Venda> v = service.getId(id);

        if (v.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada!");}

        return ResponseEntity.status(HttpStatus.OK).body(v);
    }

    @GetMapping("/date/{ano}/{mes}")
    public ResponseEntity<List<Venda>> buscarVendasByDate(@PathVariable(value = "ano") Integer ano,
                                                               @PathVariable(value = "mes") Integer mes,
                                                               JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        return ResponseEntity.status(HttpStatus.OK).body(service.findByUserAndAnoPagamentoAndMesPagamento(user.get(), ano, mes));
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody @Valid VendaRecordDto vendaRecordDto, JwtAuthenticationToken token) {

        //var user = userRepository.findById(UUID.fromString(token.getName()));
        var user = userRepository.findById(Long.parseLong(token.getName()));

        Optional<Produto> p = produtoService.getId(vendaRecordDto.pk().getProduto().getId());
        Optional<Cliente> c = clienteService.getId(vendaRecordDto.pk().getCliente().getId());
        if (p.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");}
        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}

        var newVenda = new Venda();
        BeanUtils.copyProperties(vendaRecordDto, newVenda);

        VendaFk pk = new VendaFk();
        pk.setProduto(p.get());
        pk.setCliente(c.get());

        newVenda.setFk(pk);
        newVenda.setStatus(true);
        newVenda.setUser(user.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newVenda));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
//                                            @RequestBody @Valid VendaRecordDto vendaRecordDto) {
//        Optional<Venda> v = service.getId(id);
//        Optional<Produto> p = produtoService.getId(vendaRecordDto.pk().getProduto().getId());
//        Optional<Cliente> c = clienteService.getId(vendaRecordDto.pk().getCliente().getId());
//        if (v.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada!");}
//        if (p.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");}
//        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}
//
//        VendaFk pk = new VendaFk();
//        pk.setProduto(p.get());
//        pk.setCliente(c.get());
//
//        Venda newVenda = v.get();
//        newVenda.setFk(pk);
//        newVenda.setQuantidade(vendaRecordDto.quantidade());
//        newVenda.setStatus(vendaRecordDto.status());
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newVenda));
//    }

    @PutMapping("pagar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id) {
        Optional<Venda> v = service.getId(id);

        if (v.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada!");}

        LocalDate dataAtual = LocalDate.now();

        Venda newVenda = v.get();
        newVenda.setStatus(false);
        newVenda.setAnoPagamento(dataAtual.getYear());
        newVenda.setMesPagamento(dataAtual.getMonthValue());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.gravar(newVenda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id) {

        Optional<Venda> v = service.getId(id);

        if (v.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Venda não encontrada!");}

        service.deletar(v);

        return ResponseEntity.status(HttpStatus.OK).body("Venda removida com sucesso!");
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> buscarVendaClinente(@PathVariable(value = "id") Long id) {

        Optional<Cliente> c = clienteService.getId(id);

        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}

        List<Venda> vendas = service.findByCliente(c.get());

        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

    @GetMapping("/cliente/{id}/{status}")
    public ResponseEntity<Object> buscarVendaClinenteStatus(@PathVariable(value = "id") Long id,
                                                            @PathVariable(value = "status") Boolean status) {
        Optional<Cliente> c = clienteService.getId(id);
        if (c.isEmpty()) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");}

        List<Venda> vendas = service.findByClienteAndStatus(c.get(), status);

        return ResponseEntity.status(HttpStatus.OK).body(vendas);
    }

    @PutMapping("/pagarVarios/{clienteId}")
    public ResponseEntity<Object> pagamento(@PathVariable(value = "clienteId") Long clienteId) {

        Optional<Cliente> clienteOptional = clienteService.getId(clienteId);

        if (clienteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        Cliente cliente = clienteOptional.get();

        List<Venda> vendas = service.findByClienteAndStatus(cliente, true);

        if (vendas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não à debitos pendentes!");
        }

        LocalDate dataAtual = LocalDate.now();

        for (Venda venda : vendas) {
            venda.setStatus(false);
            venda.setAnoPagamento(dataAtual.getYear());
            venda.setMesPagamento(dataAtual.getMonthValue());
            service.gravar(venda);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Pagamento realizado com sucesso!");
    }
}

//    @PutMapping("/pagarVarios/{clienteId}/{valor}/{desconto}")
//    public ResponseEntity<Object> pagamento(
//            @PathVariable(value = "clienteId") Long clienteId,
//            @PathVariable(value = "valor") Double valor,
//            @PathVariable(value = "desconto") Double desconto
//    ) {
//
//        Optional<Cliente> clienteOptional = clienteService.getId(clienteId);
//
//        if (clienteOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
//        }
//
//        Cliente cliente = clienteOptional.get();
//
//        List<Venda> vendas = service.findByClienteAndStatus(cliente, true);
//
//        if (vendas.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.OK).body("Não à debitos pendentes!");
//        }
//
//        for (Venda venda : vendas) {
//            Double subtotal = (venda.getFk().getProduto().getValorVenda() * venda.getQuantidade()) - venda.getPagamentoParcial();
//            Double valorTotal = valor + desconto;
//            if (valorTotal >= subtotal) {
//                pagamentoService.realizarPagamentoIntegral(venda);
//                valorTotal -= subtotal;
//            } else {
//                pagamentoService.realizarPagamentoParcial(venda, valorTotal);
//                return ResponseEntity.status(HttpStatus.OK).body("Pagamento parcial realizado com sucesso!");
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body("Pagamento total realizado com sucesso!");
//    }


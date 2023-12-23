package bar.api.service;

import bar.api.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PagamentoService {
    @Autowired
    private VendaService vendaService;

    public void realizarPagamentoIntegral(Venda venda) {
        venda.setStatus(false);
        venda.setDataPagamento(LocalDate.now());
        venda.setPagamentoParcial(0.0);
        venda.setAviso("Pago!");
        vendaService.gravar(venda);
    }

    public void realizarPagamentoParcial(Venda venda, Double valorParcial) {
        venda.setPagamentoParcial(valorParcial);
        venda.setAviso("Pago parcialmente!");
        venda.setDataPagamento(LocalDate.now());
        vendaService.gravar(venda);
    }
}

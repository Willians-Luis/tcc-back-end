package bar.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Embeddable
public class VendaFk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"vendas"})
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    @NotNull
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"vendas"})
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    @NotNull
    private Cliente cliente;

    public VendaFk() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

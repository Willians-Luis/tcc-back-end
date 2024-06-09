package bar.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private VendaFk fk;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"userId", "password", "email", "registrationDate", "roles"})
    private User user;

    private Integer quantidade;

    @CreationTimestamp
    private Instant dataVenda;

    private Integer anoPagamento;

    private Integer mesPagamento;

    private Boolean status;


    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendaFk getFk() {
        return fk;
    }

    public void setFk(VendaFk fk) {
        this.fk = fk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getAnoPagamento() {
        return anoPagamento;
    }

    public void setAnoPagamento(Integer anoPagamento) {
        this.anoPagamento = anoPagamento;
    }

    public Integer getMesPagamento() {
        return mesPagamento;
    }

    public void setMesPagamento(Integer mesPagamento) {
        this.mesPagamento = mesPagamento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

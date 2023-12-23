package bar.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private VendaFk fk;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "dataVenda", nullable = false)
    private LocalDate dataVenda;
    @Column(name = "dataPagamento", nullable = true)
    private LocalDate dataPagamento;
    @Column(name = "status", nullable = true)
    private Boolean status;
    @Column(name = "aviso", nullable = true)
    private String aviso;
    @Column(name = "pagamentoParcial", nullable = true)
    private Double pagamentoParcial;

    public Venda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VendaFk getFk() {
        return fk;
    }

    public void setFk(VendaFk fk) {
        this.fk = fk;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public Double getPagamentoParcial() {
        return pagamentoParcial;
    }

    public void setPagamentoParcial(Double pagamentoParcial) {
        this.pagamentoParcial = pagamentoParcial;
    }
}

package com.jjsolution.app.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Acordo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private int id;
    @Column(name = "qtd_parcelas") private int qtdParcelas;
    @Column(name = "data_vencimento") private Date dataVencimento;
    @Column(name = "valor_acordado") private double valorAcordado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_divida") private Divida divida;

    public int getId() {
        return id;
    }

    public void setIdAcordo(int id) {
        this.id = id;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValorAcordado() {
        return valorAcordado;
    }

    public void setValorAcordado(double valorAcordado) {
        this.valorAcordado = valorAcordado;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }
}

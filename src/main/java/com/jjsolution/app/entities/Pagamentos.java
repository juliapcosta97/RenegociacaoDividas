package com.jjsolution.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private int id;
    @Column(name = "valor") private double valor;
    @Column(name = "data_pagamento") private Date dataPagamento;
    @Column(name = "tipo_pagamento") private String tipoPagamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_acordo") private Acordo acordo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Acordo getAcordo() {
        return acordo;
    }

    public void setAcordo(Acordo acordo) {
        this.acordo = acordo;
    }
}

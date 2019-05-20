package com.jjsolution.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private int id;

    @Column(name = "valor") private double valor;
    @Column(name = "descricao") private String descricao;
    @Column(name = "data_vencimento") private Date dataVencimento;
    @Column(name = "tipo_divida") private String tipoDivida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente") private Cliente cliente;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getTipoDivida() {
        return tipoDivida;
    }

    public void setTipoDivida(String tipoDivida) {
        this.tipoDivida = tipoDivida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

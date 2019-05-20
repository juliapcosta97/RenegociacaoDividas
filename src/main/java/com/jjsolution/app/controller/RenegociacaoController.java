package com.jjsolution.app.controller;

import com.jjsolution.app.entities.Acordo;
import com.jjsolution.app.entities.Divida;
import com.jjsolution.app.model.AcordoDAO;
import com.jjsolution.app.model.DividaDAO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RenegociacaoController {

    private DividaDAO dividaDAO;
    private AcordoDAO acordoDAO;

    public RenegociacaoController(){
       new DividaDAO();
       new AcordoDAO();
    }

    @GetMapping("/dividas")
    public List<Divida> buscaDividas() {
        return this.dividaDAO.getDivida();
    }

    @GetMapping("/simula-pagamentos")
    public String simulaPagamentos(int qtdParcelas, double valorParcela) {

        List<Divida> totalDividas = this.dividaDAO.getDivida();
        double valorTotal = 0;
        String valorSimulacao;

        for (Divida d: totalDividas)
            valorTotal = valorTotal + d.getValor();

        double valorEscolhido = qtdParcelas * valorParcela;

        if(valorEscolhido < valorTotal) {
            valorSimulacao = "Você pagará " + qtdParcelas + " de " + valorParcela + " = " + valorEscolhido +
                     " e " + "faltará " + (valorTotal = valorEscolhido) + "para ser pago.";
        }else{
            valorSimulacao = "Você pagará " + qtdParcelas + " de " + valorParcela + " = " + valorEscolhido;
        }

        return valorSimulacao;
    }

    @PostMapping("/efetiva-acordo")
    public void efetivaAcordo(Acordo acordo, String token) {
        this.acordoDAO.save(acordo);
        this.imprimiAcordo(acordo);
    }

    public void imprimiAcordo(Acordo acordo){

    }
}

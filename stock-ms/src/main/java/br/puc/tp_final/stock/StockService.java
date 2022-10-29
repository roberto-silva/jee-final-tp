package br.puc.tp_final.stock;

import jakarta.ejb.Stateless;

import java.util.Random;

@Stateless
public class StockService {


    public void write_off() {
    }

    public String status() {
        return "TODO";
    }

    public boolean SimulaProbabilidadeBaixaEstoque(){
        Random random = new Random();
        int probabilidade = random.nextInt(100);
        return probabilidade < 95;
    }
}
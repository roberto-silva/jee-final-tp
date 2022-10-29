package br.puc.tp_final.stock;

import jakarta.ejb.Stateless;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.http.HTTPException;

import java.util.Random;

@Stateless
public class StockService {


    public void write_off(int id)
    {
        boolean itemBaixadoComSucesso = simulaProbabilidadeBaixaEstoque();

        if(!itemBaixadoComSucesso)
        {
            throw new HTTPException(Response.Status.CONFLICT.getStatusCode());
        }
    }

    public String status() {
        return "TODO";
    }

    public boolean simulaProbabilidadeBaixaEstoque(){
        Random random = new Random();
        int probabilidade = random.nextInt(100);
        return probabilidade < 95;
    }


}
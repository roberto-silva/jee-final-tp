package br.puc.tp_final.stock;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.http.HTTPException;

//http://localhost:8080/stock-ms/rest/stock/status/1

@Path("stock")
@Produces({"application/json"})
public class StockController {

    @EJB
    private StockService stockService;


    @POST
    @Path("/write-off/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response downStock()
    {
        try
        {
            stockService.write_off(1);
            return  Response.status(Response.Status.OK).build();
        }
        catch (HTTPException e)
        {
            //todo: add log para monitoramento
            throw e;
        }
    }




    @GET
    @Path("/status/{id}")
    @Consumes("application/json")
    public String status()
    {
        return stockService.status();
    }


    @GET
    @Path("/teste-probabilidade-baixa-estoque")
    @Consumes("application/json")
    public boolean TestePedidoAceito() {
        return stockService.simulaProbabilidadeBaixaEstoque();
    }
}
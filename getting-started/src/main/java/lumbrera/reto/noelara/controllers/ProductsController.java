package lumbrera.reto.noelara.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import lumbrera.reto.noelara.dtos.ProductsDTO;
import lumbrera.reto.noelara.models.Products;
import lumbrera.reto.noelara.services.ProductService;
import lumbrera.reto.noelara.services.VariationService;

@Path("/products")
public class ProductsController {

    @Inject
    ProductService productService;

    @Inject
    VariationService variationService;

    Gson gson = new Gson();

    /*
     * Method to add or update products products
     *
     * @param product the product to be added
     *
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add}")
    public void addProduct(@QueryParam("products") final String products) {

        ProductsDTO productsdto = new ProductsDTO();
        productsdto = gson.fromJson(products, ProductsDTO.class);

        productService.add(productsdto);
    }

    /*
     * Method to delete one product
     *
     * @param id the id of the product
     *
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add}")
    public void deleteProduct(@QueryParam("product") final String product) {

        Products products = new Products();
        products = gson.fromJson(product, Products.class);
        productService.delete(products);

    }
}

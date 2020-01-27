package lumbrera.reto.noelara.controllers;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lumbrera.reto.noelara.commons.InputStreamToStringParser;
import lumbrera.reto.noelara.dtos.ProductsInDTO;
import lumbrera.reto.noelara.dtos.ProductsOutDTO;
import lumbrera.reto.noelara.models.Products;
import lumbrera.reto.noelara.models.Variations;
import lumbrera.reto.noelara.services.ProductService;
import lumbrera.reto.noelara.services.VariationService;

@Path("/products")
public class ProductsController {

    @Inject
    ProductService productService;

    @Inject
    VariationService variationService;

    // Parser for InputStream to String format
    @Inject
    InputStreamToStringParser inputStreamToStringParser;

    // gson to handle json Strings
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    String error = "";

    StringWriter sw = new StringWriter();

    /*
     * Method to add product
     *
     * @param inputStream inputStream with the product's data
     *
     * @return resDTO a ProductsOutDTO object with products and variations added
     * to db
     *
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String addProduct(final InputStream inputStream) {

        LOGGER.info(inputStream);

        // getting companies object from parsing input stream from POST request
        // from post request parsed object
        final ProductsInDTO productsInDTO = gson.fromJson(inputStreamToStringParser.inputStreamToString(inputStream), ProductsInDTO.class);

        final ProductsOutDTO resDTO = new ProductsOutDTO();

        Products p = new Products();

        // creating new Products object
        final Products products = new Products();

        products.setCompanies(productsInDTO.getCompanies());
        products.setCost(productsInDTO.getCost());
        if (null != productsInDTO.isHasIva()) {
            products.setHasiva(productsInDTO.isHasIva());
        }
        products.setName(productsInDTO.getName());
        products.setPrice(productsInDTO.getPrice());
        products.setStock(productsInDTO.getStock());

        // validating product
        if (isProductValid(products)) {

            try {
                // adding a product to db and returning the product just added
                p = productService.add(products);

                resDTO.setProducts(p);

                // getting a list of variations from post request parsed object
                final List<Variations> liVariations = productsInDTO.getVariations();

                final List<Variations> liVarAux = new ArrayList<>();

                if (null != p && liVariations != null && liVariations.size() > 0) {

                    // adding products related to variations
                    for (int i = 0; i < liVariations.size(); i++) {
                        final Variations vTemp = liVariations.get(i);
                        vTemp.setProducts(p);
                        liVarAux.add(vTemp);
                    }

                    // replacing the list of variations with the ones just added
                    liVariations.clear();
                    liVariations.addAll(liVarAux);

                    // converting to Iterable
                    final Iterable<Variations> itVariations = liVariations;

                    // adding varations to db
                    variationService.addAll(itVariations);

                    // adding the list of variations to resDTO for response
                    resDTO.setVariations(liVariations);

                    // return the object inserted
                    return gson.toJson(resDTO);
                }

                // adding the product just added to db to resDTO for response
                resDTO.setProducts(p);

            } catch (final Exception e) {
                LOGGER.warn(exceptionAsString(e));
                return gson.toJson(e.getLocalizedMessage());
            }
        } else {
            return gson.toJson("The product is not valid, check validation conditions");
        }

        return gson.toJson(error);
    }

    /*
     * Method to delete one product
     *
     * @param id the id of the product
     *
     * @return String with data from the p roduct deleted
     *
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public String deleteProduct(@PathParam("id") final long id) {

        LOGGER.info("id del producto para borrar: " + id);

        try {
            productService.delete(id);
            return gson.toJson("The product with id = " + id + " was succefully deleted");
        } catch (final IllegalArgumentException e) {
            LOGGER.info(e.getMessage() + " : " + e.getStackTrace());
            return gson.toJson(e.getMessage());
        }

    }

    /*
     * Method to update products
     *
     * @param inputStream inputStream with the product's data
     *
     * @return resDTO a ProductsOutDTO object with products and variations
     * updated in db
     *
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public String updateProduct(final InputStream inputStream) {

        LOGGER.info(inputStream);

        // getting companies object from parsing input stream from POST request
        // from post request parsed object
        final ProductsInDTO productsInDTO = gson.fromJson(inputStreamToStringParser.inputStreamToString(inputStream), ProductsInDTO.class);

        LOGGER.info(gson.toJson(productsInDTO));

        // object to be returned when updated
        final ProductsOutDTO resDTO = new ProductsOutDTO();

        Products products = new Products();

        Products p = new Products();

        try {
            // looking for a product by it's id
            products = productService.getProductById(productsInDTO.getIdProduct());
        } catch (final NoSuchElementException | NotFoundException e) {
            LOGGER.warn(exceptionAsString(e));
        } catch (final Exception e) {
            LOGGER.error(exceptionAsString(e));
            return gson.toJson("Ocurrió una excepción con causa: " + e.getMessage());
        }

        // if product's id is valid, the product is tried to be added to db
        if (products != null && isProductValid(products)) {
            if (productsInDTO.getCompanies() != null) {
                products.setCompanies(productsInDTO.getCompanies());
            }
            if (productsInDTO.getCost() > 0) {
                products.setCost(productsInDTO.getCost());
            }
            if (productsInDTO.isHasIva() != null && products.getHasiva() != productsInDTO.isHasIva()) {
                products.setHasiva(productsInDTO.isHasIva());
            }
            if (productsInDTO.getName() != null && !"".equals(productsInDTO.getName())) {
                products.setName(productsInDTO.getName());
            }
            if (productsInDTO.getPrice() > 0) {
                products.setPrice(productsInDTO.getPrice());
            }
            products.setStock(productsInDTO.getStock());

            try {

                // adding a produtc to db
                p = productService.add(products);
                resDTO.setProducts(p);

                // getting a list of variations from post request parsed object
                final List<Variations> liVariations = productsInDTO.getVariations();

                final ArrayList<Variations> liVarAux = new ArrayList<>();

                LOGGER.info("livariations obj");
                LOGGER.info(gson.toJson(liVariations));

                if (null != liVariations && liVariations.size() > 0) {

                    // adding variation object to db each iteration
                    for (int i = 0; i < liVariations.size(); i++) {

                        final Variations varsTemp = liVariations.get(i);
                        try {
                            // looking for a variation by it's id
                            final Variations v = variationService.findVariationById(varsTemp.getId());

                            // replacing variations object for the ones just
                            // obtained and atached to db, for update
                            if (null != varsTemp.getBrand() && !"".equals(varsTemp.getBrand())) {
                                v.setBrand(liVariations.get(i).getBrand());
                            }
                            if (null != varsTemp.getName() && !"".equals(varsTemp.getName())) {
                                v.setName(varsTemp.getName());
                            }
                            if (null != varsTemp.getSku() && !"".equals(varsTemp.getSku())) {
                                v.setSku(varsTemp.getSku());
                            }

                            if (liVariations.get(i).getStock() <= 0) {
                            } else {
                                v.setStock(varsTemp.getStock());
                            }

                            v.setProducts(p);

                            // adding each product to db and to a list for
                            // response
                            liVarAux.add(variationService.add(v));

                        } catch (final NoSuchElementException | NotFoundException e) {
                            LOGGER.warn(exceptionAsString(e));
                            return gson.toJson(e.getMessage());
                        }
                    }

                    // replacing the list of variations with the ones just added
                    liVariations.clear();
                    liVariations.addAll(liVarAux);

                    // adding a list to resDTO object with variations just added
                    // to db, for response
                    resDTO.setVariations(liVariations);

                    // clearing objects
                    liVariations.clear();
                    liVarAux.clear();

                    // return the objects inserted
                    return gson.toJson(resDTO);
                }
                LOGGER.info(gson.toJson(resDTO));
            } catch (final Exception e) {
                LOGGER.error(exceptionAsString(e));
                return gson.toJson(error.concat(e.getMessage()));
            }

        }

        return gson.toJson(error);
    }

    private Object exceptionAsString(final Exception e) {

        e.printStackTrace(new PrintWriter(sw));
        final String exceptionAsString = sw.toString();

        return exceptionAsString;
    }

    /*
     * Method for Products validation
     *
     * @param products the product to be updated
     *
     */
    private boolean isProductValid(final Products products) {

        if (products.getPrice() >= 0 && products.getCost() >= 0 && products.getStock() > 0) {
            if ((products.getPrice() == 0 && products.getCost() == 0) || products.getPrice() > products.getCost()) {
                return true;
            }
        }

        return false;
    }

}

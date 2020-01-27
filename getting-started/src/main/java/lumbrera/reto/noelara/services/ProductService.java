package lumbrera.reto.noelara.services;

import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.jboss.logging.Logger;

import lumbrera.reto.noelara.models.Products;
import lumbrera.reto.noelara.repositories.ProductRepository;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository productsRepository;

    @Inject
    VariationService variationService;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    /*
     * Method to add or update products
     *
     * @param productsDTO the product to be added or updated to the data base
     *
     *
     */
    @Transactional
    public Products add(final Products products) throws Exception {

        return productsRepository.save(products);

    }

    /*
     * Method to delete products
     *
     * @param products the product to be deleted to the data base
     *
     *
     */
    public boolean delete(final long id) throws IllegalArgumentException {

        productsRepository.deleteById(id);

        return false;
    }

    /*
     * Method to find a product bi it's id
     *
     * @param id the id of the product to be found
     *
     */
    public Products getProductById(final long id) throws NotFoundException, NoSuchElementException {

        return productsRepository.findById(id).get();

    }
}

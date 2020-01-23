package lumbrera.reto.noelara.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lumbrera.reto.noelara.dtos.ProductsDTO;
import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.models.Products;
import lumbrera.reto.noelara.models.Variations;
import lumbrera.reto.noelara.repositories.CompanyRepository;
import lumbrera.reto.noelara.repositories.ProductRepository;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository productsRepository;

    @Inject
    private CompanyRepository companyRepository;

    @Inject
    private EntityManager entityManager;

    @Inject
    private ProductService productService;

    @Inject
    VariationService variationService;

    /*
     * Method to add or update products
     *
     * @param productsDTO the product to be added or updated to the data base
     *
     *
     */
    public void add(final ProductsDTO productsDTO) {

        boolean isvalid = true;

        // get the company Id
        final long companyId = productsDTO.getCompanies().getId();

        // get the variations List
        final List<Variations> liVariations = productsDTO.getLiVariations();

        // get company by id to verify this doesn't exist
        final Optional<Companies> c = companyRepository.findById(companyId);

        // validation before add the object to data base
        if (productsDTO.getStock() <= 0 || productsDTO.getCost() >= productsDTO.getPrice() || c == null) {
            isvalid = false;
        }

        // if validation is correct then add the product
        if (isvalid) {
            // new Companies object to set the Id of the associated company
            final Companies companies = new Companies();
            companies.setId(companyId);

            // new Product object to fill the Products model
            final Products product = new Products();
            product.setCompanies(companies);
            product.setId(productsDTO.getIdProduct());
            product.setCost(productsDTO.getCost());
            product.setHasiva(productsDTO.isHasIva());
            product.setName(productsDTO.getName());
            product.setPrice(productsDTO.getPrice());
            product.setStock(productsDTO.getStock());

            // adding product to data base
            productsRepository.save(product);
        }

        if (liVariations != null && !liVariations.isEmpty()) {

            final long prodId = productService.findLast();
            final Products products2 = new Products();
            Variations variations = new Variations();
            products2.setId(prodId);

            for (int i = 0; i < liVariations.size(); i++) {
                variations = liVariations.get(i);
                variations.setProducts(products2);
                variations.setBrand(liVariations.get(i).getBrand());
                variations.setName(liVariations.get(i).getName());
                variations.setSku(liVariations.get(i).getSku());
                variations.setStock(liVariations.get(i).getStock());

                variationService.add(variations);
            }
        }

    }

    /*
     * Method to delete products
     *
     * @param products the product to be deleted to the data base
     *
     *
     */
    public void delete(final Products product) {
        productsRepository.delete(product);
    }

    /*
     * Method to find the last register from data base
     *
     */
    @Transactional
    public long findLast() {

        // sql query to select the last register from products table
        return (long) entityManager.createNativeQuery("SELECT id FROM Products  \n" + "ORDER BY id DESC  \n" + "LIMIT 1;  ")
                .getSingleResult();
    }
}

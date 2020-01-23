package lumbrera.reto.noelara.services;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lumbrera.reto.noelara.models.Variations;
import lumbrera.reto.noelara.repositories.VariationRepository;

@ApplicationScoped
public class VariationService {

    // repository with in box methods to handle CRUD operations for Variation
    // object
    @Inject
    private VariationRepository variationRepository;

    /*
     * Method to add variations
     *
     * @param variations the variation to be added or updated
     *
     *
     */
    public void add(final Variations variations) {

        boolean isvalid = true;

        // getting variation if exist
        final Optional<Variations> c = variationRepository.findById(variations.getProducts().getId());

        // adding validations
        if (variations.getStock() <= 0 || c == null) {
            isvalid = false;
        }

        // if is valid, the object is added
        if (isvalid) {
            final Variations v = new Variations();
            v.setBrand(variations.getBrand());
            v.setName(variations.getName());
            v.setProducts(variations.getProducts());
            v.setSku(variations.getSku());
            v.setStock(variations.getStock());
            variationRepository.save(v);
        }
    }
}

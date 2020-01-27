package lumbrera.reto.noelara.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.jboss.logging.Logger;

import lumbrera.reto.noelara.models.Variations;
import lumbrera.reto.noelara.repositories.VariationRepository;

@ApplicationScoped
public class VariationService {

    @Inject
    private VariationRepository variationRepository;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    /*
     * Method to add a list of variations
     *
     * @param itVariations an Iterable of type Variations
     *
     */
    @Transactional
    public List<Variations> addAll(final Iterable<Variations> itVariations) throws Exception {

        return (List<Variations>) variationRepository.saveAll(itVariations);

    }

    /*
     * Method to add a Variation
     *
     * @param variations an Object of type Variations
     *
     */
    @Transactional
    public Variations add(final Variations variations) throws Exception {

        return variationRepository.save(variations);

    }

    /*
     * Method to add a Variation
     *
     * @param variations an Object of type Variations
     *
     */
    public Variations findVariationById(final long id) throws NotFoundException, NoSuchElementException {

        return variationRepository.findById(id).get();

    }
}

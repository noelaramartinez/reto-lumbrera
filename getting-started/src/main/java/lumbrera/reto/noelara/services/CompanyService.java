package lumbrera.reto.noelara.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.repositories.CompanyRepository;

@ApplicationScoped
public class CompanyService {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    @Inject
    private CompanyRepository companyRepository;

    /*
     * Method to get all companies
     *
     * @return all registered companies
     *
     *
     */
    public List<Companies> getAll() {

        try {
            return (List<Companies>) companyRepository.findAll();
        } catch (final Exception e) {
            LOGGER.error(e.getMessage());
        }

        return null;
    }

    /*
     * Method to add or update companies
     *
     * @param company the object to be registered
     *
     */
    public Companies add(final Companies company) {

        try {
            return companyRepository.save(company);
        } catch (final Exception e) {
            LOGGER.error(e.getMessage());
        }

        return null;
    }
}

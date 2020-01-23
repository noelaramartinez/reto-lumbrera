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

        final List<Companies> companies = (List<Companies>) companyRepository.findAll();

        return companies;

    }

    /*
     * Method to add or update companies
     *
     * @param company the object to be registered
     *
     */
    public Companies add(final Companies company) {

        LOGGER.info(company.toString());

        final Companies c = companyRepository.save(company);

        if (c != null) {
            return c;
        }

        return null;
    }
}

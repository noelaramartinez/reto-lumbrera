package lumbrera.reto.noelara.controllers;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lumbrera.reto.noelara.commons.InputStreamToStringParser;
import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.services.CompanyService;

@Path("/companies")
public class CompanyController {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    // service for using crud methods for Companies
    @Inject
    CompanyService companyService;

    // Parser for InputStream to String format
    @Inject
    InputStreamToStringParser inputStreamToStringParser;

    // gson to handle json Strings
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /*
     * Method to get all registered companies
     *
     * @return companies the companies in database
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanies() {

        final List<Companies> companies = companyService.getAll();

        return gson.toJson(companies);
    }

    /*
     * Method to add a company
     *
     * @param companies the company added to data base in json format
     *
     * @return inputStream data from POST request
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String addCompany(final InputStream inputStream) {

        final Companies c = gson.fromJson(inputStreamToStringParser.inputStreamToString(inputStream), Companies.class);

        return gson.toJson(companyService.add(c));
    }

}

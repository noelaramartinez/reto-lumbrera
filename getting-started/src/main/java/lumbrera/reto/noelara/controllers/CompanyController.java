package lumbrera.reto.noelara.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.google.gson.Gson;

import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.services.CompanyService;

@Path("/companies")
public class CompanyController {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    @Inject
    CompanyService companyService;

    Gson gson = new Gson();

    /*
     * Metodo para obtener todas las compañías registradas
     *
     * @return companies at the companies endpoint
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCompanies() {

        final List<Companies> companies = companyService.getAll();

        return gson.toJson(companies);
    }

    /*
     * Metodo para agregar una compañía
     *
     * @param instance of type company
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String addCompany(@DefaultValue("green") @QueryParam("company") String company) {

        LOGGER.info("dentrode add");
        LOGGER.info(company);
        company = "{\n" + "\n" + "        \"name\":\"compumatico\"\n" + "\n" + "}";
        LOGGER.info(company);
        final Companies companies = gson.fromJson(company, Companies.class);

        LOGGER.info(companies.getName());
        LOGGER.info(companies.getId());

        final Companies c = companyService.add(companies);

        return gson.toJson(c);
    }

}

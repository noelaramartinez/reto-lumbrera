package lumbrera.reto.noelara.testcontrollers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.quarkus.test.junit.QuarkusTest;
import lumbrera.reto.noelara.models.Companies;
import lumbrera.reto.noelara.services.CompanyService;

@QuarkusTest
public class CompanyControllerTest {

    @Inject
    CompanyService companyService;

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    @Inject
    @Any
    Companies companies;

    // gson to handle json Strings
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void getAllCompanies() {

        given().when().get("/companies").then().statusCode(200).body(is(gson.toJson(companyService.getAll())));

    }

}

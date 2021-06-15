package cucumber.features;

import cucumber.http.Sprint3.SearchCarWash_QualityHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchCarWash_Quality {
    private SearchCarWash_QualityHttp searchCarWash_qualityHttp;

    @Before
    public void init() {
        this.searchCarWash_qualityHttp = new SearchCarWash_QualityHttp();
    }

    @Given("que ingreso al API {string} para filtrar por calificacion")
    public void ingressToAPI(String string) {
        this.searchCarWash_qualityHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para filtrar por calificacion")
    public void ubicatedOnRoute(String string) {
        this.searchCarWash_qualityHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para filtrar por calificacion")
    public void byMethod(String string) {
        this.searchCarWash_qualityHttp.setMethod(string);
    }

    @When("envio su peticion para filtrar por calificacion")
    public void sendRequest() throws IOException {
        this.searchCarWash_qualityHttp.make();
    }

    @Then("obtuvo la lista de CarWashes filtrados por calificacion")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.searchCarWash_qualityHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

package cucumber.features;

import cucumber.http.Sprint3.SearchCarWash_NameHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchCarWash_Name {
    private SearchCarWash_NameHttp searchCarWash_nameHttp;

    @Before
    public void init() {
        this.searchCarWash_nameHttp = new SearchCarWash_NameHttp();
    }

    @Given("que ingreso al API {string} para filtrar por nombre")
    public void ingressToAPI(String string) {
        this.searchCarWash_nameHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para filtrar por nombre")
    public void ubicatedOnRoute(String string) {
        this.searchCarWash_nameHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para filtrar por nombre")
    public void byMethod(String string) {
        this.searchCarWash_nameHttp.setMethod(string);
    }

    @When("envio su peticion para filtrar por nombre")
    public void sendRequest() throws IOException {
        this.searchCarWash_nameHttp.make();
    }

    @Then("obtuvo la lista de CarWashes filtrados por nombre")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.searchCarWash_nameHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

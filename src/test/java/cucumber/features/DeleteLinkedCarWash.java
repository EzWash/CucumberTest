package cucumber.features;

import cucumber.http.Sprint2.DeleteLinkedCarWashHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeleteLinkedCarWash {
    private DeleteLinkedCarWashHttp deleteLinkedCarWashHttp;

    @Before
    public void init() {
        this.deleteLinkedCarWashHttp = new DeleteLinkedCarWashHttp();
    }

    @Given("que ingreso al API {string} para eliminar de favoritos")
    public void ingressToAPI(String string) {
        this.deleteLinkedCarWashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para eliminar de favoritos")
    public void ubicatedOnRoute(String string) {
        this.deleteLinkedCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para eliminar de favoritos")
    public void byMethod(String string) {
        this.deleteLinkedCarWashHttp.setMethod(string);
    }

    @When("envio su peticion para eliminar de favoritos")
    public void sendRequest() throws IOException {
        this.deleteLinkedCarWashHttp.make();
    }

    @Then("se eliminaron los carwashes de favoritos")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.deleteLinkedCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }
    }
}

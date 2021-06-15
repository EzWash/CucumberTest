package cucumber.features;

import cucumber.http.Sprint2.GetStateServiceHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetStateService {
    private GetStateServiceHttp getStateServiceHttp;

    @Before
    public void init() {
        this.getStateServiceHttp = new GetStateServiceHttp();
    }

    @Given("que ingreso al API {string} - user_service")
    public void ingressToAPI(String string) {
        this.getStateServiceHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - user_service")
    public void ubicatedOnRoute(String string) {
        this.getStateServiceHttp.setPath(string);
    }

    @Given("mediante el metodo {string} - user_service")
    public void byMethod(String string) {
        this.getStateServiceHttp.setMethod(string);
    }

    @When("envio su peticion - user_service")
    public void sendRequest() throws IOException {
        this.getStateServiceHttp.make();
    }

    @Then("obtuvo la lista de Servicios - user_service")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getStateServiceHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

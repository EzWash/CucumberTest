package cucumber.features;

import cucumber.http.Sprint2.GetStateServiceHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetComments_Quality {
    private GetStateServiceHttp getStateServiceHttp;

    @Before
    public void init() {
        this.getStateServiceHttp = new GetStateServiceHttp();
    }

    @Given("que ingreso al API {string} para obtener comentarios")
    public void ingressToAPI(String string) {
        this.getStateServiceHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener comentarios")
    public void ubicatedOnRoute(String string) {
        this.getStateServiceHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener comentarios")
    public void byMethod(String string) {
        this.getStateServiceHttp.setMethod(string);
    }

    @When("envio su peticion para obtener comentarios")
    public void sendRequest() throws IOException {
        this.getStateServiceHttp.make();
    }

    @Then("obtuvo la lista de Comentarios de un CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getStateServiceHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

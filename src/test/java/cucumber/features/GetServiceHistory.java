package cucumber.features;

import cucumber.http.Sprint3.GetServiceHistoryHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetServiceHistory {
    private GetServiceHistoryHttp getServiceHistoryHttp;

    @Before
    public void init() {
        this.getServiceHistoryHttp = new GetServiceHistoryHttp();
    }

    @Given("que ingreso al API {string} para obtener servicios")
    public void ingressToAPI(String string) {
        this.getServiceHistoryHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener servicios")
    public void ubicatedOnRoute(String string) {
        this.getServiceHistoryHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener servicios")
    public void byMethod(String string) {
        this.getServiceHistoryHttp.setMethod(string);
    }

    @When("envio su peticion para obtener servicios")
    public void sendRequest() throws IOException {
        this.getServiceHistoryHttp.make();
    }

    @Then("obtuvo la lista de Servicios de un CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getServiceHistoryHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

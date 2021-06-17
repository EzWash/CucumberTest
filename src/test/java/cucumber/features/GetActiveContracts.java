package cucumber.features;

import cucumber.http.Sprint2.GetCarWashHttp;
import cucumber.http.Sprint4.GetActiveContractsHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetActiveContracts {
    private GetActiveContractsHttp getActiveContractsHttp;

    @Before
    public void init() {
        this.getActiveContractsHttp = new GetActiveContractsHttp();
    }

    @Given("que ingreso al API {string} para ver Contratos activos")
    public void ingressToAPI(String string) {
        this.getActiveContractsHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para ver Contratos activos")
    public void ubicatedOnRoute(String string) {
        this.getActiveContractsHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para ver Contratos activos")
    public void byMethod(String string) {
        this.getActiveContractsHttp.setMethod(string);
    }

    @When("envio su peticion para ver Contratos activos")
    public void sendRequest() throws IOException {
        this.getActiveContractsHttp.make();
    }

    @Then("obtuvo los Contratos Activos")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getActiveContractsHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

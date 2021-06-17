package cucumber.features;

import cucumber.http.Sprint2.DeleteLinkedCarWashHttp;
import cucumber.http.Sprint4.DeleteCarClientHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteCarClient {
    private DeleteCarClientHttp deleteCarClientHttp;

    @Before
    public void init() {
        this.deleteCarClientHttp = new DeleteCarClientHttp();
    }

    @Given("que ingreso al API {string} para eliminar carro del cliente")
    public void ingressToAPI(String string) {
        this.deleteCarClientHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para eliminar carro del cliente")
    public void ubicatedOnRoute(String string) {
        this.deleteCarClientHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para eliminar carro del cliente")
    public void byMethod(String string) {
        this.deleteCarClientHttp.setMethod(string);
    }

    @When("envio su peticion para eliminar carro del cliente")
    public void sendRequest() throws IOException {
        this.deleteCarClientHttp.make();
    }

    @Then("se elimino el carro del cliente")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.deleteCarClientHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }
    }
}

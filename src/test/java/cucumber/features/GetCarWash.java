package cucumber.features;

import cucumber.http.Sprint2.GetCarWashHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetCarWash {
    private GetCarWashHttp getCarWashHttp;

    @Before
    public void init() {
        this.getCarWashHttp = new GetCarWashHttp();
    }

    @Given("que ingreso al API {string} para ver CarWash")
    public void ingressToAPI(String string) {
        this.getCarWashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para ver CarWash")
    public void ubicatedOnRoute(String string) {
        this.getCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para ver CarWash")
    public void byMethod(String string) {
        this.getCarWashHttp.setMethod(string);
    }

    @When("envio su peticion para ver CarWash")
    public void sendRequest() throws IOException {
        this.getCarWashHttp.make();
    }

    @Then("obtuvo el CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

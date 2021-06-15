package cucumber.features;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetNearlyCarWash {
    private cucumber.http.Sprint1.GetNearlyCarWash getNearlyCarWash;

    @Before
    public void init() {
        this.getNearlyCarWash = new cucumber.http.Sprint1.GetNearlyCarWash();
    }

    @Given("que ingreso al API {string} - user_carwash")
    public void ingressToAPI(String string) {
        this.getNearlyCarWash.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - user_carwash")
    public void ubicatedOnRoute(String string) {
        this.getNearlyCarWash.setPath(string);
    }

    @Given("mediante el metodo {string} - user_carwash")
    public void byMethod(String string) {
        this.getNearlyCarWash.setMethod(string);
    }

    @When("envio su peticion - user_carwash")
    public void sendRequest() throws IOException {
        this.getNearlyCarWash.make();
    }

    @Then("obtuvo la lista de CarWashes - user_carwash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getNearlyCarWash.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

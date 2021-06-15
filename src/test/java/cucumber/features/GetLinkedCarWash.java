package cucumber.features;

import cucumber.http.Sprint1.GetNearlyCarWash;
import cucumber.http.Sprint2.GetLinkedCarWashHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetLinkedCarWash {
    private GetLinkedCarWashHttp getLinkedCarWash;

    @Before
    public void init() {
        this.getLinkedCarWash = new GetLinkedCarWashHttp();
    }

    @Given("que ingreso al API {stringress_to_APIng} para ver user_carwash")
    public void ingressToAPI(String string) {
        this.getLinkedCarWash.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para ver user_carwash")
    public void ubicatedOnRoute(String string) {
        this.getLinkedCarWash.setPath(string);
    }

    @Given("mediante el metodo {string} para ver user_carwash")
    public void byMethod(String string) {
        this.getLinkedCarWash.setMethod(string);
    }

    @When("envio su peticion para ver user_carwash")
    public void sendRequest() throws IOException {
        this.getLinkedCarWash.make();
    }

    @Then("obtuvo lista de preferidos_CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getLinkedCarWash.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

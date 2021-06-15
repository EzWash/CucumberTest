package cucumber.features;

import cucumber.http.Sprint2.AddLikedCarWashHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddLikedCarWash {
    private AddLikedCarWashHttp addLikedCarWashHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.addLikedCarWashHttp = new AddLikedCarWashHttp();
    }

    @Given("que ingreso al API {string} para agregar - User_CarWash")
    public void ingressToAPI(String string) {
        this.addLikedCarWashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - User_CarWash")
    public void ubicatedOnRoute(String string) {
        this.addLikedCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - User_CarWash")
    public void byMethod(String string) {
        this.addLikedCarWashHttp.setMethod(string);
    }



    @When("envio su peticion para agregar a favoritos - User_CarWash")
    public void sendRequest() throws IOException {
        this.addLikedCarWashHttp.make();
    }


    @Then("se registro CarWash en favoritos")
    public void getResponseStatusCode() {
        List<Integer> codes = this.addLikedCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}

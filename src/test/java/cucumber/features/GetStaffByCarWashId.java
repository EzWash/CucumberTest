package cucumber.features;

import cucumber.http.Sprint4.GetStaffByCarWashIdHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetStaffByCarWashId {
    private GetStaffByCarWashIdHttp getStaffByCarWashIdHttp;

    @Before
    public void init() {
        this.getStaffByCarWashIdHttp = new GetStaffByCarWashIdHttp();
    }

    @Given("que ingreso al API {string} para obtener trabajadores_carwashID")
    public void ingressToAPI(String string) {
        this.getStaffByCarWashIdHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener trabajadores_carwashID")
    public void ubicatedOnRoute(String string) {
        this.getStaffByCarWashIdHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener trabajadores_carwashID")
    public void byMethod(String string) {
        this.getStaffByCarWashIdHttp.setMethod(string);
    }

    @When("envio su peticion para obtener trabajadores_carwashID")
    public void sendRequest() throws IOException {
        this.getStaffByCarWashIdHttp.make();
    }

    @Then("obtuvo la lista de Trabajadores por ID del CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getStaffByCarWashIdHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

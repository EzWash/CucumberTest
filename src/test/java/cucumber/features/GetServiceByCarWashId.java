package cucumber.features;

import cucumber.http.Sprint4.GetServiceByCarWashIdHttp;
import cucumber.http.Sprint4.GetStaffByCarWashIdHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetServiceByCarWashId {
    private GetServiceByCarWashIdHttp getServiceByCarWashIdHttp;

    @Before
    public void init() {
        this.getServiceByCarWashIdHttp = new GetServiceByCarWashIdHttp();
    }

    @Given("que ingreso al API {string} para obtener servicios_carwashID")
    public void ingressToAPI(String string) {
        this.getServiceByCarWashIdHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener servicios_carwashID")
    public void ubicatedOnRoute(String string) {
        this.getServiceByCarWashIdHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener servicios_carwashID")
    public void byMethod(String string) {
        this.getServiceByCarWashIdHttp.setMethod(string);
    }

    @When("envio su peticion para obtener servicios_carwashID")
    public void sendRequest() throws IOException {
        this.getServiceByCarWashIdHttp.make();
    }

    @Then("obtuvo la lista de Servicios por ID del CarWash")
    public void getResponseStatusCode() throws IOException {
        List<Integer> codes = this.getServiceByCarWashIdHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

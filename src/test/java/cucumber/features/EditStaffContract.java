package cucumber.features;

import cucumber.http.Sprint2.EditCustomerHttp;
import cucumber.resource.accounts.UserResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EditStaffContract {
    private EditCustomerHttp editCustomerHttp;

    @Before
    public void init() {
        this.editCustomerHttp = new EditCustomerHttp();
    }

    @Given("que ingreso al API {string} para actualizar Trabajador del contrato")
    public void ingressToAPI(String string) {
        this.editCustomerHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar Trabajador del contrato")
    public void ubicatedOnRoute(String string) {
        this.editCustomerHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar Trabajador del contrato")
    public void byMethod(String string) {
        this.editCustomerHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar Trabajador del contrato")
    public void getData() throws IOException {

    }

    @When("envio su peticion para actualizar Trabajador del contrato")
    public void sendRequest() throws IOException {
        this.editCustomerHttp.make();
    }

    @Then("se actualiza el Trabajador del contrato")
    public void getResponseStatusCode() {
        List<Integer> codes = this.editCustomerHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

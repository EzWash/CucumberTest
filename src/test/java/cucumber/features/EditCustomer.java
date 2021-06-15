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

public class EditCustomer {
    private EditCustomerHttp editCustomerHttp;

    @Before
    public void init() {
        this.editCustomerHttp = new EditCustomerHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del Usuario")
    public void ingressToAPI(String string) {
        this.editCustomerHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del Usuario")
    public void ubicatedOnRoute(String string) {
        this.editCustomerHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del Usuario")
    public void byMethod(String string) {
        this.editCustomerHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del Usuario")
    public void getData(@NotNull DataTable dataTable) throws IOException {

        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        DataTable a= dataTable.subTable(0,6);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);
        for (int i = 0; i < list.size(); i++) {
            UserResource userResource = new UserResource();
            userResource.setFirst_name(list.get(i).get("First_Name"));
            userResource.setLast_name(list.get(i).get("Last_Name"));
            userResource.setEmail(list.get(i).get("Email"));
            userResource.setPassword(list.get(i).get("Password"));
            userResource.setPhone_number(list.get(i).get("Phone"));
            userResource.setGender(list.get(i).get("Gender"));
            userResource.setLocation(list1.get(i).get("Location"));

            this.editCustomerHttp.updateUserData(userResource);
        }
    }

    @When("envio su peticion para actualizar datos del Usuario")
    public void sendRequest() throws IOException {
        this.editCustomerHttp.make();
    }

    @Then("se actualiza los datos del Usuario")
    public void getResponseStatusCode() {
        List<Integer> codes = this.editCustomerHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

package cucumber.features;

import cucumber.http.Sprint1.RegisterCustomerHttp;
import cucumber.resource.accounts.UserResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterCustomer {
    private RegisterCustomerHttp registerCustomerHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerCustomerHttp = new RegisterCustomerHttp();
    }

    @Given("que ingreso al API {string} para agregar - Usuario")
    public void ingressToAPI(String string) {
        this.registerCustomerHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Usuario")
    public void ubicatedOnRoute(String string) {
        this.registerCustomerHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Usuario")
    public void byMethod(String string) {
        this.registerCustomerHttp.setMethod(string);
    }

    @Given("tengo el siguiente Usuario para agregar")
    public void getData(DataTable dataTable) throws IOException {
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

            this.registerCustomerHttp.createUser(userResource);
        }
    }

    @When("envio su peticion para agregar - Usuario")
    public void sendRequest() throws IOException {
        this.registerCustomerHttp.make();
    }

    @Then("se registro Usuario")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerCustomerHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0));
            assertTrue(codes.get(0) == 200);
        }
    }
}

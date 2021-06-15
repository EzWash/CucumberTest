package cucumber.features;

import cucumber.http.Sprint1.RegisterStaffHttp;
import cucumber.resource.accounts.StaffResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterStaff {
    private RegisterStaffHttp registerStaffHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerStaffHttp = new RegisterStaffHttp();
    }

    @Given("que ingreso al API {string} para agregar - Trabajador")
    public void ingressToAPI(String string) {
        this.registerStaffHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Trabajador")
    public void ubicatedOnRoute(String string) {
        this.registerStaffHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Trabajador")
    public void byMethod(String string) {
        this.registerStaffHttp.setMethod(string);
    }

    @Given("tengo el siguiente Trabajador para agregar")
    public void getData(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < list.size(); i++) {
            StaffResource staffResource = new StaffResource();
            staffResource.setFirst_name(list.get(i).get("First_name"));
            staffResource.setLast_name(list.get(i).get("Last_name"));
            staffResource.setEmail(list.get(i).get("Email"));
            staffResource.setPhone_number(list.get(i).get("Phone"));
            staffResource.setGender(list.get(i).get("Gender"));

            this.registerStaffHttp.createTrabajador(staffResource);
        }
    }

    @When("envio su peticion para agregar - Trabajador")
    public void sendRequest() throws IOException {
        this.registerStaffHttp.make();
    }

    @Then("se registro Trabajador")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerStaffHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0));
            assertTrue(codes.get(0) == 200);
        }
    }
}

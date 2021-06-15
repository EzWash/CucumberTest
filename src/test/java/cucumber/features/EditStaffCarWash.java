package cucumber.features;

import cucumber.http.Sprint2.EditStaffCarWashHttp;
import cucumber.resource.accounts.StaffResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EditStaffCarWash {
    private EditStaffCarWashHttp editStaffCarWashHttp;

    @Before
    public void init() {
        this.editStaffCarWashHttp = new EditStaffCarWashHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del Trabajador")
    public void ingressToAPI(String string) {
        this.editStaffCarWashHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del Trabajador")
    public void ubicatedOnRoute(String string) {
        this.editStaffCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del Trabajador")
    public void byMethod(String string) {
        this.editStaffCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del Trabajador")
    public void getData( DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < list.size(); i++) {
            StaffResource staffResource = new StaffResource();
            staffResource.setFirst_name(list.get(i).get("First_name"));
            staffResource.setLast_name(list.get(i).get("Last_name"));
            staffResource.setEmail(list.get(i).get("Email"));
            staffResource.setPhone_number(list.get(i).get("Phone"));
            staffResource.setGender(list.get(i).get("Gender"));
            System.out.println(staffResource.getGender());
            this.editStaffCarWashHttp.updateTrabajadorData(staffResource);
        }
    }


    @When("envio su peticion para actualizar datos del Trabajador")
    public void sendRequest() throws IOException {
        this.editStaffCarWashHttp.make();
    }

    @Then("se actualiza los datos del Trabajador")
    public void getResponseStatusCode() {
        List<Integer> codes = this.editStaffCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

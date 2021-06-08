package cucumber.features;

import cucumber.http.Sprint1.RegistrarTrabajadorHttp;
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

public class RegistrarTrabajador {
    private RegistrarTrabajadorHttp registrarTrabajadorHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registrarTrabajadorHttp = new RegistrarTrabajadorHttp();
    }

    @Given("que ingreso al API {string} para agregar - Trabajador")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.registrarTrabajadorHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Trabajador")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.registrarTrabajadorHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Trabajador")
    public void mediante_el_metodo_para_agregar(String string) {
        this.registrarTrabajadorHttp.setMethod(string);
    }

    @Given("tengo el siguiente Trabajador para agregar")
    public void tengo_el_siguiente_trabajador_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < list.size(); i++) {
            StaffResource staffResource = new StaffResource();
            staffResource.setFirst_name(list.get(i).get("First_name"));
            staffResource.setLast_name(list.get(i).get("Last_name"));
            staffResource.setEmail(list.get(i).get("Email"));
            staffResource.setPhone_number(list.get(i).get("Phone"));
            staffResource.setGender(list.get(i).get("Gender"));

            this.registrarTrabajadorHttp.createTrabajador(staffResource);
        }
    }

    @When("envio su peticion para agregar - Trabajador")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.registrarTrabajadorHttp.make();
    }

    @Then("se registro Trabajador")
    public void se_insertaron_los_trabajadores() {
        List<Integer> codes = this.registrarTrabajadorHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0));
            assertTrue(codes.get(0) == 200);
        }
    }
}

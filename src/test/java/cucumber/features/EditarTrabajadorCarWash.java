package cucumber.features;

import cucumber.http.Sprint2.EditarServicioCarWashHttp;
import cucumber.http.Sprint2.EditarTrabajadorCarWashHttp;
import cucumber.resource.accounts.StaffResource;
import cucumber.resource.business.ServiceResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EditarTrabajadorCarWash {
    private EditarTrabajadorCarWashHttp editarTrabajadorCarWashHttp;

    @Before
    public void init() {
        this.editarTrabajadorCarWashHttp = new EditarTrabajadorCarWashHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del Trabajador")
    public void que_ingreso_al_API_para_actualizar_datos_del_Servicio(String string) {
        this.editarTrabajadorCarWashHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del Trabajador")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.editarTrabajadorCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del Trabajador")
    public void mediante_el_metodo_para_agregar(String string) {
        this.editarTrabajadorCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del Trabajador")
    public void tengo_el_siguiente_trabajador_para_agregar( DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < list.size(); i++) {
            StaffResource staffResource = new StaffResource();
            staffResource.setFirst_name(list.get(i).get("First_name"));
            staffResource.setLast_name(list.get(i).get("Last_name"));
            staffResource.setEmail(list.get(i).get("Email"));
            staffResource.setPhone_number(list.get(i).get("Phone"));
            staffResource.setGender(list.get(i).get("Gender"));
            System.out.println(staffResource.getGender());
            this.editarTrabajadorCarWashHttp.updateTrabajadorData(staffResource);
        }
    }


    @When("envio su peticion para actualizar datos del Trabajador")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.editarTrabajadorCarWashHttp.make();
    }

    @Then("se actualiza los datos del Trabajador")
    public void se_insertaron_los_Trabajadores() {
        List<Integer> codes = this.editarTrabajadorCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

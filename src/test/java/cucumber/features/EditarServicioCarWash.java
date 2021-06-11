package cucumber.features;

import cucumber.http.Sprint2.EditarDatosUsuarioHttp;
import cucumber.http.Sprint2.EditarServicioCarWashHttp;
import cucumber.resource.business.ServiceResource;
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

public class EditarServicioCarWash {
    private EditarServicioCarWashHttp editarServicioCarWashHttp;

    @Before
    public void init() {
        this.editarServicioCarWashHttp = new EditarServicioCarWashHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del Servicio")
    public void que_ingreso_al_API_para_actualizar_datos_del_Servicio(String string) {
        this.editarServicioCarWashHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del Servicio")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.editarServicioCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del Servicio")
    public void mediante_el_metodo_para_agregar(String string) {
        this.editarServicioCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del Servicio")
    public void tengo_el_siguiente_servicio_para_agregar( DataTable dataTable) throws IOException {

        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        DataTable b= dataTable.subTable(0,4);
        List<Map<String,Double>> list2 = b.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
            ServiceResource serviceResource = new ServiceResource();
            serviceResource.setName(list.get(i).get("Name"));
            serviceResource.setDetails(list.get(i).get("Details"));
            serviceResource.setDescription(list.get(i).get("Description"));
            serviceResource.setIs_promotion(list1.get(i).get("Is_promotion"));
            serviceResource.setPrice(list2.get(i).get("Price"));
            this.editarServicioCarWashHttp.updateServiceData(serviceResource);
        }
        }


    @When("envio su peticion para actualizar datos del Servicio")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.editarServicioCarWashHttp.make();
    }

    @Then("se actualiza los datos del Servicio")
    public void se_insertaron_los_Service() {
        List<Integer> codes = this.editarServicioCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

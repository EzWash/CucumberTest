package cucumber.features;

import cucumber.http.Sprint1.EditarDatosCarWashHttp;
import cucumber.resource.accounts.CarWashResource;
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


public class EditarDatosCarWash {
    private EditarDatosCarWashHttp editarDatosCarWashHttp;

    @Before
    public void init() {
        this.editarDatosCarWashHttp = new EditarDatosCarWashHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del CarWash")
    public void que_ingreso_al_API_para_actualizar_datos_del_CarWash(String string) {
        this.editarDatosCarWashHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del CarWash")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.editarDatosCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del CarWash")
    public void mediante_el_metodo_para_agregar(String string) {
        this.editarDatosCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del CarWash")
    public void tengo_el_siguiente_producto_para_agregar(@NotNull DataTable dataTable) throws IOException {

        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        //Map<String,Double> list1 = dataTable.columns(2).asMap(String.class,Double.class);
        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
            CarWashResource carwash = new CarWashResource();
            carwash.setName(list.get(i).get("Name"));
            carwash.setDescription(list.get(i).get("Description"));
            carwash.setLocation(list1.get(i).get("Location"));
            carwash.setName_owner(list.get(i).get("Name_owner"));

            this.editarDatosCarWashHttp.actualizarCarWash(carwash);
        }
    }

    @When("envio su peticion para actualizar datos del CarWash")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.editarDatosCarWashHttp.make();
    }

    @Then("se actualiza los datos del CarWash")
    public void se_insertaron_los_CarWash() {
        List<Integer> codes = this.editarDatosCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

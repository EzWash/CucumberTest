package cucumber.features;

import cucumber.http.Sprint1.RegistrarCarwashHttp;
import cucumber.resource.accounts.CarWashResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegistrarCarwash {
    private RegistrarCarwashHttp registrarCarwashHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registrarCarwashHttp = new RegistrarCarwashHttp();
    }

    @Given("que ingreso al API {string} para agregar - CarWash")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.registrarCarwashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - CarWash")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.registrarCarwashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - CarWash")
    public void mediante_el_metodo_para_agregar(String string) {
        this.registrarCarwashHttp.setMethod(string);
    }

    @Given("tengo el siguiente CarWash para agregar")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);
        for (int i = 0; i < list.size(); i++) {
            CarWashResource carWashResource = new CarWashResource();
            carWashResource.setName(list.get(i).get("Name"));
            carWashResource.setDescription(list.get(i).get("Description"));
            carWashResource.setName_owner(list.get(i).get("Name_owner"));
            carWashResource.setLocation(list1.get(i).get("Location"));

            this.registrarCarwashHttp.createCarWash(carWashResource);
        }
    }

    @When("envio su peticion para agregar - CarWash")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.registrarCarwashHttp.make();
    }

    @Then("se registro CarWash")
    public void se_insertaron_los_productos() {
        List<Integer> codes = this.registrarCarwashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}

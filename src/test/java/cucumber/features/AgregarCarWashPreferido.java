package cucumber.features;

import cucumber.http.Sprint1.RegistrarCarwashHttp;
import cucumber.http.Sprint2.AgregarCarWashPreferidoHttp;
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

public class AgregarCarWashPreferido {
    private AgregarCarWashPreferidoHttp agregarCarWashPreferidoHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.agregarCarWashPreferidoHttp = new AgregarCarWashPreferidoHttp();
    }

    @Given("que ingreso al API {string} para agregar - User_CarWash")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.agregarCarWashPreferidoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - User_CarWash")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.agregarCarWashPreferidoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - User_CarWash")
    public void mediante_el_metodo_para_agregar(String string) {
        this.agregarCarWashPreferidoHttp.setMethod(string);
    }



    @When("envio su peticion para agregar a favoritos - User_CarWash")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.agregarCarWashPreferidoHttp.make();
    }


    @Then("se registro CarWash en favoritos")
    public void se_insertaron_los_carwash_favoritos() {
        List<Integer> codes = this.agregarCarWashPreferidoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}

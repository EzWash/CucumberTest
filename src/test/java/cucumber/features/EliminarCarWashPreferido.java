package cucumber.features;

import cucumber.http.Sprint2.EliminarCarWashPreferidoHttp;
import cucumber.resource.accounts.CarWashResource;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EliminarCarWashPreferido {
    private EliminarCarWashPreferidoHttp eliminarCarWashPreferidoHttp;

    @Before
    public void init() {
        this.eliminarCarWashPreferidoHttp = new EliminarCarWashPreferidoHttp();
    }

    @Given("que ingreso al API {string} para eliminar de favoritos")
    public void que_ingreso_al_API_eliminarproducto(String string) {
        this.eliminarCarWashPreferidoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para eliminar de favoritos")
    public void se_ubico_en_la_ruta_producto(String string) {
        this.eliminarCarWashPreferidoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para eliminar de favoritos")
    public void mediante_el_metodo_delete(String string) {
        this.eliminarCarWashPreferidoHttp.setMethod(string);
    }

    @When("envio su peticion para eliminar de favoritos")
    public void envio_su_peticion_eliminar() throws IOException {
        this.eliminarCarWashPreferidoHttp.make();
    }

    @Then("se eliminaron los carwashes de favoritos")
    public void eliminoProducto() throws IOException {
        List<Integer> codes = this.eliminarCarWashPreferidoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }
    }
}

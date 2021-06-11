package cucumber.features;

import cucumber.http.Sprint3.VerHistorialServicioHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerHistorialServicio {
    private VerHistorialServicioHttp verHistorialServicioHttp;

    @Before
    public void init() {
        this.verHistorialServicioHttp = new VerHistorialServicioHttp();
    }

    @Given("que ingreso al API {string} para obtener servicios")
    public void que_ingreso_al_API(String string) {
        this.verHistorialServicioHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener servicios")
    public void se_ubico_en_la_ruta(String string) {
        this.verHistorialServicioHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener servicios")
    public void mediante_el_metodo(String string) {
        this.verHistorialServicioHttp.setMethod(string);
    }

    @When("envio su peticion para obtener servicios")
    public void envio_su_peticion() throws IOException {
        this.verHistorialServicioHttp.make();
    }

    @Then("obtuvo la lista de Servicios de un CarWash")
    public void obtuvo_los_CarWash() throws IOException {
        List<Integer> codes = this.verHistorialServicioHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

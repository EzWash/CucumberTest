package cucumber.features;

import cucumber.http.Sprint1.VerCarWashCercanoHttp;
import cucumber.http.Sprint2.VerEstadoServicioContratadoHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerEstadoServicioContratado {
    private VerEstadoServicioContratadoHttp verEstadoServicioContratadoHttp;

    @Before
    public void init() {
        this.verEstadoServicioContratadoHttp = new VerEstadoServicioContratadoHttp();
    }

    @Given("que ingreso al API {string} - user_service")
    public void que_ingreso_al_API(String string) {
        this.verEstadoServicioContratadoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - user_service")
    public void se_ubico_en_la_ruta(String string) {
        this.verEstadoServicioContratadoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} - user_service")
    public void mediante_el_metodo(String string) {
        this.verEstadoServicioContratadoHttp.setMethod(string);
    }

    @When("envio su peticion - user_service")
    public void envio_su_peticion() throws IOException {
        this.verEstadoServicioContratadoHttp.make();
    }

    @Then("obtuvo la lista de Servicios - user_service")
    public void obtuvo_los_CarWash() throws IOException {
        List<Integer> codes = this.verEstadoServicioContratadoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

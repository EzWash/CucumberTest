package cucumber.features;

import com.google.gson.Gson;
import cucumber.http.Sprint2.VerEstadoServicioContratadoHttp;
import cucumber.resource.accounts.UserResource;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerComentarios_NivelCalidad {
    private VerEstadoServicioContratadoHttp verEstadoServicioContratadoHttp;

    @Before
    public void init() {
        this.verEstadoServicioContratadoHttp = new VerEstadoServicioContratadoHttp();
    }

    @Given("que ingreso al API {string} para obtener comentarios")
    public void que_ingreso_al_API(String string) {
        this.verEstadoServicioContratadoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener comentarios")
    public void se_ubico_en_la_ruta(String string) {
        this.verEstadoServicioContratadoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener comentarios")
    public void mediante_el_metodo(String string) {
        this.verEstadoServicioContratadoHttp.setMethod(string);
    }

    @When("envio su peticion para obtener comentarios")
    public void envio_su_peticion() throws IOException {
        this.verEstadoServicioContratadoHttp.make();
    }

    @Then("obtuvo la lista de Comentarios de un CarWash")
    public void obtuvo_los_CarWash() throws IOException {
        List<Integer> codes = this.verEstadoServicioContratadoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

package cucumber.features;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuscarCarWash_NivelCalidadHttp {
    private cucumber.http.Sprint3.BuscarCarWash_NivelCalidadHttp buscarCarWashNivelCalidad;

    @Before
    public void init() {
        this.buscarCarWashNivelCalidad = new cucumber.http.Sprint3.BuscarCarWash_NivelCalidadHttp();
    }

    @Given("que ingreso al API {string} para filtrar por calificacion")
    public void que_ingreso_al_API(String string) {
        this.buscarCarWashNivelCalidad.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para filtrar por calificacion")
    public void se_ubico_en_la_ruta(String string) {
        this.buscarCarWashNivelCalidad.setPath(string);
    }

    @Given("mediante el metodo {string} para filtrar por calificacion")
    public void mediante_el_metodo(String string) {
        this.buscarCarWashNivelCalidad.setMethod(string);
    }

    @When("envio su peticion para filtrar por calificacion")
    public void envio_su_peticion() throws IOException {
        this.buscarCarWashNivelCalidad.make();
    }

    @Then("obtuvo la lista de CarWashes filtrados por calificacion")
    public void obtuvo_los_CarWash_Calificacion() throws IOException {
        List<Integer> codes = this.buscarCarWashNivelCalidad.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

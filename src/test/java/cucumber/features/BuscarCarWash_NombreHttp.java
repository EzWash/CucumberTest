package cucumber.features;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuscarCarWash_NombreHttp {
    private cucumber.http.Sprint3.BuscarCarWash_NombreHttp buscarCarWash_nombreHttp;

    @Before
    public void init() {
        this.buscarCarWash_nombreHttp = new cucumber.http.Sprint3.BuscarCarWash_NombreHttp();
    }

    @Given("que ingreso al API {string} para filtrar por nombre")
    public void que_ingreso_al_API(String string) {
        this.buscarCarWash_nombreHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para filtrar por nombre")
    public void se_ubico_en_la_ruta(String string) {
        this.buscarCarWash_nombreHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para filtrar por nombre")
    public void mediante_el_metodo(String string) {
        this.buscarCarWash_nombreHttp.setMethod(string);
    }

    @When("envio su peticion para filtrar por nombre")
    public void envio_su_peticion() throws IOException {
        this.buscarCarWash_nombreHttp.make();
    }

    @Then("obtuvo la lista de CarWashes filtrados por nombre")
    public void obtuvo_los_CarWash_Nombre() throws IOException {
        List<Integer> codes = this.buscarCarWash_nombreHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

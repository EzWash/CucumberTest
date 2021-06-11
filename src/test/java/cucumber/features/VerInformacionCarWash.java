package cucumber.features;

import cucumber.http.Sprint2.VerEstadoServicioContratadoHttp;
import cucumber.http.Sprint2.VerInformacionCarWashHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerInformacionCarWash {
    private VerInformacionCarWashHttp verInformacionCarWashHttp;

    @Before
    public void init() {
        this.verInformacionCarWashHttp = new VerInformacionCarWashHttp();
    }

    @Given("que ingreso al API {string} para ver CarWash")
    public void que_ingreso_al_API(String string) {
        this.verInformacionCarWashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para ver CarWash")
    public void se_ubico_en_la_ruta(String string) {
        this.verInformacionCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para ver CarWash")
    public void mediante_el_metodo(String string) {
        this.verInformacionCarWashHttp.setMethod(string);
    }

    @When("envio su peticion para ver CarWash")
    public void envio_su_peticion() throws IOException {
        this.verInformacionCarWashHttp.make();
    }

    @Then("obtuvo el CarWash")
    public void obtuvo_los_CarWash() throws IOException {
        List<Integer> codes = this.verInformacionCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

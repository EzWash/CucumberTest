package cucumber.features;

import cucumber.http.Sprint1.VerCarWashCercanoHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerListaPreferidaUsuario {
    private VerCarWashCercanoHttp verCarWashCercanoHttp;

    @Before
    public void init() {
        this.verCarWashCercanoHttp = new VerCarWashCercanoHttp();
    }

    @Given("que ingreso al API {string} para ver user_carwash")
    public void que_ingreso_al_API(String string) {
        this.verCarWashCercanoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para ver user_carwash")
    public void se_ubico_en_la_ruta(String string) {
        this.verCarWashCercanoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para ver user_carwash")
    public void mediante_el_metodo(String string) {
        this.verCarWashCercanoHttp.setMethod(string);
    }

    @When("envio su peticion para ver user_carwash")
    public void envio_su_peticion() throws IOException {
        this.verCarWashCercanoHttp.make();
    }

    @Then("obtuvo lista de preferidos_CarWash")
    public void obtuvo_los_CarWash() throws IOException {
        List<Integer> codes = this.verCarWashCercanoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(i));
            assertEquals(200, (int) codes.get(0));
        }

    }
}

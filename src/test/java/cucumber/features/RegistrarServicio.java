package cucumber.features;

import cucumber.http.Sprint1.RegistrarServicioHttp;
import cucumber.resource.business.ServiceResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegistrarServicio {
    private RegistrarServicioHttp registrarServicioHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registrarServicioHttp = new RegistrarServicioHttp();
    }

    @Given("que ingreso al API {string} para agregar - Servicio")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.registrarServicioHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Servicio")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.registrarServicioHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Servicio")
    public void mediante_el_metodo_para_agregar(String string) {
        this.registrarServicioHttp.setMethod(string);
    }

    @Given("tengo el siguiente Servicio para agregar")
    public void tengo_el_siguiente_carro_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        DataTable b= dataTable.subTable(0,4);
        List<Map<String,Double>> list2 = b.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
           ServiceResource serviceResource = new ServiceResource();
            serviceResource.setName(list.get(i).get("Name"));
            serviceResource.setDetails(list.get(i).get("Details"));
            serviceResource.setDescription(list.get(i).get("Description"));
            serviceResource.setIs_promotion(list1.get(i).get("Is_promotion"));
            serviceResource.setPrice(list2.get(i).get("Price"));
            this.registrarServicioHttp.createServicio(serviceResource);
        }
    }

    @When("envio su peticion para agregar - Servicio")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.registrarServicioHttp.make();
    }

    @Then("se registro Servicio")
    public void se_insertaron_los_Carros() {
        List<Integer> codes = this.registrarServicioHttp.getResponseStatusCodes();
        System.out.println(codes);
        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0)==200);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

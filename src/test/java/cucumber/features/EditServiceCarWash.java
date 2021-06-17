package cucumber.features;

import cucumber.http.Sprint2.EditServiceCarWashHttp;
import cucumber.resource.business.Contrac;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EditServiceCarWash {
    private EditServiceCarWashHttp editServiceCarWashHttp;

    @Before
    public void init() {
        this.editServiceCarWashHttp = new EditServiceCarWashHttp();
    }

    @Given("que ingreso al API {string} para actualizar datos del Servicio")
    public void ingressToAPI(String string) {
        this.editServiceCarWashHttp.setUrl(string);

    }

    @Given("se ubica en la ruta {string} para actualizar datos del Servicio")
    public void ubicatedOnRoute(String string) {
        this.editServiceCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar datos del Servicio")
    public void byMethod(String string) {
        this.editServiceCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente formulario para actualizar datos del Servicio")
    public void getData( DataTable dataTable) throws IOException {

        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        DataTable b= dataTable.subTable(0,4);
        List<Map<String,Double>> list2 = b.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
            Contrac serviceResource = new Contrac();
            serviceResource.setName(list.get(i).get("Name"));
            serviceResource.setDetails(list.get(i).get("Details"));
            serviceResource.setDescription(list.get(i).get("Description"));
            serviceResource.setIs_promotion(list1.get(i).get("Is_promotion"));
            serviceResource.setPrice(list2.get(i).get("Price"));
            this.editServiceCarWashHttp.updateServiceData(serviceResource);
        }
        }


    @When("envio su peticion para actualizar datos del Servicio")
    public void sendRequest() throws IOException {
        this.editServiceCarWashHttp.make();
    }

    @Then("se actualiza los datos del Servicio")
    public void getResponseStatusCode() {
        List<Integer> codes = this.editServiceCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            codes.get(i);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

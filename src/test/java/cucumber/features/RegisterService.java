package cucumber.features;

import cucumber.http.Sprint1.RegisterServiceHttp;
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

public class RegisterService {
    private RegisterServiceHttp registerServiceHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerServiceHttp = new RegisterServiceHttp();
    }

    @Given("que ingreso al API {string} para agregar - Servicio")
    public void ingressToAPI(String string) {
        this.registerServiceHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Servicio")
    public void ubicatedOnRoute(String string) {
        this.registerServiceHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Servicio")
    public void byMethod(String string) {
        this.registerServiceHttp.setMethod(string);
    }

    @Given("tengo el siguiente Servicio para agregar")
    public void getData(DataTable dataTable) throws IOException {
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
            this.registerServiceHttp.createServicio(serviceResource);
        }
    }

    @When("envio su peticion para agregar - Servicio")
    public void sendRequest() throws IOException {
        this.registerServiceHttp.make();
    }

    @Then("se registro Servicio")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerServiceHttp.getResponseStatusCodes();
        System.out.println(codes);
        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0)==200);
            assertEquals(200, (int) codes.get(0));
        }
    }
}

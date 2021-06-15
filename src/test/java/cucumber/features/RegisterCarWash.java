package cucumber.features;

import cucumber.http.Sprint1.RegisterCarWashHttp;
import cucumber.resource.accounts.CarWashResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterCarWash {
    private RegisterCarWashHttp registerCarWashHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerCarWashHttp = new RegisterCarWashHttp();
    }

    @Given("que ingreso al API {string} para agregar - CarWash")
    public void ingressToAPI(String string) {
        this.registerCarWashHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - CarWash")
    public void ubicatedOnRoute(String string) {
        this.registerCarWashHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - CarWash")
    public void byMethod(String string) {
        this.registerCarWashHttp.setMethod(string);
    }

    @Given("tengo el siguiente CarWash para agregar")
    public void getData(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);
        for (int i = 0; i < list.size(); i++) {
            CarWashResource carWashResource = new CarWashResource();
            carWashResource.setName(list.get(i).get("Name"));
            carWashResource.setDescription(list.get(i).get("Description"));
            carWashResource.setName_owner(list.get(i).get("Name_owner"));
            carWashResource.setLocation(list1.get(i).get("Location"));

            this.registerCarWashHttp.createCarWash(carWashResource);
        }
    }

    @When("envio su peticion para agregar - CarWash")
    public void sendRequest() throws IOException {
        this.registerCarWashHttp.make();
    }

    @Then("se registro CarWash")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerCarWashHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}

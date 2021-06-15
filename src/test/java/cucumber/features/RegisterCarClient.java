package cucumber.features;

import cucumber.http.Sprint1.RegisterCarClientHttp;
import cucumber.resource.interactions.VehicleResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterCarClient {


    private RegisterCarClientHttp registerCarClientHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerCarClientHttp = new RegisterCarClientHttp();
    }

    @Given("que ingreso al API {string} para agregar - Carro_User")
    public void ingressToAPI(String string) {
        this.registerCarClientHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - Carro_User")
    public void ubicatedOnRoute(String string) {
        this.registerCarClientHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - Carro_User")
    public void byMethod(String string) {
        this.registerCarClientHttp.setMethod(string);
    }

    @Given("tengo el siguiente Carro para agregar")
    public void getData(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);

        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        DataTable b= dataTable.subTable(0,4);
        List<Map<String,Double>> list2 = b.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
            VehicleResource vehicleResource = new VehicleResource();
            vehicleResource.setModel(list.get(i).get("Model"));
            vehicleResource.setBrand(list.get(i).get("Brand"));
            vehicleResource.setRegistration_plate(list.get(i).get("Registration_Plate"));
            vehicleResource.setLocation(list1.get(i).get("Location"));
            vehicleResource.setUser_Id(list2.get(i).get("User"));
            this.registerCarClientHttp.createCarro(vehicleResource);
            System.out.println( vehicleResource.getRegistration_plate());
        }
    }

    @When("envio su peticion para agregar - Carro_User")
    public void sendRequest() throws IOException {
        this.registerCarClientHttp.make();
    }

    @Then("se registro Carro")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerCarClientHttp.getResponseStatusCodes();
        System.out.println(codes);
        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0)==200);
            assertEquals(400, (int) codes.get(0));
        }
    }
}

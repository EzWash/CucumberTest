package cucumber.features;

import cucumber.http.Sprint1.RegisterCustomerHttp;
import cucumber.http.Sprint4.RegisterComment_CalificationHttp;
import cucumber.resource.accounts.UserResource;
import cucumber.resource.business.CommentResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class RegisterComment_Calification {
    private RegisterComment_CalificationHttp registerComment_calificationHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerComment_calificationHttp = new RegisterComment_CalificationHttp();
    }

    @Given("que ingreso al API {string} para agregar Comentario y Calificacion")
    public void ingressToAPI(String string) {
        this.registerComment_calificationHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar Comentario y Calificacion")
    public void ubicatedOnRoute(String string) {
        this.registerComment_calificationHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar Comentario y Calificacion")
    public void byMethod(String string) {
        this.registerComment_calificationHttp.setMethod(string);
    }

    @Given("tengo el siguiente Comentario y Calificación para agregar")
    public void getData(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        DataTable a= dataTable.subTable(0,1);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);
        for (int i = 0; i < list.size(); i++) {
            CommentResource commentResource = new CommentResource();
            commentResource.setQualification(list1.get(i).get("Qualification"));
            commentResource.setDescription(list.get(i).get("Description"));

            this.registerComment_calificationHttp.createComment(commentResource);
        }
    }

    @When("envio su peticion para agregar Comentario y Calificacion")
    public void sendRequest() throws IOException {
        this.registerComment_calificationHttp.make();
    }

    @Then("se registro Comentario y Calificacion")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerComment_calificationHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {

            assertTrue(codes.get(0) == 401);
        }
    }
}

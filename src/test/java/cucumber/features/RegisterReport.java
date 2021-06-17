package cucumber.features;

import cucumber.http.Sprint1.RegisterServiceHttp;
import cucumber.http.Sprint4.RegisterReportHttp;
import cucumber.resource.business.Contrac;
import cucumber.resource.business.ReportResource;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RegisterReport {
    private RegisterReportHttp registerReportHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.registerReportHttp = new RegisterReportHttp();
    }

    @Given("que ingreso al API {string} para crear Reporte")
    public void ingressToAPI(String string) {
        this.registerReportHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para crear Reporte")
    public void ubicatedOnRoute(String string) {
        this.registerReportHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para crear Reporte")
    public void byMethod(String string) {
        this.registerReportHttp.setMethod(string);
    }

    @Given("tengo el siguiente Reporte para crear")
    public void getData(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);



        for (int i = 0; i < list.size(); i++) {
            ReportResource reportResource = new ReportResource();
            reportResource.setDescription(list.get(i).get("Description"));

            this.registerReportHttp.createReport(reportResource);
        }
    }

    @When("envio su peticion para crear Reporte")
    public void sendRequest() throws IOException {
        this.registerReportHttp.make();
    }

    @Then("se registro Reporte")
    public void getResponseStatusCode() {
        List<Integer> codes = this.registerReportHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {

            assertEquals(401, (int) codes.get(0));
        }
    }
}

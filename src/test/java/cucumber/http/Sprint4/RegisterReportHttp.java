package cucumber.http.Sprint4;

import com.google.gson.Gson;
import cucumber.resource.business.ReportResource;
import cucumber.resource.interactions.VehicleResource;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterReportHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> reports;
    private List<Integer> responseStatusCodes;

    public RegisterReportHttp() {
        this.reports = new ArrayList<String>();
        this.responseStatusCodes = new ArrayList<Integer>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void createReport(ReportResource reportResource) throws IOException {
        Gson gson = new Gson();
        this.reports.add(gson.toJson(reportResource, ReportResource.class));
    }

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < this.reports.size(); i++) {
            RequestBody body = RequestBody.create(this.reports.get(i), mediaType);

            Request request = new Request.Builder()
                    .url(this.buildUrl())
                    .addHeader("Content-Type", "application/json")
                    .method(this.method, body)
                    .build();

            this.response = client.newCall(request).execute();
            this.responseStatusCodes.add(this.response.code());
        }
    }
    private String buildUrl() {
        return this.url + this.path;
    }

    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}

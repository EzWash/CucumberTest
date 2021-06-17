package cucumber.http.Sprint4;

import com.google.gson.Gson;
import cucumber.resource.accounts.StaffResource;
import cucumber.resource.accounts.StafffResource;
import cucumber.resource.interactions.VehicleResource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteCarClientHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> VehicleResource;
    private List<Integer> responseStatusCodes;
    public String getPath() {
        return path;
    }

    public DeleteCarClientHttp() {
        this.VehicleResource = new ArrayList<String>();
        this.responseStatusCodes = new ArrayList<Integer>();
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

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(this.buildUrl())
                .method(this.method, null)
                .build();
        this.response = client.newCall(request).execute();
    }

    public cucumber.resource.interactions.VehicleResource deleteVehicle() throws IOException {
        Gson gson = new Gson();
        ResponseBody responseBody = this.response.body();
        return gson.fromJson(responseBody.string(), VehicleResource.class);
    }

    private String buildUrl(){
        return this.url + this.path;
    }
    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}

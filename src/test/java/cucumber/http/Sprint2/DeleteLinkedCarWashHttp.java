package cucumber.http.Sprint2;

import com.google.gson.Gson;
import cucumber.resource.accounts.CarWashResource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteLinkedCarWashHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> carWashResource;
    private List<Integer> responseStatusCodes;
    public String getPath() {
        return path;
    }

    public DeleteLinkedCarWashHttp() {
        this.carWashResource = new ArrayList<String>();
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

    public CarWashResource eliminarCarWash() throws IOException {
        Gson gson = new Gson();
        ResponseBody responseBody = this.response.body();
        return gson.fromJson(responseBody.string(), CarWashResource.class);
    }

    private String buildUrl(){
        return this.url + this.path;
    }
    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}

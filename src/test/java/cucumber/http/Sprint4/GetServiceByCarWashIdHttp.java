package cucumber.http.Sprint4;

import com.google.gson.Gson;
import cucumber.resource.business.Contrac;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetServiceByCarWashIdHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> Services;
    private List<Integer> responseStatusCodes;

    public GetServiceByCarWashIdHttp() {
        this.Services = new ArrayList<String>();
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

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        for (int i = 0; i < this.Services.size(); i++) {
            RequestBody body = RequestBody.create(this.Services.get(i), mediaType);

            Request request = new Request.Builder()
                    .url(this.buildUrl())
                    .method(this.method, null)
                    .build();
            this.response = client.newCall(request).execute();
            this.responseStatusCodes.add(this.response.code());
        }
    }

    public Contrac getServices() throws IOException {
        Gson gson = new Gson();
        ResponseBody responseBody = this.response.body();
        return gson.fromJson(responseBody.string(), (Type) Contrac.class);
    }

    private String buildUrl(){
        return this.url + this.path;
    }
    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}

package cucumber.http.Sprint2;

import com.google.gson.Gson;
import cucumber.resource.accounts.CarWashResource;
import cucumber.resource.business.ServiceResource;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetCarWashHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> carwashes;
    private List<Integer> responseStatusCodes;

    public GetCarWashHttp() {
        this.carwashes = new ArrayList<String>();
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
        for (int i = 0; i < this.carwashes.size(); i++) {
            RequestBody body = RequestBody.create(this.carwashes.get(i), mediaType);

            Request request = new Request.Builder()
                    .url(this.buildUrl())
                    .method(this.method, null)
                    .build();
            this.response = client.newCall(request).execute();
            this.responseStatusCodes.add(this.response.code());
        }
    }

    public CarWashResource obtenerCarWash() throws IOException {
        Gson gson = new Gson();
        ResponseBody responseBody = this.response.body();
        return gson.fromJson(responseBody.string(), (Type) CarWashResource.class);
    }

    private String buildUrl(){
        return this.url + this.path;
    }
    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}

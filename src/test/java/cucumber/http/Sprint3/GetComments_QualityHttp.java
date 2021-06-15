package cucumber.http.Sprint3;

import com.google.gson.Gson;
import cucumber.resource.accounts.UserResource;
import cucumber.resource.business.CommentResource;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetComments_QualityHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> comments;
    private List<Integer> responseStatusCodes;

    public GetComments_QualityHttp() {
        this.comments = new ArrayList<String>();
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

    public void getComments(CommentResource commentResource) throws IOException {
        Gson gson = new Gson();
        this.comments.add(gson.toJson(commentResource, UserResource.class));
    }

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < this.comments.size(); i++) {
            RequestBody body = RequestBody.create(this.comments.get(i), mediaType);

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

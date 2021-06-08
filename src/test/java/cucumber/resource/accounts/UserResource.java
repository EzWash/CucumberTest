package cucumber.resource.accounts;

public class UserResource extends ProfileResource {
    private String password;
    private Double location;

    public Double getLocation() {
        return location;
    }

    public UserResource setLocation(Double location) {
        this.location = location;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }
}

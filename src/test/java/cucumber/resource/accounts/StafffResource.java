package cucumber.resource.accounts;


public class StafffResource {
    private Double id;

    public Double getId() {
        return id;
    }

    public StafffResource setId(Double id) {
        this.id = id;
        return this;
    }

    private String description;

    private String name;

    private String name_owner;

    private Double qualification;

    private Double available;

    private Double location;

    public Double getLocation() {
        return location;
    }

    public StafffResource setLocation(Double location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StafffResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public StafffResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getName_owner() {
        return name_owner;
    }

    public StafffResource setName_owner(String name_owner) {
        this.name_owner = name_owner;
        return this;
    }

    public Double getQualification() {
        return qualification;
    }

    public StafffResource setQualification(Double qualification) {
        this.qualification = qualification;
        return this;
    }

    public Double getAvailable() {
        return available;
    }

    public StafffResource setAvailable(Double available) {
        this.available = available;
        return this;
    }


}

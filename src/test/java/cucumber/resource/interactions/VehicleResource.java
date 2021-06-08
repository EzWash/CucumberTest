package cucumber.resource.interactions;



public class VehicleResource {

    private String model;
    private String brand;
    private String registration_plate;
    private Double location;
    private Double user;

    public Double getUser() {
        return user;
    }

    public VehicleResource setUser(Double user) {
        this.user = user;
        return this;
    }

    public Double getUser_Id() {
        return user_Id;
    }

    public Double getLocation() {
        return location;
    }

    public VehicleResource setLocation(Double location) {
        this.location = location;
        return this;
    }

    public VehicleResource setUser_Id(Double user_Id) {
        this.user_Id = user_Id;
        return this;
    }

    private Double user_Id;

    public String getModel() {
        return model;
    }

    public VehicleResource setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VehicleResource setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getRegistration_plate() {
        return registration_plate;
    }

    public VehicleResource setRegistration_plate(String registration_plate) {
        this.registration_plate = registration_plate;
        return this;
    }


}

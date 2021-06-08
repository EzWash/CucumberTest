package cucumber.resource.business;

public class ServiceResource {
    private Long id;
    private String name;
    private String description;
    private Double is_promotion;
    private Double price;
    private String details;

    public Long getId() {
        return id;
    }

    public ServiceResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ServiceResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ServiceResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getIs_promotion() {
        return is_promotion;
    }

    public ServiceResource setIs_promotion(Double is_promotion) {
        this.is_promotion = is_promotion;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ServiceResource setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ServiceResource setDetails(String details) {
        this.details = details;
        return this;
    }
}

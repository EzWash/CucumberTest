package cucumber.resource.business;

public class Contrac {
    private Long id;
    private String name;
    private String description;
    private Double is_promotion;
    private Double price;
    private String details;

    public Long getId() {
        return id;
    }

    public Contrac setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contrac setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contrac setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getIs_promotion() {
        return is_promotion;
    }

    public Contrac setIs_promotion(Double is_promotion) {
        this.is_promotion = is_promotion;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Contrac setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Contrac setDetails(String details) {
        this.details = details;
        return this;
    }
}

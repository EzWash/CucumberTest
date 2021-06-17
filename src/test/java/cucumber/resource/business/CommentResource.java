package cucumber.resource.business;

public class CommentResource {
    private Long id;
    private String description;
    private Double qualification;

    public Long getId() {
        return id;
    }

    public CommentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommentResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getQualification() {
        return qualification;
    }

    public CommentResource setQualification(Double qualification) {
        this.qualification = qualification;
        return this;
    }
}

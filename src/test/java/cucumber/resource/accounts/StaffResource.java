package cucumber.resource.accounts;

public class StaffResource extends ProfileResource {
    private Long carWashId;

    public Long getCarWashId() {
        return carWashId;
    }

    public StaffResource setCarWashId(Long carWashId) {
        this.carWashId = carWashId;
        return this;
    }
}

package cucumber.resource.business;

import java.util.Date;

public class ContractResource {

    private Long service_id;
    private Long customer_id;
    private Date date;
    private Long staff_id;
    private String state;

    public String getState() {
        return state;
    }

    public ContractResource setState(String state) {
        this.state = state;
        return this;
    }

    public Long getService_id() {
        return service_id;
    }

    public ContractResource setService_id(Long service_id) {
        this.service_id = service_id;
        return this;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public ContractResource setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ContractResource setDate(Date date) {
        this.date = date;
        return this;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public ContractResource setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
        return this;
    }

}

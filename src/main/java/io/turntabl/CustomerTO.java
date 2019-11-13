package io.turntabl;

public class CustomerTO {
    private String company_name;
    private Integer customer_id;
    private String contact_name;
    private String city;

    public CustomerTO(String company_name, Integer customer_id, String contact_name, String city) {
        this.company_name = company_name;
        this.customer_id = customer_id;
        this.contact_name = contact_name;
        this.city = city;
    }

    public String getCompany_name() {
        return company_name;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getCity() {
        return city;
    }
}

package com.example.krishanasony.e_billing;

/**
 * Created by Krishana Sony on 31-03-2018.
 */

public class ModelHistory {
    public ModelHistory() {
    }
    private String billing_date,consumer_name,  service_number,total_amount;

    public String getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(String billing_date) {
        this.billing_date = billing_date;
    }

    public String getConsumer_name() {
        return consumer_name;
    }

    public void setConsumer_name(String consumer_name) {
        this.consumer_name = consumer_name;
    }

    public String getService_number() {
        return service_number;
    }

    public void setService_number(String service_number) {
        this.service_number = service_number;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public ModelHistory(String billing_date, String consumer_name, String service_number, String total_amount) {
        this.billing_date = billing_date;
        this.consumer_name = consumer_name;
        this.service_number = service_number;
        this.total_amount = total_amount;
    }
}

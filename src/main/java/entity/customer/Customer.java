package entity.customer;

import entity.cargo.Cargo;
import entity.user.forwarder.Forwarder;
import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private String name;
    private String country;
    private String city;
    private String address;
    private String contactPerson;
    private String phone1;
    private String phone2;
    private String fax;
    private String status;
    private String note;
    private CustomerBankAccount customerBankAccount;
    private List<CustomerContract> customerContracts;
    private List<Forwarder> forwarders;
    private List<Cargo> cargoList;
}

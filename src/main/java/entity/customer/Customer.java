package entity.customer;

import entity.cargo.Cargo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Embedded
    private CustomerInfo customerInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private List<CustomerNotes> notes;

    @Transient
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private CustomerBankAccount customerBankAccount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private List<CustomerContract> customerContracts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private List<Cargo> cargoList;

//    @ManyToMany
//    private List<Forwarder> forwarders;


    public Customer() {
        this.status = "active";
    }
}

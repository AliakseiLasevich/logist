package entity.customer;

import entity.cargo.Cargo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
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


    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    @LazyToOne(value = LazyToOneOption.NO_PROXY)
    private CustomerInfo customerInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private List<CustomerNotes> notes;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private CustomerBankAccount customerBankAccount;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    @LazyToOne(value = LazyToOneOption.NO_PROXY)
    private List<CustomerContract> customerContracts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    private List<Cargo> cargoList;

//    @ManyToMany
//    private List<Forwarder> forwarders;


}

package entity.customer;

import entity.cargo.Cargo;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
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

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cargo> cargoList;

    public Customer() {
        this.status = "active";
    }

    @Override
    public String toString() {
        return "Customer #"
                + id
                + ", "
                + name;
    }
}

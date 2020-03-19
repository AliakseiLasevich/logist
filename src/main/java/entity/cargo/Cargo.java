package entity.cargo;

import entity.customer.Customer;
import entity.transfer.Transfer;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "transfer")
    private Transfer transfer;

    @Embedded
    private CargoInfo cargoInfo;

    @Override
    public String toString(){
        return "Cargo #"
                +id
                + ", "
                +description
                + ", customer: "
                +customer.getName();
    }

}

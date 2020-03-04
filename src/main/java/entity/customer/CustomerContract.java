package entity.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "customer_contract")
@Entity
public class CustomerContract {


    @Id
    @Column(name = "id_customer_contract")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contract")
    private String contractNumber;

}

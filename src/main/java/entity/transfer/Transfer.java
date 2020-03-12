package entity.transfer;

import entity.cargo.Cargo;
import entity.partner.Partner;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfer")
    private int id;

    @ManyToOne
    @JoinColumn(name = "partner")
    private Partner partner;

    @OneToMany(mappedBy = "transfer")
    private List<Cargo> cargos;

    @Column(name = "price")
    private int price;
}

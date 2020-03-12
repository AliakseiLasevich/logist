package entity.transfer;

import entity.cargo.Cargo;
import entity.partner.Partner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfer")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner")
    private Partner partner;

    @OneToMany(mappedBy = "transfer", fetch = FetchType.EAGER)
    private List<Cargo> cargos;

    @Column(name = "price")
    private int price;
}

package entity.cargo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    @Embedded
    private Cargoinfo cargoinfo;






}

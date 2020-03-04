package entity.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "customer_notes")
@Entity
public class CustomerNotes {

    @Id
    @Column(name = "id_customer_note")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "note")
    private String note;
}

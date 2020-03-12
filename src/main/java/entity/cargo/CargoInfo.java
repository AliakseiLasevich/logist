package entity.cargo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class CargoInfo {

    @Column(name = "code")
    private int code;

    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private double weight;

    @Column(name = "ldm")
    private double ldm;

    @Column(name = "departure_country")
    private String departureCountry;

    @Column(name = "destination_country")
    private String destinationCountry;
}

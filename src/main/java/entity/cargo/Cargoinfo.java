package entity.cargo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Cargoinfo {

    @Column(name = "code")
    private int code;

    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @Column(name = "width")
    private double width;

    @Column(name = "depth")
    private double depth;

    @Column(name = "ldm")
    private double ldm;

    @Column(name = "departure_country")
    private String departureCountry;

    @Column(name = "destination_country")
    private String destinationCountry;
}

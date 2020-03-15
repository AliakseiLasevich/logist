package entity.authorities;

import entity.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "id_authority")
    private int id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "username")
    private String userName;

    @OneToOne
    @JoinColumn(name = "id_authority")
    private User user;

    public Authorities(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }
}

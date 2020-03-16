package entity.authorities;

import entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_authority")
    private int id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "username")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Authorities(User user, String userName, String authority) {
        this.user=user;
        this.userName = userName;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return authority;
    }
}

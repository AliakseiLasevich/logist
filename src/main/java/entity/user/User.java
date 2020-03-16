package entity.user;

import entity.authorities.Authorities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Size(min=3, message = "Min 3 symbols")
    @NotNull(message = "*Not null")
    @NotEmpty
    @Column(name = "username")
    private String username;

    @Size(min=3, message = "Min 3 symbols")
    @NotNull(message = "*Not null")
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Authorities> authorities;

    public User() {
        this.enabled = true;
    }
}

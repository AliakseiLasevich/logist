package entity.user;

import entity.authorities.Authorities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Authorities authority;

    public User() {
        this.enabled = true;
    }
}

package Infra.Persistence.SQL.Models;

import Domain.Entities.Users.Role;
import Domain.Entities.Users.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    private String cpf;
    private String name;
    private String password;
    private String email;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;
    private String phoneNumber;
//    @Embedded
//    private Cart cart;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String tokenEmail;
    private boolean validated;
    private String tokenPassword;
    private LocalDateTime expirationDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role.equals(Role.ADMIN)) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_COMUM"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

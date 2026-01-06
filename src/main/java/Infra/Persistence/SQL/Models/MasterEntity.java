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

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "masters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterEntity implements UserDetails {

    @Id
    private String cpf;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_COMUM"), new SimpleGrantedAuthority("ROLE_MASTER"));
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

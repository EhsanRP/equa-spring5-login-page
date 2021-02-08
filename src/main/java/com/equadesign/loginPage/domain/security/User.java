package com.equadesign.loginPage.domain.security;

import lombok.*;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String username;
    private String password;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE} , fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Role",
            joinColumns = {
                    @JoinColumn(name = "User_Id", referencedColumnName = "id"),},
            inverseJoinColumns = {
                    @JoinColumn(name = "Role_Id", referencedColumnName = "id")})
    private Set<Role> roles;

    @ManyToOne(fetch = FetchType.EAGER)

    @Transient
    public Set<GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .map(authority -> { return new SimpleGrantedAuthority(authority.getPermission()); })
                .collect(Collectors.toSet());
    }

    @Builder.Default
    private Boolean accountNonExpired = true;

    @Builder.Default
    private Boolean accountNonLocked = true;

    @Builder.Default
    private Boolean credentialsNonExpired = true;

    @Builder.Default
    private Boolean enabled = true;

    @Override
    public void eraseCredentials() {
        this.setPassword(null);
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}

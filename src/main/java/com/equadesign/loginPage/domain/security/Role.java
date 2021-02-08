package com.equadesign.loginPage.domain.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Role_Authority",
            joinColumns = {
                    @JoinColumn(name = "Role_Id", referencedColumnName = "id"),},
            inverseJoinColumns = {
                    @JoinColumn(name = "Authority_Id", referencedColumnName = "id")})
    private Set<Authority> authorities;

}


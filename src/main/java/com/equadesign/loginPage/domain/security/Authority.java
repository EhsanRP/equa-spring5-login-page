package com.equadesign.loginPage.domain.security;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String permission;

    @Singular
    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;
}

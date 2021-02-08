package com.equadesign.loginPage.repositories;

import com.equadesign.loginPage.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

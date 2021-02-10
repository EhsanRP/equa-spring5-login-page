package com.equadesign.loginPage.repositories;

import com.equadesign.loginPage.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}

package com.equadesign.loginPage.repositories;

import com.equadesign.loginPage.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

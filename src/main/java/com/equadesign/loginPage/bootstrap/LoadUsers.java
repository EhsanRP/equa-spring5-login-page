package com.equadesign.loginPage.bootstrap;

import com.equadesign.loginPage.domain.security.Role;
import com.equadesign.loginPage.domain.security.User;
import com.equadesign.loginPage.repositories.AuthorityRepository;
import com.equadesign.loginPage.repositories.RoleRepository;
import com.equadesign.loginPage.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LoadUsers implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        var adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
        var adminUser = User.builder().username("admin").password(passwordEncoder.encode("admin")).role(adminRole).build();
        userRepository.save(adminUser);
    }


}

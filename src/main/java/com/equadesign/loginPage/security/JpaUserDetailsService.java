package com.equadesign.loginPage.security;

import com.equadesign.loginPage.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        log.debug(" -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* Getting Users Via JPA User Details Service");

        return userRepository.findByUsername(userName).orElseThrow(() -> {
            return new UsernameNotFoundException("User " + userName + "Not Found");
        });
    }
}

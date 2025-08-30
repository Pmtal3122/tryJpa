package com.piyush.tryJpa.tryJpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("user")) {
            return User.withUsername("user")
                    .password(bCryptPasswordEncoder.encode("pass"))
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

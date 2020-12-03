package com.hivecloud.reading.service;

import com.hivecloud.reading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    public UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.hivecloud.reading.domain.persistence.User applicationUser = repository.findByLogin(login);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(applicationUser.getLogin(), applicationUser.getPassword(), emptyList());
    }
}

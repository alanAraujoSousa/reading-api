package com.hivecloud.reading.service;

import com.hivecloud.reading.domain.dto.v1.CreateUserV1DTO;
import com.hivecloud.reading.domain.persistence.User;
import com.hivecloud.reading.exceptions.UserNotFoundException;
import com.hivecloud.reading.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository repository;

    public User get(String login) {
        return repository.findByLogin(login);
    }

    public User get(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Long register(CreateUserV1DTO dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return repository.save(user).getId();
    }
}

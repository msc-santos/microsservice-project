package com.msdev.hr_user.services;

import com.msdev.hr_user.entities.User;
import com.msdev.hr_user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

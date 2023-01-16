package com.example.spring_security_exe.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

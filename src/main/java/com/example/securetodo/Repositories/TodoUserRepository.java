package com.example.securetodo.Repositories;

import com.example.securetodo.Models.TodoUser;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface TodoUserRepository extends JpaRepository<TodoUser, Long> {

    TodoUser findByUsername(String username);
   // TodoUser findByName (String username);
}

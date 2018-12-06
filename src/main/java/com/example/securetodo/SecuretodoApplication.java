package com.example.securetodo;

import com.example.securetodo.Models.TodoUser;
import com.example.securetodo.Repositories.TodoUserRepository;
import com.example.securetodo.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecuretodoApplication implements CommandLineRunner {

    @Autowired
    TodoUserRepository todoUserRepository;
    @Autowired
    PasswordEncoder encoder;

    public static void main(String[] args) {

        SpringApplication.run(SecuretodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoUserRepository.save(new TodoUser("admin", encoder.encode("heslo")));
    }
}

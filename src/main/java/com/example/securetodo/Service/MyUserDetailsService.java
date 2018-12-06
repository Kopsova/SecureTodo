package com.example.securetodo.Service;

import com.example.securetodo.Models.MyUserPrincipal;
import com.example.securetodo.Repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import com.example.securetodo.Models.TodoUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TodoUserRepository todoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        TodoUser user = todoUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}

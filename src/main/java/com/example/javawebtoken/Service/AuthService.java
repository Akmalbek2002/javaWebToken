package com.example.javawebtoken.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Lazy

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList=new ArrayList<>(
                Arrays.asList(
                        new User("Akmal625",passwordEncoder.encode("12345678"),new ArrayList<>()),
                        new User("Wwww",passwordEncoder.encode("www004"),new ArrayList<>()),
                        new User("Ssss",passwordEncoder.encode("sss005"),new ArrayList<>()),
                        new User("Rrrr",passwordEncoder.encode("rrr006"),new ArrayList<>())
                )
        );

        for (User user : userList) {
            if(user.getUsername().equals(username)){
                return  user;
            }
        }
        throw  new UsernameNotFoundException("userName topilmadi");
    }
}

package com.example.security.repo;

import com.example.security.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepoData repoData;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StudentEntity foundedStudent = repoData
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user cloud not found"));

        return new LoggedInStudent(foundedStudent,
                foundedStudent.getEmail(),
                foundedStudent.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("admin")));


    }
}

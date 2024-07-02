package com.example.security.repo;

import com.example.security.entity.StudentEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoggedInStudent extends User {

    private final StudentEntity student;

    public LoggedInStudent(StudentEntity student, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.student = student;
    }

    public StudentEntity getStudent() {
        return student;
    }
}

package com.example.security.repo;

import com.example.security.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepoData extends JpaRepository<StudentEntity, Integer> {

    Optional<StudentEntity> findByEmail(String email);

}
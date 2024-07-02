package com.example.security.repo;

import com.example.security.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepoData extends JpaRepository<University, Integer> {


}

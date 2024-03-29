package com.allesCoders.school.repository;

import com.allesCoders.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    @Override
    Optional<Student> findById(Long id);

    Optional<Student> findByEmail(String email);
}

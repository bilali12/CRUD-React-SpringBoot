package com.allesCoders.school.service;

import com.allesCoders.school.entity.Student;
import com.allesCoders.school.exception.StudentAlreadyExistsException;
import com.allesCoders.school.exception.StudentNotFoundException;
import com.allesCoders.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService{
    private final StudentRepository repository;
    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExists(student.getEmail())) {
            throw new StudentAlreadyExistsException("Student already exists...");
        }
        return repository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = repository.findById(id);
        return student.orElseThrow(() -> new StudentNotFoundException("Student not found"));

    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> stud = repository.findById(id);
        if(stud.isPresent()) {
            student.setId(id);
            return repository.save(student);
        }else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> stud = repository.findById(id);
        if(stud.isPresent()) {
            repository.deleteById(id);
        }else {
            throw new StudentNotFoundException("Student not found");
        }
    }

    private boolean studentAlreadyExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}

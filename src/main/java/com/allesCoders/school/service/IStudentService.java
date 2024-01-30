package com.allesCoders.school.service;


import com.allesCoders.school.entity.Student;
import com.allesCoders.school.exception.StudentAlreadyExistsException;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student) throws StudentAlreadyExistsException;
    List<Student> getStudents();
    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}

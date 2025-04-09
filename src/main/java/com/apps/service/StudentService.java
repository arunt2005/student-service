package com.apps.service;

import com.apps.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    boolean deleteStudent(Long id);
}

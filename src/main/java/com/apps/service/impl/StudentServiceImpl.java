package com.apps.service.impl;

import com.apps.dto.StudentDTO;
import com.apps.mapper.StudentMapper;
import com.apps.entity.Student;
import com.apps.repository.StudentRepository;
import com.apps.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student saved = studentRepository.save(student);
        return studentMapper.toDTO(saved);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> studentOpt = studentRepository.findById(id);
        return studentOpt.map(studentMapper::toDTO).orElse(null);
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) return null;

        Student existing = optionalStudent.get();
        existing.setName(studentDTO.getName());
        existing.setAge(studentDTO.getAge());
        existing.setEmail(studentDTO.getEmail());

        Student updated = studentRepository.save(existing);
        return studentMapper.toDTO(updated);
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) return false;
        studentRepository.deleteById(id);
        return true;
    }
}

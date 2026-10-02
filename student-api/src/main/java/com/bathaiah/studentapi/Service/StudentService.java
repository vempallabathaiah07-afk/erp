package com.bathaiah.studentapi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bathaiah.studentapi.Entity.Student;
import com.bathaiah.studentapi.Repository.StudentRepository;
import com.bathaiah.studentapi.exception.DuplicateRegisterNumberException;
import com.bathaiah.studentapi.exception.StudentNotFoundException;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));
    }

    public Student addStudent(Student student) {

        if (repository.existsByRegisterNo(student.getRegisterNo())) {
            throw new DuplicateRegisterNumberException(
                    "Register number already exists");
        }

        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {

        Student existing = getStudentById(id);

        if (!existing.getRegisterNo().equals(student.getRegisterNo())
                && repository.existsByRegisterNo(student.getRegisterNo())) {

            throw new DuplicateRegisterNumberException(
                    "Register number already exists");
        }

        existing.setRegisterNo(student.getRegisterNo());
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setDepartment(student.getDepartment());
        existing.setYear(student.getYear());
        existing.setSemester(student.getSemester());

        return repository.save(existing);
    }

    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        repository.delete(student);
    }

    public List<Student> searchByName(String name) {

        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Student> searchByRegisterNo(String registerNo) {

        return repository.findByRegisterNoContainingIgnoreCase(registerNo);
    }
}
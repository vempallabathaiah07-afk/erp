package com.bathaiah.studentapi.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bathaiah.studentapi.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRegisterNo(String registerNo);

    List<Student> findByNameContainingIgnoreCase(String name);

    List<Student> findByRegisterNoContainingIgnoreCase(String registerNo);

    List<Student> findByDepartmentIgnoreCase(String department);

    List<Student> findByYear(Integer year);

    List<Student> findBySemester(Integer semester);

    boolean existsByRegisterNo(String registerNo);
}
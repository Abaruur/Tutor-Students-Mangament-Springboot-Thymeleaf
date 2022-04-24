package com.app.ELearning.DAO;

import com.app.ELearning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
    Optional<Student> findStudentByUsernameAndPassword(String username, String password);

    Optional<Student> findStudentsByUsername(String username);

    @Query(value = "select * from Student", nativeQuery = true)
    List<Student> findAllStudents();
}

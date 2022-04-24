package com.app.ELearning;

import com.app.ELearning.entity.Student;
import com.app.ELearning.DAO.StudentDAO;
import com.app.ELearning.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class StudentDAOTest {

    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentDAO studentRepository;

    @Test
    public void createStudentTest() {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Kalid");
        student.setPassword("12345");
        student.setUsername("Khalid");

        when(studentRepository.save(student)).thenReturn(student);
        assertEquals(student, studentService.save(student));
    }


    @Test
    public void listOfStudentsTest() {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("James");
        student.setPassword("12345");
        student.setUsername("james");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        when(studentRepository.findAllStudents()).thenReturn(studentList);
        assertEquals(studentList, studentService.list());
    }
}

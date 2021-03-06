package com.app.ELearning;

import com.app.ELearning.entity.Tutor;
import com.app.ELearning.DAO.TutorDAO;
import com.app.ELearning.service.TutorService;
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
class TutorDAOTest {

    @Autowired
    private TutorService tutorService;
    @MockBean
    private TutorDAO tutorRepository;

    @Test
    public void createTutorTest() {
        Tutor tutor = new Tutor();
        tutor.setTutorId(1);
        tutor.setTutorName("Imran");
        tutor.setUsername("imran");
        tutor.setPassword("12345");

        when(tutorRepository.save(tutor)).thenReturn(tutor);
        assertEquals(tutor, tutorService.save(tutor));
    }

    @Test
    public void listOfTutorsTest() {
        Tutor tutor = new Tutor();
        tutor.setTutorId(1);
        tutor.setTutorName("Devid");
        tutor.setUsername("devid");
        tutor.setPassword("12345");

        List<Tutor> tutorsList = new ArrayList<>();
        tutorsList.add(tutor);

        when(tutorRepository.findAllTutors()).thenReturn(tutorsList);
        assertEquals(tutorsList, tutorService.list());
    }
}

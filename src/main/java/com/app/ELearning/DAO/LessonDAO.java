package com.app.ELearning.DAO;

import com.app.ELearning.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Integer> {
    @Query(value = "select * from Lesson", nativeQuery = true)
    List<Lesson> findAllLessons();
}

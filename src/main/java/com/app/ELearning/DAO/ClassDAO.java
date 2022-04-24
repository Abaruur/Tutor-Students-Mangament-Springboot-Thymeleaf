package com.app.ELearning.DAO;

import com.app.ELearning.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDAO extends JpaRepository<Class, Integer> {
    @Query(value = "select * from Class", nativeQuery = true)
    List<Class> findAllClasses();
}

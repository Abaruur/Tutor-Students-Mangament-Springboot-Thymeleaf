package com.app.ELearning.service;

import com.app.ELearning.entity.Class;
import com.app.ELearning.DAO.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassDAO classRepository;

    @Autowired
    public ClassService(ClassDAO classRepository) {
        this.classRepository = classRepository;
    }

    public Class save(Class classObject) {
        return classRepository.save(classObject);
    }

    public List<Class> list() {
        return classRepository.findAllClasses();
    }

    public void delete(Integer classId) {
        Optional<Class> classOptional = classRepository.findById(classId);
        if (classOptional.isPresent()) {
            classRepository.delete(classOptional.get());
        }
    }

    public Optional<Class> getClassById(Integer classId) {
        return classRepository.findById(classId);
    }
}

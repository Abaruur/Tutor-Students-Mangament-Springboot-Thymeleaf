package com.app.ELearning.controller;

import com.app.ELearning.DAO.AdminDAO;
import com.app.ELearning.DAO.StudentDAO;
import com.app.ELearning.DAO.TutorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminDAO adminRepository;
    @Autowired
    TutorDAO tutorRepository;
    @Autowired
    StudentDAO studentRepository;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin_dashboard";
    }

    @GetMapping("/all_students")
    public String getAllStudents(Model model) {
        model.addAttribute("studentsList", studentRepository.findAll());
        return "admin_all_students";
    }

    @GetMapping("/all_tutors")
    public String getAllTutors(Model model) {
        model.addAttribute("tutorsList", tutorRepository.findAll());
        return "admin_all_tutors";
    }
}

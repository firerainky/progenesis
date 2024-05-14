package com.zky.progenesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zky.progenesis.model.Student;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class StudentController {
    
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {
        
        log.info("The student: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
    
}

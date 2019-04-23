package com.example.demo.service;

import com.example.demo.model.Groupa;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.acl.Group;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupService groupService;

    @PostConstruct
    void init(){
        List<Groupa> groups= groupService.getAll();
        List<Student> students= new ArrayList<Student>(
                Arrays.asList(
                        new Student("st1", groups.get(0)),
                        new Student("st2", groups.get(0))
                )
        );

        // LocalDateTime before= LocalDateTime.now();
        // System.out.println(this.getDistinctGroupCount());
        // LocalDateTime after= LocalDateTime.now();
        // System.out.println(Duration.between(before,after).getNano());

    }

    long getDistinctGroupCount(){
        return  studentRepository.findAll().stream()
                .mapToInt(s -> s.getGroup().getId())
                .distinct()
                .count();

    }
}

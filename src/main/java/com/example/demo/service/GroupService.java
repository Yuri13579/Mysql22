package com.example.demo.service;

import com.example.demo.model.Groupa;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepository repository;

    private static List<Groupa> groups= new ArrayList<>(
            Arrays.asList(
                    new Groupa("bbv171", "vova"),
                    new Groupa("bbv172", "Anya"),
                    new Groupa("bbv173", "vova"),
                    new Groupa("bbv174", "Vova"),
                    new Groupa("sbu171", "Maks")
            )
    );

    @PostConstruct
    void init(){
        if (repository.count() ==0)
        repository.saveAll(groups);
    }

    Group get(Integer id){
        return (Group) repository.findById(id).orElse(null);
    }

    List<Groupa> getAll(){
        return repository.findAll();
    }


}

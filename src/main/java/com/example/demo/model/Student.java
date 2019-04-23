package com.example.demo.model;

import javax.persistence.*;
import java.security.acl.Group;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Groupa groupa;

    public Student() {
    }

    public Student(String name, Groupa groupa) {
        this.name = name;
        this.groupa = groupa;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Groupa getGroup() {
        return groupa;
    }

    public void setGroupa(Groupa groupa) {
        this.groupa = groupa;
    }
}

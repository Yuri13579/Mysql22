package com.example.demo.repository;

import com.example.demo.model.Groupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groupa,Integer> {
}

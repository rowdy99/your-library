package com.example.subham.repository;


import com.example.subham.model.Computer;
import com.example.subham.model.Engineering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineeringRepo  extends JpaRepository<Engineering,Integer> {
    public List<Engineering> findAllByBookNameContaining(String name);
}

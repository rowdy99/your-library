package com.example.subham.repository;

import com.example.subham.model.Biological;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiologicalRepo extends JpaRepository<Biological,Integer> {
    public List<Biological> findAllByBookNameContaining(String name);
}

package com.example.subham.repository;

import com.example.subham.model.Chemistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemistryRepo extends JpaRepository<Chemistry,Integer> {
    public List<Chemistry> findAllByBookNameContaining(String name);
}

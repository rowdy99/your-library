package com.example.subham.repository;



import com.example.subham.model.Science;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScienceRepo extends JpaRepository<Science,Integer> {
    public List<Science> findAllByBookNameContaining(String name);
}

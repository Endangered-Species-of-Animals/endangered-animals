package com.esoa.demo.repository;

import com.esoa.demo.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<Park,Integer> {

    boolean existsByName(String name);
}

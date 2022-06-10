package com.esoa.demo.repository;

import com.esoa.demo.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<Park,Integer> {


    boolean existsByNameAndDescription(String name, String description);

    @Modifying
    @Query("UPDATE Park a SET a.deleted = false WHERE a.id = ?1")
    void enableById(Integer id);


}

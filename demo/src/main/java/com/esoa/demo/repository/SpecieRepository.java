
package com.esoa.demo.repository;


import com.esoa.demo.entity.Specie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecieRepository  extends JpaRepository<Specie,Integer> {
    
}

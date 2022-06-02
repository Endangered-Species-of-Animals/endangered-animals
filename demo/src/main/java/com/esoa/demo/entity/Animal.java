package com.esoa.demo.entity;

import com.esoa.demo.enumeration.Category;
import java.time.LocalDate;


public class Animal {
    private int id;
    private String name;
    private String scientific_name;
    private String description;
    private LocalDate dischargeDate;
    private Category category;
    private Specie specie;
    private String image;
    private boolean deleted;
    
    
}

package com.esoa.demo.entity;

import java.time.LocalDate;
import java.util.List;


public class Publication {
    private int id;
    private String description;
    private LocalDate dischargeDate;
    private Animal animal;
    private List<Valoration> valoration;
    private boolean deleted;
    
}

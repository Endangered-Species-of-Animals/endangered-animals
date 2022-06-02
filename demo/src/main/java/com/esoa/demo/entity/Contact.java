package com.esoa.demo.entity;

import java.time.LocalDate;

public class Contact {
    private int id;
    private LocalDate dischargeDate;
    private User user;
    private String description;
    private boolean deleted;
}

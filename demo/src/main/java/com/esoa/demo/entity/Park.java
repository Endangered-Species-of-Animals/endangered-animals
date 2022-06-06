package com.esoa.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "park")
//@SQLDelete(sql = "UPDATE park SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    @Column(name = "name", nullable = false)
    private String name;
    private String location;
    private String position;
    @Lob
    @Column(name = "description", columnDefinition="CLOB")
    private String description;
    private String link;
    private boolean deleted;
    
    
}

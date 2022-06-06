package com.esoa.demo.entity;

import com.esoa.demo.enumeration.Category;
import java.time.LocalDate;
import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@Table(name = "animal", indexes = {@Index(name = "idx_email", columnList = "email")})
//@SQLDelete(sql = "UPDATE animal SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private String scientific_name;
    @Lob
    @Column(name = "post_description", columnDefinition="CLOB", nullable = false)
    private String description;
    @Column(name = "discharge_date")
    private LocalDate dischargeDate;
    @Enumerated(STRING)
    @Column(name = "category", nullable = false)
    private Category category;
    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "specie", referencedColumnName = "id", nullable = false)
    private Specie specie;
    @Column(name = "image")
    private String image;
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    
    
}

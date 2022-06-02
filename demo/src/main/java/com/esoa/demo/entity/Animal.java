package com.esoa.demo.entity;

import com.esoa.demo.enumeration.Category;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Enumerated;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@Table(name = "animal")
@SQLDelete(sql = "UPDATE animal SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 20)
    private String name;
    private String scientific_name;
    @Lob
    private String description;
    @Column(name = "dischar_date")
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

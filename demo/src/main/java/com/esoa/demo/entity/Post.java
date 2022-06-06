package com.esoa.demo.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "post")
@SQLDelete(sql = "UPDATE post SET deleted = true WHERE id = ?")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(name = "post_description", columnDefinition="CLOB", nullable = false)
    private String description;
    @Column(name = "discharge_date")
    private LocalDate dischargeDate;
    @OneToOne(fetch = FetchType.EAGER)
    private Animal animal;
    @OneToMany(mappedBy = "id")
    private List<Valoration> valoration;
    private boolean deleted;
    
}

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
    private Integer id;
    @Lob
    @Column(name = "post_description", nullable = false)
    private String description;
    @Column(name = "post_discharge_date")
    private LocalDate dischargeDate;
    @OneToOne(fetch = FetchType.EAGER)
    private Animal animal;
    @OneToOne(fetch = FetchType.EAGER)
    private Park park;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Valoration> valoration;
    @Column(name = "post_deleted")
    private boolean deleted;
    
}

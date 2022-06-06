package com.esoa.demo.entity;

import com.esoa.demo.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_nickname", nullable = false)
    private String nickname;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_lastname", nullable = false)
    private String lastName;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "user_role", nullable = false)
    private Role role;
    @Column(name = "user_deleted", nullable = false)
    private boolean deleted;
}

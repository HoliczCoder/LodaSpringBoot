package com.lodatutorial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

}

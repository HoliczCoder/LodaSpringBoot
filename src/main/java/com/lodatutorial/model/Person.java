package com.lodatutorial.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn (name = "address_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Address address;



}

package com.lodatutorial.model;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String province;

    public Collection<Person> getPersons() {
        return persons;
    }


//    public void setPersons(Person persons) {
//        this.persons.add(persons);
//    }

    @OneToMany (mappedBy = "address", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Person> persons;

}

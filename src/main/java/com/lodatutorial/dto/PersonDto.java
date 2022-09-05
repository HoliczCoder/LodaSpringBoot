package com.lodatutorial.dto;

import com.lodatutorial.model.Address;
import com.lodatutorial.model.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private AddressDto address;

    public PersonDto(Person p){
        this.id = p.getId();
        this.name = p.getName();
        this.address = new AddressDto(p.getAddress());
    }

}

package com.lodatutorial.dto;

import com.lodatutorial.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String city;
    private String province;

    public  AddressDto(Address a){
        this.id = a.getId();
        this.city = a.getCity();
        this.province = a.getProvince();
    }
}

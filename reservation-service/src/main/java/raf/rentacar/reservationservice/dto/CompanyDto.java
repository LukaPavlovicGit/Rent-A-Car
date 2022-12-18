package raf.rentacar.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long managerId;
    private String name;
    private String city;
    private String description;

    public CompanyDto(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }
}

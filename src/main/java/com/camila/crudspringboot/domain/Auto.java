package com.camila.crudspringboot.domain;

import com.camila.crudspringboot.dto.AutoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "auto")
@Table(name = "auto")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String brand;

    private String model;

    private Integer price_in_cents;

    private Boolean active;

    public Auto(AutoDTO autoDTO) {
        this.brand = autoDTO.brand();
        this.model = autoDTO.model();
        this.price_in_cents = autoDTO.price_in_cents();
        this.active = true;
    }
}

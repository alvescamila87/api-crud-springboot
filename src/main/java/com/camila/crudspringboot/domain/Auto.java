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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String makeBrand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer price_in_cents;

    public Auto(AutoDTO autoDTO) {
        this.makeBrand = makeBrand;
        this.model = model;
        this.price_in_cents = price_in_cents;
    }
}

package com.app.car_rental_backend.domain;

import lombok.*;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "carId")
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private String color;

    @NotNull
    private Integer yearOfProduction;

    @NotNull
    private Long basicPrice;

    @NotNull
    @ManyToOne
    @JoinColumn(name =  "categoryId")
    private Category category;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "car",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Rent> rents;

    @ManyToMany
    private List<Search> searches = new ArrayList<>();

}

package com.thorben.janssen.sample.model;

import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@Table(name = "car_info")
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Any(
            metaDef = "CarMetaDef",
            metaColumn = @Column(name = "car_type")
    )
    @JoinColumn(name = "car_id")
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

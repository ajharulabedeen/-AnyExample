package com.thorben.janssen.sample.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ride_sharing")
public class RideSharing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToAny(
            metaDef = "CarMetaDef",
            metaColumn = @Column(name = "car_type")
    )
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(name = "ride_sharing_cars",
            joinColumns = @JoinColumn(name = "ride_sharing_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars = new ArrayList<>();

    public RideSharing() {
    }

    public RideSharing(int id, String name, List<Car> students) {
        this.id = id;
        this.name = name;
        this.cars = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

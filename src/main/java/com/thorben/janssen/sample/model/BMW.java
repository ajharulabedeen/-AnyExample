package com.thorben.janssen.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "bmw")
public class BMW implements Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "driver_name")
    private String driverName;
    @Column(name = "max_passenger")
    private int maxPassenger;

    public BMW() {
    }

    public BMW(int id, String model, String driverName, int maxPassenger) {
        this.id = id;
        this.model = model;
        this.driverName = driverName;
        this.maxPassenger = maxPassenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public int getMaxPassenger() {
        return maxPassenger;
    }

    public void setMaxPassenger(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }
}

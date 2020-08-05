package com.app.car.rental.backend.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    private ConfirmationDto confirmation;
//    private DistanceDto distance;
//    private PickupLocationDto pickupLocation;
//    private DropoffLocationDto dropoffLocation;
//    private List<ExtraDto> extras = null;
//    private RateTotalsDto rateTotals;
//    private List<InsuranceDto> insurance = null;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "VEHICLE_ID", unique = true, nullable = false, updatable = false)
    private VehicleEntity vehicle;

    //    private List<TermDto> terms = null;
//    private Map<String, Object> additionalProperties = new HashMap<>();

    public ReservationEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                '}';
    }
}

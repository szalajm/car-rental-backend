package com.app.car.rental.backend.dao.entity;

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

    @OneToOne
    @JoinColumn(name = "VEHICLE_ID", unique = true, nullable = false, updatable = false)
    private VehicleEntity vehicle;

    //    private List<TermDto> terms = null;
//    private Map<String, Object> additionalProperties = new HashMap<>();

    public ReservationEntity() {}

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                '}';
    }
}

package com.cargasm.fuelcostcalc.model;

import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelRequest {
    @Min(value = 1, message = "Distance must be greater than zero")
    private double distance;

    @Min(value = 1, message = "Fuel efficiency must be greater than zero")
    private double fuelEfficiency;

    @Min(value = 1, message = "Fuel price must be greater than zero")
    private double fuelPrice;
}

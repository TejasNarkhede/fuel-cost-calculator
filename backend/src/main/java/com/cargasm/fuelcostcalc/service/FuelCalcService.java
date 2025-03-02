package com.cargasm.fuelcostcalc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cargasm.fuelcostcalc.entity.FuelCalc;
import com.cargasm.fuelcostcalc.repository.FuelCalcRepo;

@Service
public class FuelCalcService {

    private final FuelCalcRepo repository;

    FuelCalcService(FuelCalcRepo repository) {
        this.repository = repository;
    }

    public FuelCalc calculateFuelCost(double distance, double fuelEfficiency, double fuelPrice) {
        double fuelCost = (distance / fuelEfficiency) * fuelPrice;

        FuelCalc calculation = new FuelCalc();
        calculation.setDistance(distance);
        calculation.setFuelEfficiency(fuelEfficiency);
        calculation.setFuelPrice(fuelPrice);
        calculation.setFuelCost(fuelCost);
        return repository.save(calculation);
    }

    public List<FuelCalc> getHistory() {
        return repository.findAll();
    }

}

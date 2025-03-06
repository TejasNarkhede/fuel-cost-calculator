package com.cargasm.fuelcostcalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cargasm.fuelcostcalc.entity.FuelCalc;

@Repository
public interface FuelCalcRepo extends JpaRepository<FuelCalc, Long> {
}


package com.cargasm.fuelcostcalc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelCalculationRepository extends JpaRepository<FuelCalculation, Long> {
}


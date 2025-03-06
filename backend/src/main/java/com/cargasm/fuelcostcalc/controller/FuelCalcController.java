package com.cargasm.fuelcostcalc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cargasm.fuelcostcalc.dto.FuelRequest;
import com.cargasm.fuelcostcalc.entity.FuelCalc;
import com.cargasm.fuelcostcalc.service.FuelCalcService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173") // Allow frontend requests
@RestController
@RequestMapping("/fuel")
public class FuelCalcController {

    private final FuelCalcService fuelCalcService;

    FuelCalcController(FuelCalcService fuelCalcService) {
        this.fuelCalcService = fuelCalcService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Double>> calculate(@Valid @RequestBody FuelRequest request) {
        FuelCalc calculation = fuelCalcService.calculateFuelCost(
                request.getDistance(),
                request.getFuelEfficiency(),
                request.getFuelPrice());
        Map<String, Double> response = new HashMap<>();
        response.put("fuelCost", calculation.getFuelCost());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<FuelCalc>> getHistory() {
        return ResponseEntity.ok(fuelCalcService.getHistory());
    }
}

package com.cargasm.fuelcostcalc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")  // Allow frontend requests
@RestController
@RequestMapping("/fuel")
public class FuelCalculatorController {

    @Autowired
    private FuelCalculationRepository repository;

    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Double>> postMethodName(@Valid @RequestBody FuelRequest request) {
        double fuelCost = (request.getDistance() / request.getFuelEfficiency()) * request.getFuelPrice();

        FuelCalculation calculation = new FuelCalculation();
        calculation.setDistance(request.getDistance());
        calculation.setFuelEfficiency(request.getFuelEfficiency());
        calculation.setFuelPrice(request.getFuelPrice());
        calculation.setFuelCost(fuelCost);
        repository.save(calculation);

        Map<String, Double> response = new HashMap<>();
        response.put("fuelCost", fuelCost);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<FuelCalculation>> getHistory() {
        return ResponseEntity.ok(repository.findAll());
    }
}

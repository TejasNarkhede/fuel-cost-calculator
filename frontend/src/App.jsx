import { useState } from "react";
import FuelCostForm from "./components/FuelCostForm";
import FuelCostResult from "./components/FuelCostResult";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [cost, setCost] = useState(null);

  const handleCalculate = async (distance, fuelEfficiency, fuelPrice) => {
    try {
      const response = await fetch("http://localhost:8080/fuel/calculate", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ distance, fuelEfficiency, fuelPrice }),
      });

      if (!response.ok) {
        throw new Error("Failed to fetch data");
      }

      const data = await response.json();
      // console.log("API Response:", data);

      if (data && data.fuelCost !== undefined) {
        setCost(data.fuelCost);
      } else {
        setCost(0);
      }
    } catch (error) {
      console.error("Error:", error);
      setCost(0); // Default cost if error occurs
    }
  };

  return (
    <div className="container text-center mt-5">
      <h1 className="mb-4">Fuel Cost Calculator</h1>
      <FuelCostForm onCalculate={handleCalculate} />
      <FuelCostResult cost={cost} />
    </div>
  );
}

export default App;

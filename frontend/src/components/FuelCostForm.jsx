import { useState } from "react";
import PropTypes from "prop-types";

function FuelCostForm({ onCalculate }) {
  const [distance, setDistance] = useState("");
  const [fuelEfficiency, setFuelEfficiency] = useState("");
  const [fuelPrice, setFuelPrice] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!distance || !fuelEfficiency || !fuelPrice) return;
    onCalculate(Number(distance), Number(fuelEfficiency), Number(fuelPrice));
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4 ">
      <div className="mb-3 d-flex justify-content-center">
        <input
          type="number"
          placeholder="Distance (km)"
          value={distance}
          onChange={(e) => setDistance(e.target.value)}
          required
          className="form-control text-center w-50"
        />
      </div>
      <div className="mb-3 d-flex justify-content-center">
        <input
          type="number"
          placeholder="Fuel Efficiency (km/L)"
          value={fuelEfficiency}
          onChange={(e) => setFuelEfficiency(e.target.value)}
          required
          className="form-control text-center w-50"
        />
      </div>
      <div className="mb-3 d-flex justify-content-center">
        <input
          type="number"
          placeholder="Fuel Price (per L)"
          value={fuelPrice}
          onChange={(e) => setFuelPrice(e.target.value)}
          required
          className="form-control text-center w-50"
        />
      </div>

      <button type="submit" className="btn btn-success w-75">
        Calculate
      </button>
    </form>
  );
}

FuelCostForm.propTypes = {
  onCalculate: PropTypes.func.isRequired,
};

export default FuelCostForm;

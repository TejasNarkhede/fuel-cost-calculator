import PropTypes from "prop-types";

function FuelCostResult({ cost }) {
  return (
    <div>
      <h2>Fuel Cost:</h2>
      <p>{cost !== null ? `₹ ${cost.toFixed(2)}` : "Enter details above"}</p>
    </div>
  );
}

FuelCostResult.propTypes = {
  cost: PropTypes.number,
};

export default FuelCostResult;

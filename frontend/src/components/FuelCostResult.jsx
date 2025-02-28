import PropTypes from "prop-types";

function FuelCostResult({ cost }) {
  return (
    <>
    <div className="d-flex justify-content-center">

      <div className="mt-4 p-3 border rounded shadow-sm w-75">
        <h2>Fuel Cost:</h2>
        <p className="fs-4 fw-bold text-success">
          {cost !== null ? `₹ ${cost.toFixed(2)}` : "Enter details above"}
        </p>
      </div>
    </div>
    </>
  );
}

FuelCostResult.propTypes = {
  cost: PropTypes.number,
};

export default FuelCostResult;

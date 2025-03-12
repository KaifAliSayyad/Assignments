import React, { useState } from 'react';
import './Deposits.css';

const Deposits = () => {
  const [principalAmount, setPrincipalAmount] = useState('');
  const [maturityPeriod, setMaturityPeriod] = useState('');
  const [interestRate, setInterestRate] = useState(7);
  const [maturityAmount, setMaturityAmount] = useState('');
  const [interestEarned, setInterestEarned] = useState('');
  const [display, setDisplay] = useState('none');

  const calculate = () => {
    const interestRateDecimal = interestRate / 100;
    const maturityAmountCalculated = principalAmount * Math.pow(1 + interestRateDecimal, maturityPeriod);
    const interestEarnedCalculated = maturityAmountCalculated - principalAmount;
    if(maturityPeriod > 10){
      console.log("Maturity period should be less than 10 years");
      return;
    }
    setMaturityAmount(maturityAmountCalculated.toFixed(2));
    setInterestEarned(interestEarnedCalculated.toFixed(2));
    setDisplay('block');
  };

  return (
    <div className="content">
      <div className="heading">
        <h2>Deposits Calculator</h2>
      </div>
      <div className="form-container">
        <hr />
        <div className="exact-input">
          <div className="exact-amount">
            <label>Enter the exact amount:</label>
            <input
              type="number"
              min="0"
              value={principalAmount}
              onChange={(e) => setPrincipalAmount(e.target.value)}
            />
          </div>
          <div className="exact-tenure">
            <label>Enter the exact Maturity Period (less than 10 years):</label>
            <input
              type="number"
              min="0"
              max="10"
              value={maturityPeriod}
              onChange={(e) => setMaturityPeriod(e.target.value)}
            />
          </div>
          <div className="interest-rate">
            Fixed Interest Rate is <label>{interestRate}%</label>
          </div>
        </div>
        <button onClick={calculate}>Calculate</button>
        <div className="output" style={{ display }}>
          <p>Maturity Amount: {maturityAmount}</p>
          <p>Interest Earned: {interestEarned}</p>
        </div>
      </div>
    </div>
  );
};

export default Deposits;

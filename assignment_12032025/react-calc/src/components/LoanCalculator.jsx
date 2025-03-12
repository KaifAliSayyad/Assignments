import React, { useState } from 'react';
import './Loans.css';

const Loans = () => {
  const [name, setName] = useState('');
  const [exactAmount, setExactAmount] = useState(0);
  const [exactTenure, setExactTenure] = useState(0);
  const [selectedLoanType, setSelectedLoanType] = useState({
    type: 'Car Loan',
    interestRate: 11,
    minAmount: 100000,
    maxAmount: 1500000,
    tenure: 7,
  });
  const [monthlyEmi, setMonthlyEmi] = useState('');
  const [totalInterest, setTotalInterest] = useState('');
  const [totalAmount, setTotalAmount] = useState('');
  const [display, setDisplay] = useState('none');

  const loans = [
    { type: 'Car Loan', interestRate: 11, minAmount: 100000, maxAmount: 1500000, tenure: 7 },
    { type: 'Home Loan', interestRate: 9, minAmount: 500000, maxAmount: 10000000, tenure: 30 },
    { type: 'Personal Loan', interestRate: 15, minAmount: 10000, maxAmount: 500000, tenure: 5 },
  ];

  const selectLoan = (loan) => {
    setSelectedLoanType(loan);
  };

  const calculate = () => {
    const { interestRate, minAmount, maxAmount, tenure } = selectedLoanType;

    if (name.trim() === '') {
      console.log('Please enter name..🙏');
      return;
    }

    if (exactAmount < minAmount || exactAmount > maxAmount) {
      console.log('Please enter amount in given range only..🙏');
      return;
    }

    if (exactTenure > tenure) {
      console.log('Please enter tenure in given range only..🙏');
      return;
    }

    const interestRateMonthly = interestRate / 100 / 12;
    const tenureMonths = tenure * 12;

    // Calculate EMI: [P x R x (1+R)^N] / [(1+R)^N-1]
    const emi =
      (exactAmount * interestRateMonthly * Math.pow(1 + interestRateMonthly, tenureMonths)) /
      (Math.pow(1 + interestRateMonthly, tenureMonths) - 1);
    const totalAmountCalculated = emi * tenureMonths;
    const totalInterestCalculated = totalAmountCalculated - exactAmount;

    setMonthlyEmi(emi.toFixed(2));
    setTotalAmount(totalAmountCalculated.toFixed(2));
    setTotalInterest(totalInterestCalculated.toFixed(2));

    setDisplay('block');
  };

  return (
    <div className="content">
      <div className="heading">
        <h2>Loan Calculator</h2>
      </div>
      <div className="form-container">
        <div className="name">
          <label>Name:</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter your name.."
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <hr />
          <div className="loan-type">
            {loans.map((loan, index) => (
              <div key={index} className="radio-option">
                <div className="loan">
                  <input
                    type="radio"
                    id={loan.type}
                    name="loan-type"
                    value={loan.type}
                    checked={selectedLoanType.type === loan.type}  // Ensure the radio button reflects selectedLoanType
                    onChange={() => selectLoan(loan)}  // Set the selected loan when clicked
                  />
                  <label htmlFor={loan.type}>
                    {loan.type} |{' '}
                    <span>
                      Interest Rate: {loan.interestRate}%, Amount: [{loan.minAmount} - {loan.maxAmount}], Tenure: {loan.tenure}
                    </span>
                  </label>
                </div>
              </div>
            ))}
          </div>
          <hr />
          <div className="exact-input">
            <div className="exact-amount">
              <label>Enter the exact amount ({selectedLoanType.minAmount}-{selectedLoanType.maxAmount}): </label>
              <input
                type="number"
                min={selectedLoanType.minAmount}
                max={selectedLoanType.maxAmount}
                value={exactAmount}
                onChange={(e) => setExactAmount(Number(e.target.value))}
              />
            </div>
            <div className="exact-tenure">
              <label>Enter the exact tenure (less than {selectedLoanType.tenure} years): </label>
              <input
                type="number"
                min="0"
                max={selectedLoanType.tenure}
                value={exactTenure}
                onChange={(e) => setExactTenure(Number(e.target.value))}
              />
            </div>
          </div>
          <button onClick={calculate}>Calculate</button>
          <div className="output" style={{ display }}>
            <p>Calculated EMI</p>
            <p>Monthly EMI: {monthlyEmi}</p>
            <p>Total Interest: {totalInterest}</p>
            <p>Total Amount: {totalAmount}</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Loans;

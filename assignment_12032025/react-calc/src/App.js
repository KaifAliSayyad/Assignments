import React, { useState } from 'react';
import './App.css';  // Assuming you have some CSS styles in App.css
import Deposits from './components/DepositCalculator';  // Import the Deposits component
import Loans from './components/LoanCalculator';  // Import the Loans component

const App = () => {
  // State to manage which component is active
  const [activeComponent, setActiveComponent] = useState('deposits');

  // Function to toggle between components
  const toggleComponent = (component) => {
    setActiveComponent(component);
  };

  return (
    <div className="App">
      <div className="button-container">
        <button
          className={activeComponent === 'deposits' ? 'active' : ''}
          onClick={() => toggleComponent('deposits')}
        >
          Deposits Calculator
        </button>
        <button
          className={activeComponent === 'loans' ? 'active' : ''}
          onClick={() => toggleComponent('loans')}
        >
          Loan Calculator
        </button>
      </div>

      <div className="calculator-container">
        {activeComponent === 'deposits' && (
          <div className="calculator">
            <Deposits />
          </div>
        )}
        {activeComponent === 'loans' && (
          <div className="calculator">
            <Loans />
          </div>
        )}
      </div>
    </div>
  );
};

export default App;

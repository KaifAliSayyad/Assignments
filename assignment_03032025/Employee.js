// Employee manager class
class EmployeeManager {
    constructor() {
        this.apiBaseUrl = 'http://localhost:8080/employees'; // Base URL of your REST API
        this.employees = []; 

    }

    async getMaxIdCount(){
        const id = await fetch(`${this.apiBaseUrl}/getMaxId`);
        return id;
    }


    // Fetch all employees from the REST API
    async fetchEmployees() {
        try {
            const response = await fetch(this.apiBaseUrl);
            if (!response.ok) {
                throw new Error(`Error fetching employees: ${response.statusText}`);
            }
            const employees = await response.json();
            return employees;
        } catch (error) {
            console.log(error.message);
            return [];
        }
    }

    // Add a new employee via the REST API
    async addEmployee(employee) {
        console.log("adding employee -"+JSON.stringify(employee));
        try {
            const response = await fetch(this.apiBaseUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(employee)
            });
            if (!response.ok) {
                throw new Error(`Error adding employee: ${response.statusText}`);
            }
            return true;
        } catch (error) {
            console.log(error.message);
            return false;
        }
    }

    // Search for an employee by name via the REST API
    async searchEmployee(name) {
        try {
            const response = await fetch(`${this.apiBaseUrl}/${name}`);
            if (!response.ok) {
                throw new Error(`Employee with name "${name}" not found.`);
            }
            const employee = await response.json();
            return employee;
        } catch (error) {
            console.log(error.message);
            return null;
        }
    }

    // Update an employee by name via the REST API
    async updateEmployee(name, updatedData) {
        try {
            const employee = await this.searchEmployee(name);
            if (!employee) {
                throw new Error(`Employee with name "${name}" not found.`);
            }
            const updatedEmployee = { ...employee, ...updatedData };
            console.log("updating employee -"+JSON.stringify(updatedEmployee));
            const response = await fetch(this.apiBaseUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(updatedEmployee)
            });
            if (!response.ok) {
                throw new Error(`Error updating employee: ${response.statusText}`);
            }
            return true;
        } catch (error) {
            console.log(error.message);
            return false;
        }
    }

    // Remove an employee by name via the REST API
    async removeEmployee(name) {
        try {
            const employee = await this.searchEmployee(name);
            if (!employee) {
                throw new Error(`Employee with name "${name}" not found.`);
            }
            const response = await fetch(`${this.apiBaseUrl}/${name}`, {
                method: 'DELETE'
            });
            if (!response.ok) {
                throw new Error(`Error removing employee: ${response.statusText}`);
            }
            return true;
        } catch (error) {
            console.log(error.message);
            return false;
        }
    }

    // Display all employees
    async displayEmployees() {
        this.employees = await this.fetchEmployees();
        return this.employees;
    }
}

// Initialize employee manager
const manager = new EmployeeManager();

// Tab switching functionality
document.querySelectorAll('.tab').forEach(tab => {
    tab.addEventListener('click', () => {
        // Remove active class from all tabs and content
        document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
        document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
        
        // Add active class to clicked tab
        tab.classList.add('active');
        
        // Show corresponding content
        const tabId = tab.getAttribute('data-tab');
        document.getElementById(tabId).classList.add('active');
    });
});

// Show status message
function showStatus(message, isSuccess = true) {
    const statusEl = document.getElementById('statusMessage');
    statusEl.textContent = message;
    statusEl.classList.remove('hidden', 'success', 'error');
    statusEl.classList.add(isSuccess ? 'success' : 'error');
    
    // Hide after 3 seconds
    setTimeout(() => {
        statusEl.classList.add('hidden');
    }, 3000);
}

// Populate employee table
async function refreshEmployeeTable() {
    const tableBody = document.getElementById('employeeTableBody');
    tableBody.innerHTML = '';
    
    const employees = await manager.displayEmployees();
    
    if (employees?.length === 0) {
        const row = document.createElement('tr');
        row.innerHTML = '<td colspan="7">No employees found</td>';
        tableBody.appendChild(row);
        return;
    }
    
    employees.forEach((emp, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.age}</td>
            <td>${emp.salary}</td>
            <td>${emp.designation}</td>
            <td>
                <button class="action-button secondary" onclick="prepareUpdate('${emp.name}')">Edit</button>
                <button class="action-button danger" onclick="prepareRemove('${emp.name}')">Remove</button>
            </td>
        `;
        tableBody.appendChild(row);
    });

}

// Add Event Listeners
document.addEventListener('DOMContentLoaded', () => {
    // Add Employee Form
    document.getElementById('addEmployeeForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('name').value;
        const age = parseInt(document.getElementById('age').value);
        const salary = parseInt(document.getElementById('salary').value);
        const designation = document.getElementById('designation').value;
        
        manager.addEmployee({name, age, salary, designation });
        IDCount++;
        showStatus(`Employee ${name} added successfully!`);
        document.getElementById('addEmployeeForm').reset();
    });
    
    // Refresh Employee List Button
    document.getElementById('refreshEmployeeList').addEventListener('click', refreshEmployeeTable);
    
    // Search Button
    document.getElementById('searchButton').addEventListener('click', () => {
        const name = document.getElementById('searchName').value;
        const result = async () => await manager.searchEmployee(name);
        const searchResult = document.getElementById('searchResult');
        const searchResultBody = document.getElementById('searchResultBody');
        
        searchResultBody.innerHTML = '';
        
        if (result) {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${result.id}</td>
                <td>${result.name}</td>
                <td>${result.age}</td>
                <td>${result.salary}</td>
                <td>${result.designation}</td>
            `;
            searchResultBody.appendChild(row);
            searchResult.classList.remove('hidden');
        } else {
            showStatus(`Employee with name "${name}" not found.`, false);
            searchResult.classList.add('hidden');
        }
    });
    
    // Find for Update Button
    document.getElementById('findForUpdateButton').addEventListener('click', () => {
        const name = document.getElementById('updateSearchName').value;
        const employee = manager.searchEmployee(name);
        
        if (employee) {
            document.getElementById('updateName').value = employee.name;
            document.getElementById('updateAge').value = employee.age;
            document.getElementById('updateSalary').value = employee.salary;
            document.getElementById('updateDesignation').value = employee.designation;
            document.getElementById('updateForm').classList.remove('hidden');
        } else {
            document.getElementById('updateForm').classList.add('hidden');
        }
    });
    
    // Cancel Update Button
    document.getElementById('cancelUpdate').addEventListener('click', () => {
        document.getElementById('updateForm').classList.add('hidden');
        document.getElementById('updateSearchName').value = '';
    });
    
    // Update Employee Form
    document.getElementById('updateEmployeeForm').addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('updateName').value;
        const age = parseInt(document.getElementById('updateAge').value);
        const salary = parseInt(document.getElementById('updateSalary').value);
        const designation = document.getElementById('updateDesignation').value;
        
        const success = manager.updateEmployee(name, { age, salary, designation });
        
        if (success) {
            showStatus(`Employee ${name} updated successfully!`);
            document.getElementById('updateForm').classList.add('hidden');
            document.getElementById('updateSearchName').value = '';
        } else {
            showStatus(`Failed to update employee ${name}.`, false);
        }
    });
    
    // Find for Remove Button
    document.getElementById('findForRemoveButton').addEventListener('click', () => {
        const name = document.getElementById('removeSearchName').value;
        const employee = manager.searchEmployee(name);
        
        if (employee) {
            const details = document.getElementById('removeEmployeeDetails');
            details.innerHTML = `
                <p><strong>ID:</strong> ${employee.id}</p>
                <p><strong>Name:</strong> ${employee.name}</p>
                <p><strong>Age:</strong> ${employee.age}</p>
                <p><strong>Salary:</strong> ${employee.salary}</p>
                <p><strong>Designation:</strong> ${employee.designation}</p>
            `;
            document.getElementById('removeConfirm').classList.remove('hidden');
        } else {
            document.getElementById('removeConfirm').classList.add('hidden');
        }
    });
    
    // Cancel Remove Button
    document.getElementById('cancelRemoveButton').addEventListener('click', () => {
        document.getElementById('removeConfirm').classList.add('hidden');
        document.getElementById('removeSearchName').value = '';
    });
    
    // Confirm Remove Button
    document.getElementById('confirmRemoveButton').addEventListener('click', () => {
        const name = document.getElementById('removeSearchName').value;
        const success = manager.removeEmployee(name);
        
        if (success) {
            showStatus(`Employee ${name} removed successfully!`);
            document.getElementById('removeConfirm').classList.add('hidden');
            document.getElementById('removeSearchName').value = '';
        } else {
            showStatus(`Failed to remove employee ${name}.`, false);
        }
    });
});

// Global functions for action buttons
function prepareUpdate(name) {
    document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
    document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
    
    // Show update tab
    document.querySelector('.tab[data-tab="update"]').classList.add('active');
    document.getElementById('update').classList.add('active');
    
    // Set the employee name
    document.getElementById('updateSearchName').value = name;
    
    // Trigger the find button
    document.getElementById('findForUpdateButton').click();
}

function prepareRemove(name) {
    document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
    document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
    
    // Show remove tab
    document.querySelector('.tab[data-tab="remove"]').classList.add('active');
    document.getElementById('remove').classList.add('active');
    
    // Set the employee name
    document.getElementById('removeSearchName').value = name;
    
    // Trigger the find button
    document.getElementById('findForRemoveButton').click();
}

// Add sample employees
window.addEventListener('load', () => {
    // Add sample employees
    manager.addEmployee({name: "Shoyab", age: 22, salary: 50000, designation: "Developer" });
    manager.addEmployee({name: "Omkar", age: 25, salary: 60000, designation: "Tester" });
    refreshEmployeeTable();
});
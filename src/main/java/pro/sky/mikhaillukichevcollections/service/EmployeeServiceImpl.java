package pro.sky.mikhaillukichevcollections.service;

import pro.sky.mikhaillukichevcollections.model.EmployeeService;
import pro.sky.mikhaillukichevcollections.exception.EmployeeAlreadyAddedException;
import pro.sky.mikhaillukichevcollections.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import pro.sky.mikhaillukichevcollections.exception.EmployeeStorageIsFullException;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static int EMPLOYEE_MAX_COUNT = 2;
    List<Employee> employees = new ArrayList<>();

    public List<Employee> displayEmployees() {
        return employees;
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= EMPLOYEE_MAX_COUNT) {
            throw new EmployeeStorageIsFullException("Cannot add employee. Storage is full");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Such employee has been already added");
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee removeEmployee = new Employee(firstName, lastName);
        if (employees.contains(removeEmployee)) {
            employees.remove(removeEmployee);
            return removeEmployee;
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        if (employees.contains(findEmployee)) {
            return findEmployee;
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}

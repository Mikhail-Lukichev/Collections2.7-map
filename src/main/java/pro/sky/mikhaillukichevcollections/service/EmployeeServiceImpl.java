package pro.sky.mikhaillukichevcollections.service;

import pro.sky.mikhaillukichevcollections.model.EmployeeService;
import pro.sky.mikhaillukichevcollections.exception.EmployeeAlreadyAddedException;
import pro.sky.mikhaillukichevcollections.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import pro.sky.mikhaillukichevcollections.exception.EmployeeStorageIsFullException;
import pro.sky.mikhaillukichevcollections.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static int EMPLOYEE_MAX_COUNT = 2;
    //    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employees = new HashMap<String, Employee>();

    public Map<String, Employee> displayEmployees() {
        return employees;
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= EMPLOYEE_MAX_COUNT) {
            throw new EmployeeStorageIsFullException("Exception: adding employee " + firstName + " " + lastName + ". Cannot add employee. Storage is full");
        }
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Exception: adding employee " + firstName + " " + lastName + ". Such employee has been already added");
        }
        Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + lastName, employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            employees.remove(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException("Exception: removing employee " + firstName + " " + lastName + ". Employee not found");
        }
        return new Employee(firstName, lastName);
    }

    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + lastName)) {
            return employees.get(firstName + lastName);
        } else {
            throw new EmployeeNotFoundException("Exception: finding employee " + firstName + " " + lastName + ". Employee not found");
        }
    }
}

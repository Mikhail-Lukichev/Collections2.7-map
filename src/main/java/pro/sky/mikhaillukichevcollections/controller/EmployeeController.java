package pro.sky.mikhaillukichevcollections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.mikhaillukichevcollections.model.Employee;
import pro.sky.mikhaillukichevcollections.model.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> displayEmployees() {
        return employeeService.displayEmployees();
    }

    @GetMapping(path="/add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName) {
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping(path="/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName) {
        return employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping(path="/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName) {
        return employeeService.findEmployee(firstName,lastName);
    }
}

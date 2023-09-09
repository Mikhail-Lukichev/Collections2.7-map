package pro.sky.mikhaillukichevcollections.model;

import java.util.Objects;

public class Employee {
    public static int count = 0;
    private String fistName;
    private String lastName;

    public Employee(String firstName, String lastName){
        this.fistName = firstName;
        this.lastName = lastName;
        count++;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fistName, employee.fistName)
                && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName);
    }
}

package Restaurant;

import mangement.employeeManagement;

import java.io.IOException;
import java.util.Scanner;

public class WorkForce {
    employeeManagement manager;

    //management methods
    public void add() throws IOException {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter new employee first name ");
        employee.setEmployee_first_name(scanner.nextLine());

        System.out.println("Please enter new employee last name");
        employee.setEmployee_last_name(scanner.nextLine());

        manager.add(employee.getEmployee_first_name(), employee.getEmployee_last_name());

    }

    public void delete() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter employee id number.");
        int id = scanner.nextInt();

        System.out.println("Thank you, your item has now been deleted.");
        manager.delete(id);

    }

    public void update() throws IOException {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter employee id number you wish to update.");
        int id = scanner.nextInt();
        employee.setEmployeeNum(id);

        System.out.println("Please enter updated employee first name ");
        employee.setEmployee_first_name(scanner.nextLine());

        System.out.println("Please enter updated employee last name");
        employee.setEmployee_last_name(scanner.nextLine());

        manager.update(employee.getEmployeeNum(), employee.getEmployee_first_name(), employee.getEmployee_last_name());
    }

    public void printEmployees() {
        manager.selectAll();
    }


}
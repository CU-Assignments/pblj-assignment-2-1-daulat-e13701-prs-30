import java.util.Scanner;
import java.util.ArrayList;
class Employee{
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String toString() {
        return "ID: " + id + " || Name: " + name + " || Salary: " + salary;
    }
}
public class empDetails{
    static ArrayList<Employee> empList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addEmployee(){
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        String name = sc.next();
        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        empList.add(new Employee(id, name, salary));
        System.out.println("Employee Added Successfully.");
    }
    public static void removeEmployee(){
        System.out.print("Enter employee ID to be removed: ");
        int id = sc.nextInt();
        for(int i = 0; i < empList.size(); i++){
            if(empList.get(i).id == id){
                empList.remove(i);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found by this ID.");
    }
    public static void updateEmployee(){
        System.out.print("Enter employee ID to be updated: ");
        int id = sc.nextInt();
        for(int i = 0; i < empList.size(); i++){
            if(empList.get(i).id == id){
                System.out.print("Enter new employee name: ");
                String name = sc.next();
                System.out.print("Enter its salary: ");
                double salary = sc.nextDouble();
                empList.get(i).name = name;
                empList.get(i).salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found by this ID.");
    }
    public static void searchEmployee(){
        System.out.print("Enter employee ID to be searched: ");
        int id = sc.nextInt();
        for(int i = 0; i < empList.size(); i++){
            if(empList.get(i).id == id){
                System.out.println(empList.get(i));
                return;
            }
        }
        System.out.println("Employee not found with this ID.");
    }
    public static void displayEmployees(){
        if(empList.isEmpty()){
            System.out.println("No employees found.");
        }
        for(Employee e : empList){
            System.out.println((e));
        }
    }
    public static void main(String[] args){
        while(true){
            System.out.println("..........Employee Management System..........");
            System.out.print("1- Add Employee:\n2- Remove Employee:\n3- Update Employee:\n4- Search Employee:\n5- Display all Employees:\n6- Exit!!!\n");
            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    sc.close();
                default:
                    System.out.println("Invalid choice made, try again.");
            }
        }
    }
}
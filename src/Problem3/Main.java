package Problem3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Employee> employeeMap = new HashMap<>();

        //Entries for the hashmap object
        employeeMap.put("HR", new Employee("03", "Jatin", 100000.0));
        employeeMap.put("Sales", new Employee("71", "Suman", 50000.0));
        employeeMap.put("Marketing", new Employee("56", "Mukul", 70000.0));
        employeeMap.put("Accounts", new Employee("15", "Shubham", 60000.0));


        //Passing the employeeMap Object to the getSortedMapWithValue Method for sorting
        Main instanceOfMain = new Main();
        Map<String, Employee> sortedMap = instanceOfMain.getSortedMapWithValue(employeeMap);

        Set<Map.Entry<String, Employee>> entries = sortedMap.entrySet();

        for(Map.Entry entry: entries) {
            System.out.println("Department Name: " + entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("___________________________________");
        }

    }

    public Map<String,Employee> getSortedMapWithValue(Map<String,Employee> originalMap) {
        //sort the supplied map according to the value(Employee salary) and return the sorted Map.
        List<Map.Entry<String, Employee>> entries = new ArrayList<>(originalMap.entrySet());
        Collections.sort(entries, (e1, e2) -> e1.getValue().getSalary() > e2.getValue().getSalary() ? 1:-1);

        Map<String, Employee> sortedMap = new LinkedHashMap();

        for(Map.Entry entry: entries) {
            sortedMap.put((String)entry.getKey(), (Employee) entry.getValue());
        }

        return sortedMap;
    }
}

class Employee {
    private String empId ;
    private String empName;
    private double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, salary);
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nID: " + empId + "\nName: " + empName + "\nSalary: " + salary;
    }
}



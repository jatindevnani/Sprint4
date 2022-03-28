package Problem2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        //Creating the file named "emp.txt" using methods from java.nio package
        Path file = Paths.get("emp.txt");

        //Creation of File
        if(Files.exists(file)) {
            System.out.println("File already exists");
        } else {
            Files.createFile(file);
            System.out.println("File has been created successfully!");
        }

        //Creating an Address object to pass to the constructor of  employee object
        Address employeesAddress = new Address("MP", "Bhopal", "462001");

        //Creating an Employee Object
        Employee employee = new Employee("03", "Jatin", employeesAddress, "jatin@masai.com", "java");

        //Calling the serialiseObject Method to serialise the employee object
        serialiseObject(employee);

        //Getting the deserialized object from deserialiseObject Method
        Employee deserializedEmployee = deserialiseObject();

        //Calling the toString method of the Deserialized Employee object
        System.out.println(deserializedEmployee);
    }

    public static void serialiseObject(Employee employee) {
        try {
            //Creating an object of File Output Stream with the file address as -> "emp.txt" (Current Path)
            FileOutputStream fos = new FileOutputStream("emp.txt");

            //Creation of Object Output Stream object to serialise the employee object
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //Serialisation of object
            oos.writeObject(employee);
            System.out.println("Employee Object serialised Successfully");

        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Employee deserialiseObject() {
        //Creating the employee object to access it outside of the try/catch block
        Employee employee = null;
        try{
            //Creation of File Input Stream and Object Input Stream
            FileInputStream fis =  new FileInputStream("emp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            //Deserializing the object and storing in an type of Object
            Object deserialisedObject = ois.readObject();

            //Down casting the deserialized object to the type of Employee
            employee = (Employee) deserialisedObject;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Employee Object Deserialised successfully");
        return employee;
    }
}


//Address Bean class
class Address implements Serializable {
    private String state;
    private String city;
    private String pincode;

    public Address(String state, String city, String pincode) {
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "State: " + this.state + "\nCity: " + this.city + "\npincode: " + this.pincode;
    }
}

//Employee Bean class
class Employee implements Serializable {
    private String empId;
    private String empName;
    private Address address;
    private String email;
    private transient String password; //Transient keyword to make sure password is not serialised

    public Employee(String empId, String empName, Address address, String email, String password) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee ID: " + this.empId + "\nEmployee Name: " + this.empName + "\nAddress: " + this.address + "\nEmail: " + this.email + "\nPassword: " + this.password;
    }
}



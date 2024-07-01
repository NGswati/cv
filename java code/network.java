import java.util.Scanner;
import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class network{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuestion 1");
        try {
            System.out.println("args length: " + args.length);
            File f1 = new File(args[0]);
            File f2 = new File(args[1]);
            FileInputStream in = new FileInputStream(f1);

            FileOutputStream out = new FileOutputStream(f2);
            String s1 = "", s2 = "";
            while ((s1 = in.read()) != -1) {
                
                System.out.println(s1);
                        
            }
           
        } catch (Exception e) {
            System.out.println("Error : take 2 file input from command prompt ");
        }
    }
}



class Student implements Serializable {
    String firstName;
    String lastName;
    int rollNumber;
    int cpi;
    int age;

    Student(String firstName, String lastName, Integer rollNumber, Integer cpi, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.cpi = cpi;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
    return lastName;
    }
    
    public Integer getRollNumber() {
        return rollNumber;
    }

    public Integer getCPI() {
        return cpi;
    }

    public Integer getAge() {
        return age;
    }
}
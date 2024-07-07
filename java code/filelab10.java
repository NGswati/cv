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

class Student implements Serializable {
    String firstName;
    String lastName;
    int rollNumber;
    int cpi;
    int age;
    Student(String firstName,String lastName,Integer rollNumber,Integer cpi,Integer age) {
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
 
public class filelab10 {
    public static void main(String args [])throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuestion 1");
        try { 
            System.out.println("args length: "+args.length);
            File f1 = new File(args[0]);
            File f2 = new File(args[1]);
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));
            String s1 = "",s2 = "";
            while (((s1 = br1.readLine()) != null) && ((s2 = br2.readLine()) != null)) {
                String[] word1 = s1.split(" ");
                String[] word2 = s2.split(" ");
                int pos = 0;
                for (int i = 0; i < word1.length; i++) {
                    for(int j=0;j<word2.length;j++){
                        if ((word1[i].equalsIgnoreCase(word2[j]))) {
                            System.out.println(word1[i] +":\t Length: " +word1[i].length() +",  Position: " +pos++);
                        }
                    }
                }
            }
            br1.close();
            br2.close();
        } catch (Exception e) {
            System.out.println("Error : take 2 file input from command prompt ");
        }
        System.out.println("\n\nQuestion 2");
        String filename = "Student.ser";
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream output = new ObjectOutputStream(file);
        Student[] arr = new Student[10];
        try {
        for (int i = 0; i < 10; i++) {
            System.out.println("Student ->" + (i + 1) + ":");
            System.out.print("Enter first name: ");
            String fname = sc.next();
            System.out.print("Enter last name: ");
            String lname = sc.next();
            Integer rno = i + 1;
            System.out.print("Enter age: ");
            Integer cpi = sc.nextInt();
            System.out.print("Enter cpi: ");
            Integer age = sc.nextInt();
            arr[i] = new Student(fname, lname, rno, cpi, age);
            output.writeObject(arr[i]);
        }
        output.writeObject(new endOfFile());
        output.close();
        file.close();
        sc.close();
        } catch (IOException e) {
        System.out.println("IO Error detected");
        } catch(Exception e) {
        System.out.println("Error");
        }
        FileInputStream file1 = new FileInputStream(filename);
        ObjectInputStream obj = new ObjectInputStream(file1);
        Object obj1 = null;
        try {
        while ((obj1 = obj.readObject()) instanceof endOfFile == false) {
            System.out.println("Details of student whose name start with M");
            String str=((Student) obj1).getFirstName();
            if(str.split("M").length>1||str.split("m").length>1){
            System.out.print(((Student) obj1).getRollNumber() + ") ");
            System.out.print(((Student) obj1).getFirstName() + " ");
            System.out.print(((Student) obj1).getLastName() + " ");
            System.out.print(((Student) obj1).getAge() + " ");
            System.out.print(((Student) obj1).getCPI() + "\n");
            }
            System.out.println("\nDetails of the students whose age is below 18");
            int i = Integer.valueOf((Integer)((Student) obj1).getAge());
            if(i <18){
            System.out.print(((Student) obj1).getRollNumber() + ") ");
            System.out.print(((Student) obj1).getFirstName() + " ");
            System.out.print(((Student) obj1).getLastName() + " ");
            System.out.print(((Student) obj1).getAge() + " ");
            System.out.print(((Student) obj1).getCPI() + "\n");
            }
        }
        obj.close();
        } catch (Exception e) {
        System.out.println("Nobody is with name starting from Mor less than 18");
        }
    }  
}
class endOfFile implements Serializable {
    public endOfFile(){}
}

//OUTPUT

// Question 1
// args length: 2
// in:      Length: 2,  Position: 0
// this:    Length: 4,  Position: 1
// this:    Length: 4,  Position: 2
// and:     Length: 3,  Position: 3
// I:       Length: 1,  Position: 4
// I:       Length: 1,  Position: 5
// to:      Length: 2,  Position: 6
// to:      Length: 2,  Position: 7
// I:       Length: 1,  Position: 8
// I:       Length: 1,  Position: 9
// don't:   Length: 5,  Position: 10
// to:      Length: 2,  Position: 11
// to:      Length: 2,  Position: 12
// but:     Length: 3,  Position: 13
// I:       Length: 1,  Position: 14
// I:       Length: 1,  Position: 15
// can:     Length: 3,  Position: 16
// take:    Length: 4,  Position: 17
// take:    Length: 4,  Position: 18
// to:      Length: 2,  Position: 19
// to:      Length: 2,  Position: 20


// Question 2
// Student ->1:
// Enter first name: rina
// Enter last name: mehra
// Enter age: 12
// Enter cpi: 3
// Student ->2:
// Enter first name: mina 
// Enter last name: singh
// Enter age: 34
// Enter cpi: 5
// Student ->3:
// Enter first name: monica
// Enter last name: mins
// Enter age: 23
// Enter cpi: 7
// Student ->4:
// Enter first name: ilina
// Enter last name: das
// Enter age: 10
// Enter cpi: 7
// Student ->5:
// Enter first name: gopi
// Enter last name: gamur
// Enter age: 16
// Enter cpi: 9
// Student ->6:
// Enter first name: minsha
// Enter last name: mishra
// Enter age: 19
// Enter cpi: 8
// Student ->7:
// Enter first name: nina
// Enter last name: wahur
// Enter age: 17
// Enter cpi: 10
// Student ->8:
// Enter first name: firdous
// Enter last name: kangha
// Enter age: 21
// Enter cpi: 8
// Student ->9:
// Enter first name: mahak
// Enter last name: pal
// Enter age: 20
// Enter cpi: 4
// Student ->10:
// Enter first name: fariha
// Enter last name: kapi
// Enter age: 19
// Enter cpi: 6
// Details of student whose name start with M

// Details of the students whose age is below 18
// 1) rina mehra 3 12
// Details of student whose name start with M
// 2) mina singh 5 34

// Details of the students whose age is below 18
// 2) mina singh 5 34
// Details of student whose name start with M
// 3) monica mins 7 23

// Details of the students whose age is below 18
// 3) monica mins 7 23
// Details of student whose name start with M

// Details of the students whose age is below 18
// 4) ilina das 7 10
// Details of student whose name start with M

// Details of the students whose age is below 18
// 5) gopi gamur 9 16
// Details of student whose name start with M
// 6) minsha mishra 8 19

// Details of the students whose age is below 18
// 6) minsha mishra 8 19
// Details of student whose name start with M

// Details of the students whose age is below 18
// 7) nina wahur 10 17
// Details of student whose name start with M

// Details of the students whose age is below 18
// 8) firdous kangha 8 21
// Details of student whose name start with M
// 9) mahak pal 4 20

// Details of the students whose age is below 18
// 9) mahak pal 4 20
// Details of student whose name start with M

// Details of the students whose age is below 18
// 10) fariha kapi 6 19
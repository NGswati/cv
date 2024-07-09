import java.util.Scanner;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.Collections;
import java.util.Comparator;

class user{
    String firstName;
    String lastName;
    String PAN;
    int PIN;
    String emailId;
    int rollNumber;
    String dateOfBirth;

    void setDetails(String f,String l,String p,int pi,String e,int r,String d,int c,String de,int ei){
        firstName=f;
        lastName=l;
        PAN=p;
        PIN=pi;
        emailId=e;
        rollNumber=r;
        dateOfBirth=d;
    }
    void showDetails(){
        System.out.println("\nname : "+ firstName+" "+lastName);
        System.out.println("PAN : "+ PAN);
        System.out.println("PIN : "+ PIN);
        System.out.println("Email ID : "+ emailId);
        System.out.println("Roll Number : "+ rollNumber);
        System.out.println("Date Of Birth : "+ dateOfBirth);
    }
    
    static void validate(String f){
        Scanner sc = new Scanner(System.in);
        int n=1,flag=0;
        while(n>0){
            System.out.println("\n1. validate PAN");
            System.out.println("2. validate PIN");
            System.out.println("3. validate Date Of Birth");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice: ");
            n=sc.nextInt();
            switch(n){
                case 1:
                if(f.matches("[A-Z]*[0-9]*"))
                System.out.println("valid PAN");
                else
                System.out.println("validation fails\n please re-enter..");
                break;
                case 2:
                if(f.matches("\\d{6}"))
                System.out.println("valid PIN");
                else
                System.out.println("validation fails\n please re-enter..");
                break;
                case 3:
                if (f.length()!=8){
                    flag=1;
                    break;
                }
                else{
                    int Month = Integer.parseInt(f.substring(0, 2));
                    int Day = Integer.parseInt(f.substring(2, 4));
                    int Year = Integer.parseInt(f.substring(4));
                    if (Month<1 && Month>12){
                        flag=1;
                        break;
                    }
                    if (Day<1 && Day>31){
                        flag=1;
                        break;
                    }
                    if (Year<1950 && Year>2022){
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                System.out.println("validation fails\n please re-enter..");
                else
                System.out.println("valid Date Of Birth ");
                break;
                case 0:
                System.out.println("Exit");
                break;
                default:
                System.out.println("enter a valid value");
            }
        }
    }
}

class class1 extends user{
    int cpi;
    void setDetails(String f,String l,String p,int pi ,String e,int r,String d,int c,String de,int ei){
        super.setDetails(f,l,p,pi,e,r,d,c,de,ei);
        cpi=c;
    }
}
class class2 extends user{
    String designation;
    void setDetails(String f,String l,String p,int pi ,String e,int r,String d,int c,String de,int ei){
        super.setDetails(f,l,p,pi,e,r,d,c,de,ei);
        designation=de;
    }
}
class class3 extends user{
    int employeeId;
    void setDetails(String f,String l,String p,int pi ,String e,int r,String d,int c,String de,int ei){
        super.setDetails(f,l,p,pi,e,r,d,c,de,ei);
        employeeId=ei;
    }
}

class roll implements Comparator<user> {
    public int compare (user s1,user s2) {
    return s1.rollNumber - s2.rollNumber;
    }
}

class year implements Comparator<user> {
    public int compare (user s1,user s2) {
        int a,b;
        a=Integer.parseInt(s1.dateOfBirth.substring(4));
        b=Integer.parseInt(s2.dateOfBirth.substring(4));
        return a-b;
    }
}
public class lab8{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<user> ul = new ArrayList<user>(100);
        ArrayList<class1> c1 = new ArrayList<class1>(100);
        ArrayList<class2> c2 = new ArrayList<class2>(100);
        ArrayList<class3> c3 = new ArrayList<class3>(100);

        int n=1,i=0,j=0,k=0,l=0;
        System.out.println("\n_____welcome ____");

        while(n>0){
            System.out.println("\n1. set details for user class");
            System.out.println("2. set details for class1 class");
            System.out.println("3. set details for class2 class");
            System.out.println("4. set details for class3 class");
            System.out.println("5. validate PAN");
            System.out.println("6. validate PIN");
            System.out.println("7. validate Date of birth");
            System.out.println("8. sort roll Number-wise");
            System.out.println("9. sort birthyear-wise");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice: ");
            n=sc.nextInt();
            switch(n){
                case 1:
                System.out.print("Enter First Name: ");
                String f = sc.nextLine();
                sc.next();
                System.out.print("Enter Last Name: ");
                String ln = sc.nextLine();
                sc.next();
                System.out.print("Enter PAN: ");
                String pan = sc.nextLine();
                sc.next();
                System.out.print("Enter PiN: ");
                int pin = sc.nextInt();
                System.out.print("Enter Email ID: ");
                String e = sc.nextLine();
                sc.next();
                System.out.print("Enter Roll Number: ");
                int r = sc.nextInt();
                System.out.print("Enter Date OF Birth : ");
                String dob = sc.nextLine();
                sc.next();
                int flag=0;
                if (dob.length()!=8){
                    flag=1;
                    break;
                }
                else{
                    int Month = Integer.parseInt(dob.substring(0, 2));
                    int Day = Integer.parseInt(dob.substring(2, 4));
                    int Year = Integer.parseInt(dob.substring(4));
                    if (Month<1 && Month>12){
                        flag=1;
                        break;
                    }
                    if (Day<1 && Day>31){
                        flag=1;
                        break;
                    }
                    if (Year<1950 && Year>2022){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                user b=new user() ;
                b.setDetails(f,ln,pan,pin,e,r,dob,0,"",0);  
                ul.add(b);
                i++;}
                else{
                    System.out.print(" date of birth incorrect !!\n re-enter the details ");
                }
                break;
                case 2:
                System.out.print("Enter First Name: ");
                f = sc.nextLine();
                sc.next();
                System.out.print("Enter Last Name: ");
                ln = sc.nextLine();
                sc.next();
                System.out.print("Enter PAN : ");
                pan = sc.nextLine();
                sc.next();
                System.out.print("Enter PiN : ");
                pin = sc.nextInt();
                System.out.print("Enter Email ID: ");
                e = sc.nextLine();
                sc.next();
                System.out.print("Enter Roll Number : ");
                r = sc.nextInt();
                System.out.print("Enter Date OF Birth : ");
                dob = sc.nextLine();
                sc.next();
                System.out.print("Enter cpi : ");
                int ci = sc.nextInt();
                class1 c=new class1() ;
                c.setDetails(f,ln,pan,pin,e,r,dob,ci,"",0);  
                c1.add(c);
                j++;
                break;
                case 3:
                System.out.print("Enter First Name: ");
                f = sc.nextLine();
                sc.next();
                System.out.print("Enter Last Name: ");
                ln = sc.nextLine();
                sc.next();
                System.out.print("Enter PAN : ");
                pan = sc.nextLine();
                sc.next();
                System.out.print("Enter PiN : ");
                pin = sc.nextInt();
                System.out.print("Enter Email ID: ");
                e = sc.nextLine();
                sc.next();
                System.out.print("Enter Roll Number : ");
                r = sc.nextInt();
                System.out.print("Enter Date OF Birth : ");
                dob = sc.nextLine();
                sc.next();
                System.out.print("Enter designation: ");
                String  de= sc.nextLine();
                sc.next();
                class2 d=new class2() ;
                d.setDetails(f,ln,pan,pin,e,r,dob,0,de,0);  
                c2.add(d);
                k++;
                break;
                case 4:
                System.out.print("Enter First Name: ");
                f = sc.nextLine();
                sc.next();
                System.out.print("Enter Last Name: ");
                ln = sc.nextLine();
                sc.next();
                System.out.print("Enter PAN : ");
                pan = sc.nextLine();
                sc.next();
                System.out.print("Enter PiN : ");
                pin = sc.nextInt();
                System.out.print("Enter Email ID: ");
                e = sc.nextLine();
                sc.next();
                System.out.print("Enter Roll Number : ");
                r = sc.nextInt();
                System.out.print("Enter Date OF Birth : ");
                dob = sc.nextLine();
                sc.next();
                System.out.print("Enter Employee ID: ");
                int ei= sc.nextInt();
                class3 g=new class3() ;
                g.setDetails(f,ln,pan,pin,e,r,dob,0,"",ei);  
                c3.add(g);
                l++;
                break;
                case 5:
                System.out.print("Enter  PAN: ");
                f = sc.nextLine();
                sc.next();
                user.validate(f);
                break;
                case 6:
                System.out.print("Enter  PIN: ");
                pin = sc.nextInt();
                f=Integer.toString(pin);
                user.validate(f);
                break;
                case 7:
                System.out.print("Enter  DateOfBirth(mmddyyyy): ");
                f = sc.nextLine();
                sc.next();
                user.validate(f);
                break;
                case 8:
                System.out.println("Sorting based on Roll Number");		
                Collections.sort(ul, new roll());
                for(int x=0;x<i;x++){
                    ul.get(x).showDetails();
                }
                break;
                case 9:
                System.out.println("Sorting based on Birth Year");		
                Collections.sort(ul, new year());
                for(int x=0;x<i;x++){
                    ul.get(x).showDetails();
                }
                break;
                case 0:
                System.out.println("EXIT");
                break;
                default:
                System.out.println("Enter a valid choice!!");
            }
        }
    }
}

        
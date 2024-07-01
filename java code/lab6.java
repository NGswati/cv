import java.util.Scanner;

class user{
    String name;
    int birthYear;
    int userId;
    user(int u){
        this.name="NIL";
        this.birthYear=0;
        this.userId=u;
    }
    //,int r,int s,int c,int e,String sn,String de,int ei, String dp, int np
    void setDetails(String n,int d,int r,int s,int c,int e,String sn,String de,int ei, String dp, int np){
        name=n;
        birthYear=d;
    }
    void showDetails(int birthYear){
        System.out.println("\nname : "+ name);
        System.out.println("birth year : "+ birthYear);
        System.out.println("userid : "+ userId);
    }
}
class Student extends user{
    int rollNumber;
    int semester;
    int cpi;

    Student(int u){
        super(u);
        this.rollNumber=0;
        this.semester=0;
        this.cpi=0;
    }
    //, r, s, c, e, sn, de, ei, dp, np
    //,int e,String sn,String de,int ei, String dp, int np
    @Override
    void setDetails(String n,int d,int r,int s,int c,int e,String sn,String de,int ei, String dp, int np){
        super.setDetails(n, d, r, s, c, e, sn, de, ei, dp, np);
        rollNumber=r;
        semester=s;
        cpi=c;
    }
    @Override
    void showDetails(int birthYear){
        super.showDetails(birthYear);
        System.out.println("roll number : "+ rollNumber);
        System.out.println("cpi : "+ cpi);
        System.out.println("semester : "+ semester);
    }
}
class Staff extends user{
    int employeeId;
    String sectionName;
    String designation;
    Staff(int u){
        super(u);
        this.employeeId=0;
        this.sectionName="NIL";
        this.designation="NIL";
    }
    void checkDegi(user2 s1,user2 s2){
        if(s1.designation.equals(s2.designation))
        System.out.println("both staffs have the same designation");
        else
        System.out.println("both staffs have different designation");
    }
    //,int r,int s,int c,int ei, String dp, int np
    @Override
    void setDetails(String n,int d,int r,int s,int c,int e,String sn,String de,int ei, String dp, int np){
        super.setDetails(n, d, r, s, c, e, sn, de, ei, dp, np);
        employeeId=e;
        sectionName=sn;
        designation=de;
    }
    @Override
    void showDetails(int birthYear){
        super.showDetails(birthYear);
        System.out.println("employee id  : "+ employeeId);
        System.out.println("section name  : "+ sectionName);
        System.out.println("designation : "+ designation);
    }
}
class faculty extends user{
    int employeeId;
    String departmentName;
    int noOfPublications;
    faculty(int u){
        super(u);
        this.employeeId=0;
        this.departmentName="NIL";
        this.noOfPublications=0;
    }
    void checkDep(user3 d1,user3 d2){
        if(d1.departmentName.equals(d2.departmentName))
        System.out.println("both staffs have same department Name");
        else
        System.out.println("both staffs have different department Name");
    }
    //,int r,int s,int c,int e,String sn,String de,
    @Override
    void setDetails(String n,int d,int r,int s,int c,int e,String sn,String de,int ei, String dp, int np){
        super.setDetails(n, d, r, s, c, e, sn, de, ei, dp, np);
        employeeId=ei;
        departmentName=dp;
        noOfPublications=np;
    }
    @Override
    void showDetails(int birthYear){
        super.showDetails(birthYear);
        System.out.println("employee id : "+ employeeId);
        System.out.println("department name : "+ departmentName);
        System.out.println("no of publications : "+ noOfPublications);
    }
}

public class lab6 {
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        user a[]=new user [100];
        user1 b[]=new user1 [100];
        user2 c[]=new user2 [100];
        user3 d[]=new user3[100];
        int n=1,user=0,student=0,faculty=0,staff=0,i=0,j=0,k=0,l=0;
        System.out.println("\n_____welcome ____");
        while(n>0){
            System.out.println("\n1. create object for user class");
            System.out.println("2. create object for student class");
            System.out.println("3. create object for staff class");
            System.out.println("4. create object for faculty class");
            System.out.println("5. set details for user class");
            System.out.println("6. set details for student class");
            System.out.println("7. set details for staff class");
            System.out.println("8. set details for faculty class");
            System.out.println("9. show details based on user ID");
            System.out.println("10. show details based on employee ID");
            System.out.println("11. show details based on birth year");
            System.out.println("12. Check designation");
            System.out.println("13. Check department name");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice: ");
            n=s.nextInt();
            switch(n){
                case 1:
                System.out.println("enter the userid: ");
                int u=s.nextInt();
                a[i++]=new user(u);
                System.out.println("new user object created");
                break;
                case 2:
                if(i<=j+k+l){
                    System.out.println("enter the userid: ");
                    u=s.nextInt();
                    a[i++]=new user(u);
                    System.out.println("new user object created");
                }
                b[j++]=new user1(a[i].userId);
                System.out.println("new student object created");              
                break;
                case 3:
                c[k++]=new user3();
                System.out.println("new faculty object created");
                break;
                case 4:
                d[l++]=new user2();
                System.out.println("new Staff object created");
                break;

            //     case 5:
            //     System.out.println("enter the name: ");
            //     String  name=s.next();
            //     System.out.println("enter the birth year: ");
            //     int dateOfbirth=s.nextInt();
                
            //     arr1[q].setDetails( name,dateOfbirth,userid);
            //     break;
            //     case 9:
            //     System.out.println("enter the name:");
            //     String  named=s.next();
            //     System.out.println("enter the date of birth:");
            //     String dateOfbirthd=s.next();
            //     System.out.println("enter the userid:");
            //     int useridd=s.nextInt();
            //     System.out.println("enter the rollnumber:");
            //    int rollnumber=s.nextInt();
            //    System.out.println("enter the cpi:");
            //     int cpi=s.nextInt();
            //     System.out.println("enter the semester:");
            //     int semester=s.nextInt();
            //     arr2[w].setDetails(named,dateOfbirthd,useridd,rollnumber,cpi,semester,useridd);
            //     break;
            //     case 10:
            //     System.out.println("enter the name:");
            //     String  namee=s.next();
            //     System.out.println("enter the date of birth:");
            //     String dateOfbirthe=s.next();
            //     System.out.println("enter the userid:");
            //     int useride=s.nextInt();
            //     System.out.println("enter the employeeid:");
            //    int employeeid=s.nextInt();
            //    System.out.println("enter the department name:");
            //     String departmentName=s.next();
            //     System.out.println("enter the number of publications :");
            //     int noOfPublications=s.nextInt();   
            //     arr3[e].setDetails( namee,dateOfbirthe,employeeid,departmentName,noOfPublications,useride);
            //     break;
            //     case 11:
            //     System.out.println("enter the name:");
            //     String  nameq=s.next();
            //     System.out.println("enter the date of birth:");
            //     String dateOfbirthq=s.next();
            //     System.out.println("enter the userid:");
            //     int useridq=s.nextInt();
            //     System.out.println("enter the employeeid:");
            //    int employeeidq=s.nextInt();
            //     System.out.println("enter the section name:");
            //     String sectionName=s.next();
            //     System.out.println("enter the designation:");
            //     String designation=s.next();
            //     arr4[r].setDetails( nameq,dateOfbirthq,employeeidq,sectionName,designation,useridq);
            //     break;
            //     case 12:
            
}

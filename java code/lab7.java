import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
abstract class  user{
    private String name;
     String dateOfbirth;
    int userid;
    user(){
        name="NIL";
        dateOfbirth="NIL";
        userid=0;

    }
    user(int u){
        userid=u;
        name="NIL";
        dateOfbirth="NIL";


    }
    public void setDetails(String n,String dob,int uu){
        name=n;
        dateOfbirth=dob;
        userid=uu;
    }
    public void showDetails(){
        System.out.println("name : "+ name);
        System.out.println("date of birth : "+ dateOfbirth);
        System.out.println("userid : "+ userid);
        

    }



}
final class Student extends user{
     int rollnumber;
     int cpi;
     int semester;
    Student(){
        super();
        rollnumber=0;
        cpi=0;
        semester=0;

    }
    Student(int r,int c,int s,int u){
        super(u);
        rollnumber=r;
        cpi=c;
        semester=s;
    }
    final public void setDetails(String n,String dob,int uu,int r,int c,int s,int u){
        super.setDetails(n,dob,u);
        rollnumber=r;
        cpi=c;
        semester=s;

    }
    final public void showDetails(){
        super.showDetails();
        System.out.println("roll number : "+ rollnumber);
        System.out.println("cpi : "+ cpi);
        System.out.println("semester : "+ semester);
        
    }

}
final class Staff extends user{
    int employeeid;
    String sectionName;
    String designation;
    Staff(){
        employeeid=0;
        sectionName="NIL";
        designation="NIL";
    }
    Staff(int eid,int u){
        super(u);
        employeeid=eid;
        sectionName="NIL";
        designation="NIL";
        

    }
    final public void setDetails(String n,String dob,int eid,String sn,String d,int u){
        super.setDetails(n,dob,u);
         employeeid=eid;
        sectionName=sn;
         designation=d;

    }
    final public void showDetails(){
        super.showDetails();
        System.out.println("employee id  : "+ employeeid);
        System.out.println("section name  : "+ sectionName);
        System.out.println("designation : "+ designation);
        
    }
    final public static void checks(Staff s1,Staff s2){
        if(s1.designation.equals(s2.designation)){
            System.out.println("both staffs have the same designation");
        }
        else{
            System.out.println("both staffs have different designation");
        }
    }



}
final class faculty extends user{
    int employeeid;
    String departmentName;
    int noOfPublications;
    faculty(){
        employeeid=0;
        departmentName="NIL";
        noOfPublications=0;
    }
    faculty(int em,int u){
        super(u);
        employeeid=em;
        departmentName="nil";
        noOfPublications=0;
    }
    final public void setDetails(String n,String dob,int eid,String dn,int nop,int u){
        super.setDetails(n,dob,u);
         employeeid=eid;
        departmentName=dn;
         noOfPublications=nop;
         

    }
    final public void showDetails(){
        super.showDetails();
        System.out.println("employeeid : "+ employeeid);
        System.out.println("department name : "+ departmentName);
        System.out.println("no of publications : "+ noOfPublications);
        
    }
    final public static void check(faculty f1,faculty f2){
        if(f1.departmentName.equals(f2.departmentName)){
            System.out.println("both faculty have the same department");
        }
        else{
            System.out.println("both faculty have different department");
        }
    }


    


}



public class lab7 {
    public static void main(String[] args)throws Exception{
        Scanner s=new Scanner(System.in);
        user arr1[]=new user[5];
        Student arr2[]=new Student[5];
        faculty arr3[]=new faculty[5];
        Staff arr4[]=new Staff[5];
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int q=0;
        int w=0;
        int e=0;
        int r=0;

        int n=1,i=0;
        while(n>0){
            System.out.println("\n1.Object of users");
            System.out.println("2. Object of student");
            System.out.println("3. Object of faculty");
            System.out.println("4. Object of staff");
            System.out.println("5. show details by birthyear");
            System.out.println("6. show details by userid");
            System.out.println("7. show details by employeeid");
            System.out.println("8. set details for user");
            System.out.println("9. set details for student");
            System.out.println("10. set details for faculty");
            System.out.println("11. set details for staff");
            System.out.println("12. check faculty");
            System.out.println("13. check staff");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice: ");
            n=s.nextInt();
            
            switch(n){
                
                case 1:
                System.out.println("Object of an abstract class cannot be created");
                break;
                case 2:
                arr2[b]=new Student();
                w=b;
                System.out.println("new student object created");
                b++;
                break;
                case 3:
                arr3[c]=new faculty();
                e=c;
                System.out.println("new faculty object created");
                c++;
                break;
                case 4:
                arr4[d]=new Staff();
                r=d;
                System.out.println("new Staff object created");
                d++;
                break;
                case 5:
                System.out.println("enter the birthyear");
                Integer str=s.nextInt();
                for(int k=0;k<a;k++){
                    
                    if(Integer.parseInt((arr2[k].dateOfbirth).substring(6,10))==str){
                        
                        arr2[k].showDetails();
                    }
                    if(Integer.parseInt((arr3[k].dateOfbirth).substring(6,10))==str){
                        
                        arr3[k].showDetails();
                    }
                    if(Integer.parseInt((arr4[k].dateOfbirth).substring(6,10))==str){
                        
                        arr4[k].showDetails();
                    }

                }
                
                break;
                case 6:
                System.out.println("enter the userid:");
                int u=s.nextInt();
                for(int y=0;y<arr1.length;y++){
                    if(arr2[y].userid==u){
                        arr2[y].showDetails();
                        break;

                    }
                    if(arr3[y].userid==u){
                        arr3[y].showDetails();
                        break;

                    }
                    if(arr4[y].userid==u){
                        arr4[y].showDetails();
                        break;

                    }

                }

                break;
                case 7:
                System.out.println("enter the employeeid:");
                int eid=s.nextInt();
                for(int y=0;y<arr3.length;y++){
                    if(arr3[y].employeeid==eid){
                        arr3[y].showDetails();
                        break;

                    }

                }
                for(int h=0;h<arr4.length;h++){
                    if(arr4[h].employeeid==eid){
                        arr4[h].showDetails();
                        break;

                    }

                }
                
                break;
                case 8:
              System.out.println("cannot create an object for an abstract class and thus cannot set details");
              break;
                case 9:
                System.out.println("enter the name:");
                String  named=s.next();
                System.out.println("enter the date of birth:");
                String dateOfbirthd=s.next();
                System.out.println("enter the userid:");
                int useridd=s.nextInt();
                System.out.println("enter the rollnumber:");
               int rollnumber=s.nextInt();
               System.out.println("enter the cpi:");
                int cpi=s.nextInt();
                System.out.println("enter the semester:");
                int semester=s.nextInt();
                arr2[w].setDetails(named,dateOfbirthd,useridd,rollnumber,cpi,semester,useridd);
                break;
                case 10:
                System.out.println("enter the name:");
                String  namee=s.next();
                System.out.println("enter the date of birth:");
                String dateOfbirthe=s.next();
                System.out.println("enter the userid:");
                int useride=s.nextInt();
                System.out.println("enter the employeeid:");
               int employeeid=s.nextInt();
               System.out.println("enter the department name:");
                String departmentName=s.next();
                System.out.println("enter the number of publications :");
                int noOfPublications=s.nextInt();   
                arr3[e].setDetails( namee,dateOfbirthe,employeeid,departmentName,noOfPublications,useride);
                break;
                case 11:
                System.out.println("enter the name:");
                String  nameq=s.next();
                System.out.println("enter the date of birth:");
                String dateOfbirthq=s.next();
                System.out.println("enter the userid:");
                int useridq=s.nextInt();
                System.out.println("enter the employeeid:");
               int employeeidq=s.nextInt();
                System.out.println("enter the section name:");
                String sectionName=s.next();
                System.out.println("enter the designation:");
                String designation=s.next();
                arr4[r].setDetails( nameq,dateOfbirthq,employeeidq,sectionName,designation,useridq);
                break;
                case 12:
                System.out.println("enter the first id ");
                int ac1=s.nextInt();
                System.out.println("enter the second id  ");
                int ac2=s.nextInt();
                int i1=0,i2=0;
                for(int l=0;l<c;l++){
                    if(arr3[l].employeeid==ac1){
                        i1=l;
                        break;
                    }
                }
                for(int y=0;y<c && y!=i1;y++){
                    if(arr3[y].employeeid==ac2){
                        i2=y;
                        break;
                    }

                }
                faculty.check(arr3[i1],arr3[i2]);
                
                break;
                case 13:
                System.out.println("enter the first id");
                int ac11=s.nextInt();
        
                System.out.println("enter the second id  ");
                int ac22=s.nextInt();
                int i11=0,i22=0;
                for(int l=0;l<d;l++){
                    if(arr4[l].employeeid==ac11){
                        i11=l;
                        break;


                    }
                }
                for(int y=0;y<d && y!=i11;y++){
                    if(arr4[y].employeeid==ac22){
                        i22=y;
                        break;
                    }

                }
                Staff.checks(arr4[i11],arr4[i22]);
                
                break;
                case 0:
                System.exit(0);
                break;
                default:
                System.out.println("Enter correct choice\n ");                
            }
        }       
    }

    
}

//OUTPUT

// 1.Object of users
// 2. Object of student
// 3. Object of faculty
// 4. Object of staff
// 5. show details by birthyear
// 6. show details by userid
// 7. show details by employeeid
// 8. set details for user
// 9. set details for student
// 10. set details for faculty
// 11. set details for staff
// 12. check faculty
// 13. check staff
// 0. Exit
// Enter your Choice: 1
// Object of an abstract class cannot be created

// 1.Object of users
// 2. Object of student
// 3. Object of faculty
// 4. Object of staff
// 5. show details by birthyear
// 6. show details by userid
// 7. show details by employeeid
// 8. set details for user
// 9. set details for student
// 10. set details for faculty
// 11. set details for staff
// 12. check faculty
// 13. check staff
// 0. Exit
// Enter your Choice: 2
// new student object created

// 1.Object of users
// 2. Object of student
// 3. Object of faculty
// 4. Object of staff
// 5. show details by birthyear
// 6. show details by userid
// 7. show details by employeeid
// 8. set details for user
// 9. set details for student
// 10. set details for faculty
// 11. set details for staff
// 12. check faculty
// 13. check staff
// 0. Exit
// Enter your Choice: 3
// new faculty object created

// 1.Object of users
// 2. Object of student
// 3. Object of faculty
// 4. Object of staff
// 5. show details by birthyear
// 6. show details by userid
// 7. show details by employeeid
// 8. set details for user
// 9. set details for student
// 10. set details for faculty
// 11. set details for staff
// 12. check faculty
// 13. check staff
// 0. Exit
// Enter your Choice: 4
// new Staff object created

// 1.Object of users
// 2. Object of student
// 3. Object of faculty
// 4. Object of staff
// 5. show details by birthyear
// 6. show details by userid
// 7. show details by employeeid
// 8. set details for user
// 9. set details for student
// 10. set details for faculty
// 11. set details for staff
// 12. check faculty
// 13. check staff
// 0. Exit
// Enter your Choice: 8
// cannot create an object for an abstract class and thus cannot set details
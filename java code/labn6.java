import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class user{
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
class Student extends user{
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
    public void setDetails(String n,String dob,int uu,int r,int c,int s,int u){
        super.setDetails(n,dob,u);
        rollnumber=r;
        cpi=c;
        semester=s;
    }
    public void showDetails(){
        super.showDetails();
        System.out.println("roll number : "+ rollnumber);
        System.out.println("cpi : "+ cpi);
        System.out.println("semester : "+ semester);        
    }
}
class Staff extends user{
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
    public void setDetails(String n,String dob,int eid,String sn,String d,int u){
        super.setDetails(n,dob,u);
         employeeid=eid;
        sectionName=sn;
         designation=d;
    }
    public void showDetails(){
        super.showDetails();
        System.out.println("employee id  : "+ employeeid);
        System.out.println("section name  : "+ sectionName);
        System.out.println("designation : "+ designation);
        
    }
    public static void checks(Staff s1,Staff s2){
        if(s1.designation.equals(s2.designation)){
            System.out.println("both staffs have the same designation");
        }
        else{
            System.out.println("both staffs have different designation");
        }
    }
}
class faculty extends user{
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
    public void setDetails(String n,String dob,int eid,String dn,int nop,int u){
        super.setDetails(n,dob,u);
        employeeid=eid;
        departmentName=dn;
        noOfPublications=nop;
    }
    public void showDetails(){
        super.showDetails();
        System.out.println("employeeid : "+ employeeid);
        System.out.println("department name : "+ departmentName);
        System.out.println("no of publications : "+ noOfPublications);      
    }
    public static void check(faculty f1,faculty f2){
        if(f1.departmentName.equals(f2.departmentName)){
            System.out.println("both faculty have the same department");
        }
        else{
            System.out.println("both faculty have different department");
        }
    }
}



public class labn6 {
    public static void main(String[] args){
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

        int n=1;
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
                arr1[a]=new user();
                System.out.println("new user object created");
                q=a;
                a++;
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
                    
                    if(Integer.parseInt((arr1[k].dateOfbirth).substring(6,10))==str){
                        
                        arr1[k].showDetails();
                    }
                    

                }
                
                break;
                case 6:
                System.out.println("enter the userid:");
                int u=s.nextInt();
                for(int y=0;y<arr1.length;y++){
                    if(arr1[y].userid==u){
                        arr1[y].showDetails();
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
                System.out.println("enter the name:");
                String  name=s.next();
                System.out.println("enter the date of birth:");
                String dateOfbirth=s.next();
                System.out.println("enter the userid:");
                int userid=s.nextInt();
                arr1[q].setDetails( name,dateOfbirth,userid);
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
// new user object created

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
// Enter your Choice: 1
// new user object created

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
// new user object created

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
// enter the name:
// ram
// enter the date of birth:
// 10-10-2003
// enter the userid:
// 123

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
// enter the name:
// shyam
// enter the date of birth:
// 23-11-2002
// enter the userid:
// 12

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
// Enter your Choice: 9
// enter the name:
// tina
// enter the date of birth:
// 25-12-2004
// enter the userid:
// 1234
// enter the rollnumber:
// 12
// enter the cpi:
// 7
// enter the semester:
// 3

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
// Enter your Choice: 10
// enter the name:
// reena
// enter the date of birth:
// 29-02-2001
// enter the userid:
// 12345
// enter the employeeid:
// 45
// enter the department name:
// rex
// enter the number of publications :
// 2

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
// Enter your Choice: 10
// enter the name:
// riom
// enter the date of birth:
// 07-01-2000
// enter the userid:
// 1234567
// enter the employeeid:
// 46
// enter the department name:
// rex
// enter the number of publications :
// 4

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
// Enter your Choice: 11
// enter the name:
// prim
// enter the date of birth:
// 20-11-2005
// enter the userid:
// 123456
// enter the employeeid:
// 47
// enter the section name:
// ux
// enter the designation:
// chef 

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
// Enter your Choice: 11
// enter the name:
// anisha
// enter the date of birth:
// 23-12-2001
// enter the userid:
// 12345678
// enter the employeeid:
// 48
// enter the section name:
// uv
// enter the designation:
// clerk



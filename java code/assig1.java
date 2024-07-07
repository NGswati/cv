import java.util.Scanner;
public class assig1 {
    public static void main(String[] args){ 
        /*first question */
        int a=5,b=10;
        int c=a+b;
        System.out.println(c);
        int d=b-a;
        System.out.println(d);
        System.out.println("The addition of "+ a +", "+ b +" is "+ c+ " and when "+ a+" is subtracted from "+ b+", result is "+ d+"\n"  );
        
        /*second question */
        Scanner aa=new Scanner(System.in);
        System.out.print("Enter first no. :");
        int num1=aa.nextInt();
        System.out.print("Enter second no. :");
        int num2=aa.nextInt();
        System.out.print("Enter third no. :");
        int num3=aa.nextInt();
        System.out.print("Enter fourth no. :");
        int num4=aa.nextInt();
        System.out.print("Enter fifth no. :");
        int num5=aa.nextInt();
        if(num1>=num2&&num1>=num3&&num1>=num4&&num1>=num5)
        System.out.println("largest no. is "+num1);
        else if(num2>=num3&&num2>=num4&&num2>=num5)
        System.out.println("largest no. is "+num2);
        else if(num3>=num4&&num3>=num5)
        System.out.println("largest no. is "+num3);
        else if(num4>=num5)
        System.out.println("largest no. is "+num4);
        else 
        System.out.println("largest no. is "+num5);

        /*third question */
        System.out.print("\nplease enter marks from 0 to 100 only.\n");
        for(int i=1;i<6;i++){
            System.out.print("Enter marks of student "+ i+" subject 1: ");
            int mark1=aa.nextInt();
            System.out.print("Enter marks of student "+i+" subject 2: ");
            int mark2=aa.nextInt();
            System.out.print("Enter marks of student "+i+" subject 3: ");
            int mark3=aa.nextInt();
            int avg=(mark1+mark2+mark3)/3;
            if(avg>60)
            System.out.println("GOOD\n");
            else if(avg>30&&avg<=60)
            System.out.println("OK\n");
            else
            System.out.println("POOR"+"\n");
        }

        /*fourth question */
        for(int i=1;i<6;i++){
            System.out.print("Enter marks of student "+ i+" subject 1: ");
            int mark1=aa.nextInt();
            System.out.print("Enter marks of student "+i+" subject 2: ");
            int mark2=aa.nextInt();
            System.out.print("Enter marks of student "+i+" subject 3: ");
            int mark3=aa.nextInt();
            if(mark1<0){
                System.out.print("negative marks!!\n re-enter subject 1 marks: ");
                mark1=aa.nextInt();
            }
            if(mark2<0){
                System.out.print("negative marks!!\n re-enter subject 2 marks: ");
                mark2=aa.nextInt();
            }
            if(mark3<0){
                System.out.print("negative marks!!\n re-enter subject 3 marks: ");
                mark3=aa.nextInt();
            }
            int avg=(mark1+mark2+mark3)/3;
            if(avg>60)
            System.out.println("GOOD");
            else if(avg>30&&avg<=60)
            System.out.println("OK");
            else
            System.out.println("POOR");
        }

        /*fifth question */
        System.out.print("\nEnter a number: ");
        int num=aa.nextInt();
        int q=0;
        while(num!=0){
            q+=num%10;
            num/=10;
        }
        if(q<0)
        q=q*-1;
        System.out.println("sum of digit is "+q);

        /*sixth question */
        System.out.print("\nEnter a sentence : ");
        String string=aa.nextLine();
        String str=string.trim();
        int count=0;
        for(int i=0;i<str.length();i++){
            char t=str.charAt(i);
            if(t==' ')
            count++;
        }
        count++;
        System.out.println("No. of words is/are "+count);


        /*seventh question */
        System.out.println("\nEnter any integer from [12,56,78,45,20]");
        int numb=aa.nextInt();
        switch(numb){
            case 12:
            System.out.println("number is 12");
            break;
            case 56:
            System.out.println("number is 56");
            break;
            case 78:
            System.out.println("number is 78");
            break;
            case 45:
            System.out.println("number is 45");
            break;
            case 20:
            System.out.println("number is 20");
            break;
            default:
            System.out.println("Entered integer does not belong to the set.\n");
        }
    }
}



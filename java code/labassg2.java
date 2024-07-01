import java.util.Scanner;
//import java.io.*;
class c2{
    int palicheck(int n){
        int d=n,a=0;
        while(d!=0){
            a+=d%10;
            d/=10;
            a*=10;
        }
        a/=10;
        if(a==n)
        return 1;
        else 
        return 0;
    }
}

public class labassg2{
    public static void main(String args[]){
        Scanner aa=new Scanner(System.in);
        /*first question */
        System.out.print("Enter number: ");
        int a=aa.nextInt();
        int arr[]=new int[100];
        for(int i=0;i<a;i++){
            arr[i]=i+1;
        }
        int q=a,k=0;
        for(int i=0;i<a;i++){
            if(q>1){               
                arr[i++]=0;
                q--;
                arr[a++]=arr[i];
                arr[i]=0;
            }
        }
        for(int i=0;i<a;i++){
            k+=arr[i];
        }
        System.out.println("remaining element is "+k+"\n");

        /*second question */
        System.out.print("enter no. of elements: ");
        int nn=aa.nextInt();
        int []ar=new int [nn];
        System.out.print("enter elements: ");
        for (int i=0;i<nn;i++){
            ar[i]=aa.nextInt();
        }
        c2 w=new c2();
        for(int i=0;i<nn;i++){
            int y=0;
            while(y==0){
                y=w.palicheck(ar[i]);
                if(y==0)
                ar[i]++;
            }
        }
        System.out.print("output : ");
        for(int i=0;i<nn;i++){
            System.out.print(ar[i]+" ");
        }
        System.err.println("\n");

        /*third question */
        System.out.print("enter no. of students: ");
        int t=aa.nextInt();
        int []array=new int [t];
        System.out.print("enter PSC of students: ");
        for (int i=0;i<t;i++){
            array[i]=aa.nextInt();
        }
        int j=0,c=0;
        int []b=new int [t];
        for(int i=0;i<t;i++){
            if(j<i&&array[j]>array[i]){
                c++;
                j++;
                i--;
            }
            else if(j<i){
                j++;
                i--;
            }
            else{
                b[i]=c;
                j=0;
                c=0;
            }

        }
        System.out.print("output : ");
        for (int i=0;i<t;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println("\n");
    }
}
// Enter number: 5
// remaining element is 2

// enter no. of elements: 5                                             
// enter elements: 2 5 12 100 22
// output : 2 5 22 101 22 

// enter no. of students: 5
// enter PSC of students: 3 4 1 5 2
// output : 0 0 2 0 3 


import java.util.Scanner;
class Account{
    Scanner s=new Scanner(System.in);
    int accountNumber;
    String accountType;
    String serviceBranchIFSC;
    float minimumBalance;
    float availableBalance; 
    int customerID; 
    String customerName; 
    static int totalAccountCreated;
    
    Account(){
    }
    
    void setDetails (int no ,String type,String ifsc, float minb,float avlb,int id,String name ){
        accountNumber=no;
        accountType=type;
        serviceBranchIFSC=ifsc;
        minimumBalance=minb;
        availableBalance=avlb;
        customerID=id;
        customerName=name;
        totalAccountCreated++;
    }

    void updateDetails(int a){
        int n=1;
        System.out.println("\nyou can update your account here..");
        while(n>0){
            System.out.println("\n\t1. Minimum Balance ");
            System.out.println("\t2. Customer ID");
            System.out.println("\t3. Account Type");
            System.out.println("\t4. serviceBranchIFSC");
            System.out.println("\t5. availableBalance");
            System.out.println("\t6. customerName");
            System.out.println("\t0. Exit");
            System.out.print("\tEnter your Choice: ");
            n=s.nextInt();
            switch(n){
                case 1:
                System.out.print("\tEnter minimum Balance: ");
                float min = s.nextFloat();
                minimumBalance=min;
                break;
                case 2:
                System.out.print("\tEnter customer ID: ");
                int id = s.nextInt();
                customerID=id;
                break;
                case 3:
                s.nextLine();
                System.out.print("\tEnter Account type: ");
                String Account_t = s.nextLine();
                accountType=Account_t;
                break;
                case 4:
                s.nextLine();
                System.out.print("\tEnter service Branch IFSC: ");
                String ifsc = s.nextLine();
                serviceBranchIFSC=ifsc;
                break;
                case 5:
                System.out.print("\tEnter Available Balance: ");
                float avl = s.nextFloat();
                availableBalance=avl;
                break;
                case 6:
                s.nextLine();
                System.out.print("\tEnter customer Name:  ");
                String name = s.nextLine();
                customerName=name;
                break;
                case 0:
                n=0;
                break;
                default:
                System.out.println("\tEnter correct choice\n ");
            }
        }

    }

    String getDetails (int accno){
        return "\nAccount Number: "+accountNumber+
        "\nAccount Type: "+accountType+
        "\nservice Branch IFSC : "+serviceBranchIFSC+
        "\nminimum Balance : "+minimumBalance+
        "\navailable Balance : "+availableBalance+
        "\ncustomer ID : "+customerID+
        "\ncustomer Name : "+customerName;
    }
    float getBalance(int accno){
        return availableBalance;
    }
    void Deposit (int accno,float amo){
        if(accountNumber==accno){
            availableBalance+=amo;
        }  
    }
    void withdraw (int accno,float am){
        if(availableBalance>(am+minimumBalance))
        availableBalance-=am;
        else
        System.out.println("insufficient Balance!!\n Can not withdraw money");   
    } 
    static int totalAccount(){
        return totalAccountCreated;
    } 
}

public class labassn4 {
    
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        Account a[]=new Account [100];        
        Account b=new Account() ;
        int n=1,i=0;
        System.out.println("\n_____welcome to Banking Application System____");
        while(n>0){
            System.out.println("\n1. Set Details");
            System.out.println("2. Get Details");
            System.out.println("3. Update Details");
            System.out.println("4. Get Balance");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Total Account");
            System.out.println("0. Exit");
            System.out.print("Enter your Choice: ");
            n=s.nextInt();
            switch(n){
                case 1:
                System.out.print("Enter account Number:  ");
                int accno = s.nextInt();              
                s.nextLine();
                System.out.print("Enter Account type: ");
                String Account_t = s.nextLine();
                System.out.print("Enter service Branch IFSC: ");
                String ifsc = s.nextLine();
                System.out.print("Enter minimum Balance: ");
                float min = s.nextFloat();
                System.out.print("Enter Available Balance: ");
                float avl = s.nextFloat();
                System.out.print("Enter customer ID: ");
                int id = s.nextInt();
                s.nextLine();
                System.out.print("Enter customer Name:  ");
                String name = s.nextLine();
              
                a[i] = new Account();
                a[i].setDetails(accno, Account_t,ifsc, min,avl,id, name);  
                i++;             
                break;

                case 2:
                System.out.print("Enter account Number: ");
                int idd = s.nextInt();
                int u=0;
                for(int j=0;j<i;j++){
                    if(a[j].accountNumber==idd){
                        System.out.println( a[j].getDetails(idd));
                        u=1;
                        break;
                    }   
                }
                if(u==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                
                case 3:
                System.out.print("Enter account Number: ");
                int iddd = s.nextInt();
                int ui=0;
                for(int j=0;j<i;j++){
                    if(a[j].accountNumber==iddd){
                        a[j].updateDetails(iddd);
                        ui=1;
                        break;
                    }   
                }
                if(ui==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 4:
                System.out.print("Enter accountNumber: ");
                int didd = s.nextInt();
                int iui=0;
                for(int j=0;j<i;j++){
                    if(a[j].accountNumber==didd){
                        System.out.println("Balance : "+a[j].getBalance(didd));
                        iui=1;
                        break;
                    }   
                }
                if(iui==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 5:
                System.out.print("Enter accountNumber: ");
                int id1 = s.nextInt();
                System.out.print("Enter amount to be deposited : ");
                float am = s.nextFloat();
                int ii=0;
                for(int j=0;j<i;j++){
                    if(a[j].accountNumber==id1){
                        a[j].Deposit(id1,am);
                        ii=1;
                        break;
                    }   
                }
                if(ii==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 6:
                System.out.print("Enter accountNumber: ");
                int id2 = s.nextInt();
                System.out.print("Enter amount for withdrawn: ");
                float amm = s.nextFloat();
                int iii=0;
                for(int j=0;j<i;j++){
                    if(a[j].accountNumber==id2){
                        a[j].withdraw(id2,amm);
                        iii=1;
                        break;
                    }   
                }
                if(iii==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 7:
                System.out.print("Total account: "+b.totalAccount());
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


// OUTPUT

// _____welcome to Banking Application System____

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 1
// Enter account Number:  34
// Enter Account type: curr
// Enter service Branch IFSC: ifgt1234
// Enter minimum Balance: 123
// Enter Available Balance: 2000
// Enter customer ID: 12
// Enter customer Name:  bonita

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 7
// Total account: 1
// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 2
// Enter account Number: 34

// Account Number: 34
// Account Type: curr
// service Branch IFSC : ifgt1234
// minimum Balance : 123.0
// available Balance : 2000.0
// customer ID : 12
// customer Name : bonita

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 3
// Enter account Number: 34

// you can update your account here..

//      1. Minimum Balance 
//      2. Customer ID
//      3. Account Type
//      4. serviceBranchIFSC
//      5. availableBalance
//      6. customerName
//      0. Exit
//      Enter your Choice: 5
//      Enter Available Balance: 2334

//      1. Minimum Balance 
//      2. Customer ID
//      3. Account Type
//      4. serviceBranchIFSC
//      5. availableBalance
//      6. customerName
//      0. Exit
//      Enter your Choice: 0

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 5
// Enter accountNumber: 34 
// Enter amount to be deposited : 400

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 4
// Enter accountNumber: 34
// Balance : 2734.0

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 5
// Enter accountNumber: 34
// Enter amount to be deposited : 67

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 5
// Enter accountNumber: 23
// Enter amount to be deposited : 253
// Account of this account Number is not present 

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 6
// Enter accountNumber: 34
// Enter amount for withdrawn: 467

// 1. Set Details
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 0. Exit
// Enter your Choice: 0
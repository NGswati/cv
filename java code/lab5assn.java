import java.util.ArrayList;
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
        System.out.println("\nAn account is created\n");
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
        // if(accountNumber==accno){
            
        // }
        availableBalance+=amo;  
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
    static void compare(Account a1,Account a2){
        if(a1.availableBalance>a2.availableBalance){
            System.out.println("1st account has more money than 2nd account");
        }
        else{
            System.out.println("2nd account has more money than 1st account");
        }
        System.out.println(totalAccountCreated);
    }
    static void delete(Account v,ArrayList<Account>a){
        a.remove(v);
        totalAccountCreated--;
    } 
}



public class lab5assn {
    
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        ArrayList<Account> a=new ArrayList<Account>(100) ;        
        
        int n=1,i=0;
        System.out.println("\n_____welcome to Banking Application System____");
        while(n>0){
            System.out.println("\n1. Set Details or Creating a new account");
            System.out.println("2. Get Details");
            System.out.println("3. Update Details");
            System.out.println("4. Get Balance");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Total Account");
            System.out.println("8. compare accounts");
            System.out.println("9. delete account");
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
                Account b=new Account() ;

                b.setDetails(accno, Account_t,ifsc, min,avl,id, name);  
                a.add(b);
                i++;             
                break;

                case 2:
                System.out.print("Enter account Number: ");
                int idd = s.nextInt();
                int u=0;
                for(int j=0;j<i;j++){
                    if(a.get(j).accountNumber==idd){
                        System.out.println( a.get(j).getDetails(idd));
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
                    if(a.get(j).accountNumber==iddd){
                        a.get(j).updateDetails(iddd);
                        ui=1;
                        break;
                    }   
                }
                if(ui==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 4:
                System.out.print("Enter account Number: ");
                int didd = s.nextInt();
                int iui=0;
                for(int j=0;j<i;j++){
                    if(a.get(j).accountNumber==didd){
                        System.out.println("Balance : "+a.get(j).getBalance(didd));
                        iui=1;
                        break;
                    }   
                }
                if(iui==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 5:
                System.out.print("Enter account Number: ");
                int id1 = s.nextInt();
                System.out.print("Enter amount to be deposited : ");
                float am = s.nextFloat();
                int ii=0;
                for(int j=0;j<i;j++){
                    if(a.get(j).accountNumber==id1){
                        a.get(j).Deposit(id1,am);
                        ii=1;
                        break;
                    }   
                }
                if(ii==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 6:
                System.out.print("Enter account Number: ");
                int id2 = s.nextInt();
                System.out.print("Enter amount for withdrawn: ");
                float amm = s.nextFloat();
                int iii=0;
                for(int j=0;j<i;j++){
                    if(a.get(j).accountNumber==id2){
                        a.get(j).withdraw(id2,amm);
                        iii=1;
                        break;
                    }   
                }
                if(iii==0){
                System.out.println("Account of this account Number is not present ");               
                }
                break;
                case 7:
                System.out.println("Total account: "+Account.totalAccount());
                break;

                case 8:
                System.out.print("Enter the first acount number: ");
                int ac1=s.nextInt();
                System.out.print("Enter the second acount number: ");
                int ac2=s.nextInt();

                int i1=-1,i2=-1;
                for(int l=0;l<i;l++){
                    if(a.get(l).accountNumber==ac1){
                        i1=l;
                        break;
                    }
                }
                for(int y=0;y<i && y!=i1;y++){
                    if(a.get(y).accountNumber==ac2){
                        i2=y;
                        break;
                    }
                }
                if(i1>=0&&i2>=0){
                    Account.compare(a.get(i1),a.get(i2));
                    System.out.println("\n");
                }
                else 
                System.out.println("Account of this account Number 1or 2 is not present");
                break;
                case 9:
                System.out.print("Enter account Number: ");
                int ac9=s.nextInt();
        
                for(int m=0;m<i;m++){
                    if(a.get(m).accountNumber==ac9){
                        Account.delete(a.get(m),a);
                        i--;
                        break;
                    }
                }
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

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 1
// Enter account Number:  123
// Enter Account type: reserve
// Enter service Branch IFSC: werq123
// Enter minimum Balance: 1234
// Enter Available Balance: 232
// Enter customer ID: 78
// Enter customer Name:  ram

// An account is created


// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 1
// Enter account Number:  234
// Enter Account type: current
// Enter service Branch IFSC: 234gs     
// Enter minimum Balance: 4562
// Enter Available Balance: 363
// Enter customer ID: 24
// Enter customer Name:  rita

// An account is created


// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 2
// Enter account Number: 234

// Account Number: 234
// Account Type: current
// service Branch IFSC : 234gs
// minimum Balance : 4562.0
// available Balance : 363.0
// customer ID : 24
// customer Name : rita

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 3
// Enter account Number: 123

// you can update your account here..

//         1. Minimum Balance 
//         2. Customer ID
//         3. Account Type
//         4. serviceBranchIFSC
//         5. availableBalance
//         6. customerName
//         0. Exit
//         Enter your Choice: 5
//         Enter Available Balance: 678

//         1. Minimum Balance 
//         2. Customer ID
//         3. Account Type
//         4. serviceBranchIFSC
//         5. availableBalance
//         6. customerName
//         0. Exit
//         Enter your Choice: 0

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 4
// Enter account Number: 234
// Balance : 363.0

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 5
// Enter account Number: 234
// Enter amount to be deposited : 65 

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 6
// Enter account Number: 234
// Enter amount for withdrawn: 8
// insufficient Balance!!
//  Can not withdraw money

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 7
// Total account: 2
// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 8
// Enter the first acount number: 127
// Enter the second acount number: 234
// Account of this account Number 1or 2 is not present

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 9
// Enter account Number: 126

// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 8
// Enter the first acount number: 234
// Enter the second acount number: 123
// 2nd account has more money than 1st account


// 1. Set Details or Creating a new account
// 2. Get Details
// 3. Update Details
// 4. Get Balance
// 5. Deposit
// 6. Withdraw
// 7. Total Account
// 8. compare accounts
// 9. delete account
// 0. Exit
// Enter your Choice: 0

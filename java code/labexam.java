import java.util.ArrayList;
import java.util.Scanner;

class user{
    int userId;
    String name;
    String dateOfBirth;
    String address;
    String PAN;

    
}
class admin extends user{
    Scanner s=new Scanner(System.in);
    
    String dateOfJoining;
    int salary;
    String permissibleOperations;
    void addNewStock(item i,ArrayList a){
        a.add(i);
    }
    int deleteStock(int itemcode,ArrayList a){
        for(int x=0;x<a.size();x++){
            if((a.get(x).itemCode)==itemcode){ //unknown error
                a.remove(x);
                return 0;
            }
        }
        return 1;
    }
    void modifyStock(int i,item it,ArrayList a){
        for(int x=0;x<a.size();x++){
            // if(a.get(x).itemCode==i){  //unknown error
            //     System.out.print("Enter item code: ");
            //     int ic=s.nextInt();
            //     System.out.print("Enter price: ");
            //     int price=s.nextInt();
            //     System.out.print("Enter available Quantity: ");
            //     int availableQty=s.nextInt();
            //     it.setDetails(ic, price, availableQty);          
            // }
        }
    }
}
class general extends user{
    String dateOfJoining;
    int salary;
    int dutyHourPerDay;
    void sellItem(int ic,int quan){

    }
    void returnItem(int ic,int quan){

    }
    void displayStock(int ic){

    }
    void displaySell(String sd,String ed){

    }
}
class item{
    public int itemCode;
    int price;
    int availableQty;
    void setDetails (int i,int p,int a){
        itemCode=i;
        price=p;
        availableQty=a;
    }
    
}

class foodItem extends item{
    String dateOfExpiry;
    
}
class nonFoodItem extends item{
    int returnCount;
    
}
class sell{
    String dateOfSell;
    int itemCode;
    int quantity;
    float totalAmount;
}
class Return{
    String dateOfReturn;
    int itemCode;
    int quantity;
    float returnAmount;
}

public class labexam {
    public static void main(String [] args){
        
        ArrayList<item> a=new ArrayList<item>(100);
        admin admin=new admin();
        general gen=new general();
        item item=new item();
        Scanner s=new Scanner(System.in);
        int n=1,xyz,x,flag=0;
        while(n>0){
            System.out.println("\n1. To add New Stock");
            System.out.println("2. To delete Stock ");
            System.out.println("3. To modify Stock");
            System.out.println("4. To Sell Item");
            System.out.println("5. To return Item");
            System.out.println("6. To display stock");
            System.out.println("7. To display Sell ");
            System.out.println("0. Exit ");
            System.out.print("\tEnter your Choice: ");
            n=s.nextInt();
            switch(n){
                case 1:
                System.out.print("Enter item code: ");
                int ic=s.nextInt();
                System.out.print("Enter price: ");
                int price=s.nextInt();
                System.out.print("Enter available Quantity: ");
                int availableQty=s.nextInt();
                item.setDetails(ic,price,availableQty);
                admin.addNewStock(item,a);
                System.out.print("New User is Added ");
                break;
                case 2:
                System.out.println("Enter itemcode: ");
                xyz=s.nextInt();   
                flag=admin.deleteStock(xyz,a);
                if(flag==1)
                System.out.println("item of this itemcode is not present");
                else 
                System.out.println("item deleted");
                System.out.println(a.size());
                flag=0;
                break;
                case 3:
                System.out.println("Enter itemcode: ");
                xyz=s.nextInt();   
                admin.modifyStock(xyz,item,a);
                System.out.println("modified");
                break;
                case 4:
                System.out.println("Enter itemcode: ");
                xyz=s.nextInt();
                System.out.println("Enter quantity: ");
                x=s.nextInt();
                gen.sellItem(xyz,x);
                break;
                case 5:
                System.out.println("Enter itemcode: ");
                xyz=s.nextInt();
                System.out.println("Enter quantity: ");
                x=s.nextInt();
                break;
                case 6:
                System.out.println("Enter itemcode: ");
                xyz=s.nextInt();
                break;
                case 7:
                break;
                case 0:
                n=0;
                System.out.println("code exit");
                break;
                default:
                System.out.println("Enter correct choice");
                
            }
        }
    }
}
//output
// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 1
// Enter item code: 12
// Enter price: 134
// Enter available Quantity: 25
// New User is Added 
// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 2
// Enter itemcode: 
// 34
// item of this itemcode is not present
// 1

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 3
// Enter itemcode: 
// 23
// modified

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 4
// Enter itemcode: 
// 12 
// Enter quantity: 
// 25

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 0 
// code exit
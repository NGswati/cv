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
    void deleteStock(item i,ArrayList a){
        a.remove(i);
    }
    void modifyStock(item i,ArrayList a){
        System.out.print("Enter price: ");
        int price=s.nextInt();
        System.out.print("Enter available Quantity: ");
        int availableQty=s.nextInt();
        i.setDetails(i.itemCode,price, availableQty);          
    }
}
class general extends user{
    Scanner s=new Scanner(System.in);

    String dateOfJoining;
    int salary;
    int dutyHourPerDay;
    void sellItem(item i,int quan){
        if(i.availableQty> quan){
            i.setDetails(i.itemCode,i.price,i.availableQty-quan);
            System.out.println("total amount to be paid: "+(quan*i.price));
        }
        else{
            System.out.println("available quantity is not sufficient  ");
        }
    }
    void returnItem(item i,int quan){
        System.out.println("Enter 1. Non food item\n 2. food item ");
        int type=s.nextInt();
        try {
            if(type==1){
                i.setDetails(i.itemCode,i.price,i.availableQty+quan);
                System.out.println("Item returned");
            }
            else{
                System.out.println(1/0);
            }
        } 
        catch (ArithmeticException t) {
            System.out.println("FoodItemReturnException");
        }
    }
    void displayStock(item i){
        System.out.println("Item code:  "+i.itemCode);
        System.out.println("Price : "+i.price);
        System.out.println("available quantity : "+i.availableQty);
    }
    void displaySell(sell sl){
        
        System.out.println("date of sell :  "+sl.dateOfSell);
        System.out.println("Item code:  "+sl.itemCode);
        System.out.println("quantity : "+sl.quantity);
        System.out.println("Total amount  : "+sl.totalAmount);
    }
}
class item{
    int itemCode;
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
    int dateOfSell;
    int itemCode;
    int quantity;
    float totalAmount;
    void setDetails (int d,int i,int q,float t){
        dateOfSell=d;
        itemCode=i;
        quantity=q;
        totalAmount=t;
    }
}
class Return{
    String dateOfReturn;
    int itemCode;
    int quantity;
    float returnAmount;
}

public class lab9exception {
    public static void main(String [] args){
        
        ArrayList<item> a=new ArrayList<item>();
        ArrayList<sell> sl=new ArrayList<sell>();
        admin admin=new admin();
        general gen=new general();
        item item=new item();
        sell sell=new sell(); 
        Scanner s=new Scanner(System.in);
        int n=1,xyz,x,y,z,flag=0;
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
                int ic;
                try {
                    System.out.print("Enter item code: ");
                    ic=s.nextInt();
                    for(x=0;x<a.size();x++){
                        if(a.get(x).itemCode==ic){
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1){
                    System.out.print( 1/0);
                    }
                } catch (ArithmeticException e) {
                    System.out.print("Re-Enter item code: ");
                    ic=s.nextInt();
                }
                flag=0;
                System.out.print("Enter price: ");
                int price=s.nextInt();
                System.out.print("Enter available Quantity: ");
                int availableQty=s.nextInt();
                item.setDetails(ic,price,availableQty);
                admin.addNewStock(item,a);
                System.out.println("New User is Added ");
                System.out.println(a.size());
                break;
                case 2:
                System.out.println(a.size());
                System.out.print("Enter itemcode: ");
                xyz=s.nextInt();   
                for(x=0;x<a.size();x++){
                    if(a.get(x).itemCode==xyz){
                        flag=1;
                        break;
                    }
                }
                try {
                    if(flag==1){
                        admin.deleteStock(a.get(x),a);
                        System.out.println("item deleted");
                    }
                    else
                    System.out.println(1/0);
                } catch (ArithmeticException e) {
                    System.out.println("item of this itemcode is not present");
                }
                System.out.println(a.size());
                flag=0;
                break;
                case 3:
                System.out.print("Enter itemcode: ");
                xyz=s.nextInt();
                for(x=0;x<a.size();x++){
                    if(a.get(x).itemCode==xyz){    
                        flag=1;
                        break;         
                    }
                }   
                try {
                    if(flag==1){
                        admin.modifyStock(a.get(x),a);
                        System.out.println("item modified");
                    }
                    else
                    System.out.println(1/0);

                } catch (ArithmeticException e) {
                    System.out.println("item of this itemcode is not present");
                }
                System.out.println(a.size());
                break;
                case 4:
                System.out.print("Enter itemcode: ");
                xyz=s.nextInt();
                System.out.print("Enter quantity: ");
                y=s.nextInt();
                for(x=0;x<a.size();x++){
                    if(a.get(x).itemCode==xyz){    
                        flag=1;
                        break;         
                    }
                } 
                gen.sellItem(a.get(x),y);
                System.out.print("Enter date of sell (ddmmyyyy): ");
                z=s.nextInt();
                sell.setDetails(z,xyz, y, a.get(x).price*y);
                sl.add(sell);
                break;
                case 5:
                System.out.print("Enter itemcode: ");
                xyz=s.nextInt();
                System.out.print("Enter quantity: ");
                y=s.nextInt();
                for(x=0;x<a.size();x++){
                    if(a.get(x).itemCode==xyz){    
                        flag=1;
                        break;         
                    }
                } 
                gen.returnItem(a.get(x),y);
                break;
                case 6:
                System.out.print("Enter itemcode: ");
                xyz=s.nextInt();
                for(x=0;x<a.size();x++){
                    if(a.get(x).itemCode==xyz){    
                        flag=1;
                        break;         
                    }
                } 
                gen.displayStock(a.get(x));
                break;
                case 7:
                System.out.print("Enter strating date: ");
                x=s.nextInt();
                System.out.print("Enter end date: ");
                y=s.nextInt();
                try {
                    if((y%10000)==(x%10000)&&(((y%1000000)/10000)-((x%1000000)/10000))<60000){
                        if(x>=1011000&&x<31092023&&y>=1011000&&y<31092023){
                            for(int i=0;i<sl.size();i++){
                                if(sl.get(i).dateOfSell<y&&sl.get(i).dateOfSell>=x){
                                    gen.displaySell(sl.get(i));
                                }
                            }
                        }
                        else{
                            System.out.print("Enter correct date ");
                        }
                    }
                    else
                    System.out.print("1/0");
                } catch (ArithmeticException e) {
                    System.out.print("date range cannot be more than 6 months. "); 
                }
                
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

// output
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
// Enter price: 2
// Enter available Quantity: 12
// New User is Added 
// 1

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 1
// Enter item code: 45
// Enter price: 12
// Enter available Quantity: 34
// New User is Added 
// 2

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 1
// Enter item code: 23
// Enter price: 2
// Enter available Quantity: 2
// New User is Added 
// 3

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
// Enter price: 45
// Enter available Quantity: 1
// New User is Added 
// 4

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 2
// 4
// Enter itemcode: 12
// item deleted
// 3

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 2
// 3
// Enter itemcode: 7
// item of this itemcode is not present
// 3

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 3
// Enter itemcode: 2
// item of this itemcode is not present
// 3


// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 3
// Enter itemcode: 12
// Enter price: 45
// Enter available Quantity: 7
// item modified
// 3

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 4
// Enter itemcode: 12
// Enter quantity: 39
// available quantity is not sufficient  
// Enter date of sell (ddmmyyyy): 12012002

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 5
// Enter itemcode: 12
// Enter quantity: 34
// Enter 1. Non food item
//  2. food item 
// 1
// Item returned

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 6
// Enter itemcode: 12
// Item code:  12
// Price : 45
// available quantity : 41

// 1. To add New Stock
// 2. To delete Stock 
// 3. To modify Stock
// 4. To Sell Item
// 5. To return Item
// 6. To display stock
// 7. To display Sell 
// 0. Exit 
//         Enter your Choice: 7
// Enter strating date: 11012002
// Enter end date: 13022002
// date of sell :  12012002
// Item code:  12
// quantity : 39
// Total amount  : 1755.0

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
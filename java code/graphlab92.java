import java.util.Scanner;
import java.util.ArrayList;

class cug{
    int arr[]=new int [10];
    int noc;
    int ar[]=new int[10];
    Scanner s=new Scanner(System.in);
    ArrayList<Integer> bfsOfGraph(int n,ArrayList<ArrayList<Integer>> b ){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean visited[] = new boolean[n];
        noc=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                arr[noc++]=i;
                ArrayList<Integer> q=new ArrayList<>();
                q.add(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    Integer node=q.remove(0);
                    bfs.add(node);
                    for(Integer j:b.get(node)){
                        if(visited[j]==false){
                            visited[j]=true;
                            q.add(j);
                        }
                    }
                }
            }
        }
        return bfs;
    }
    void connectedComp(ArrayList<ArrayList<Integer>> b,int n){
        ArrayList<Integer> bog=bfsOfGraph(n,b);
        ArrayList<ArrayList<Integer>> ele=new ArrayList<ArrayList<Integer>>(n);
        System.out.println("\nNo. of Connected component : "+noc);
        int p=0;
        for (int i = 0; i < noc; i++)
            ele.add(new ArrayList<Integer>());
        for(int i=0;i<bog.size();i++){
            int j=bog.get(i);
            if(j==arr[p+1])
            p++;
            ele.get(p).add(j);
        }
        System.out.print("Connected Components are:");
        p=0;
        for(int i=0;i<ele.size(); i++) {
            for(int j=0;j<ele.get(i).size();j++) {
                int d=ele.get(i).get(j)+1;
                ar[p++]=i;
                System.out.print("  "+d);
            }
            System.out.println();
        }
        int next=1;
        while(next==1){
            System.out.println("checking connected or not");
            System.out.print("Enter vertex 1 :");
            int v=s.nextInt();
            System.out.print("Enter vertex 2 :");
            int u=s.nextInt();
            if(ar[u-1]==ar[v-1])
            System.out.println("both the nodes are in the same component ");
            else
            System.out.println("both the nodes are not in the same component");
            System.out.print("Check more(1/any): ");
            next=s.nextInt();
        }
    }
}
public class graphlab92 {
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no. of rows/columns: ");
        int n=s.nextInt();
        cug c=new cug();
        ArrayList<ArrayList<Integer>> b=new ArrayList<ArrayList<Integer>>(n);
        System.out.println("Enter values in list  ");
        for(int i=0;i<n;i++){
            b.add(new ArrayList<Integer>(n));
        }
        int d=1;
        while(d==1){
            System.out.print("Enter the vertex 1 : ");
            int d2=s.nextInt();
            System.out.print("Enter the vertex 2 : ");
            int d1=s.nextInt();
            b.get(d2-1).add(d1-1);
            b.get(d1-1).add(d2-1);
            System.out.print("more edge (1/any): ");
            d=s.nextInt();
        }
        c.connectedComp(b,n);
    }
}

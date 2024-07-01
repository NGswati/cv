import java.util.*;
import java.util.Comparator;
import java.util.Collection;
class point{
    public int x;
    public  int y;
    public int w;
    point(){}
    point (int a,int b,int c){
        x=a;
        y=b;
        w=c;
    }
}
class p{
    int key;
    p parent;

}
class WComparator implements Comparator<point> {
    // override the compare() method
    public int compare(point s1, point s2){
        if (s1.w == s2.w)
            return 0;
        else if (s1.w > s2.w)
            return 1;
        else
            return -1;
    }
}
public class kr3{
    ArrayList<ArrayList<Integer>>A=new ArrayList<ArrayList<Integer>>();
   
    static void printgraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print("-> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void addedge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);    
    }
    static int sum=0;
    public static ArrayList<ArrayList<p>> Prim(ArrayList<ArrayList<p>> adj,ArrayList<point>W,p v){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                adj.get(i).get(j).key=1900;
                adj.get(i).get(j).parent=null;
            }
        }
        v.key=0;
        PriorityQueue pq=new PriorityQueue<>();
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                pq.add( adj.get(i).get(j));
            }
        }
    }
   
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int v=s.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());

        for(int i=0;i<v;i++)
            adj.get(i).add(i);
        
       
        System.out.println("enter the number of edges:");
        int e=s.nextInt();
        ArrayList<point> we=new ArrayList<point>();
        for(int i=0;i<e;i++){
            System.out.println("enter the nodes in between you have the edge");
            int q=s.nextInt();
            int w=s.nextInt();
            System.out.println("enter the weight of the edge ");
            int qq=s.nextInt();
            point p=new point(q,w,qq);
            we.add(p);
            addedge(adj,q,w);
        }
        printgraph(adj);
        ArrayList<ArrayList<Integer>> ad=new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++){
            ad.add(new ArrayList<Integer>());
            
        }
        for(int i=0;i<v;i++){
            ad.get(i).add(i);
            
        }
        
        ArrayList<ArrayList<Integer>> x=Prim(ad,we);
        printgraph(x);

    }

    
    
}

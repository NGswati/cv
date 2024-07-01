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
public class kr2 {
    ArrayList<ArrayList<Integer>>A=new ArrayList<ArrayList<Integer>>();
    static LinkedList arr=new LinkedList();
    public static LinkedList makeset(){
        for(int i=0;i<20;i++){
            arr.add(i);
        }
        return arr;

    }
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
    public static int find (int a){
        int d=(int)arr.get(a);
        if(d==a){
            return a;
        }
        return find(d);

    }
    public static void union(int a,int b){

            int x=find(a);
            int y=find(b);
            if(x!=y){
                Object t=(Integer) x;
                arr.set(y,t);
            }
        
    }
    static int sum=0;
    public static ArrayList<ArrayList<Integer>> Kruskal(ArrayList<ArrayList<Integer>> adj,ArrayList<point>ww){
        arr=makeset();
        Collections.sort(ww,new WComparator());
        for(int i=0;i<ww.size();i++){
            System.out.println(ww.get(i).x+" "+ ww.get(i).y+" "+ ww.get(i).w);
        }
        for(int i=0;i<ww.size();i++){
            int u=ww.get(i).x;
            int v=ww.get(i).y;
            if(find(ww.get(i).x)!=find(ww.get(i).y)){
                sum+=ww.get(i).w;
                addedge(adj,u,v);
                union(u,v);
            }
        }
        System.out.println("the total weight of the minimum spanning tree is:"+sum);
        return adj;
        
        


    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int v=s.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
            
        }
        for(int i=0;i<v;i++){
            adj.get(i).add(i);
            
        }
        
       
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
        ArrayList<ArrayList<Integer>> x=Kruskal(ad,we);
        printgraph(x);
    }   
}
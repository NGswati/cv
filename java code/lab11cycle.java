import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int u;
    int v;
    int weight;
    Node(int uu,int vv,int w){
        u=uu;
        v=vv;
        weight=w;
    }
    Node(){}
    int getV(){
        return v;
    }
    int getU(){
        return u;
    }
    int getWeight(){
        return weight;
    }
}
public class lab11cycle {

    void bellmanford(ArrayList<Node> a,int n,int src){
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        dist[i]=10000000;
        dist[src]=0;
        for(int i=1;i<n;i++){
            for(Node node: a){
                if((dist[node.getU()]+node.getWeight()<dist[node.getV()])&&dist[node.getU()]<10000000){
                    dist[node.getV()]=dist[node.getU()]+node.getWeight();
                }
            }
        }
        int flag=0,f=0;
        for(Node node: a){
            if(dist[node.getU()]+node.getWeight()<dist[node.getV()] && dist[node.getU()] < 10000000){
                flag=1;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==10000000){
                f = 1;
                break;
            }
        }
        if (flag == 1) {
            if(f==0)
            System.out.print((src + 1) + " ");
        }
    }
    public static void main(String []args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no. of Vertex: ");
        int N=s.nextInt();
        ArrayList<Node> a=new ArrayList<Node>();
        int n=1,u,v,w;
        while(n==1){
            System.out.print("Enter U: ");
            u=s.nextInt();
            System.out.print("Enter V: ");
            v= s.nextInt();
            System.out.print("Enter Weight: ");
            w = s.nextInt();
            a.add(new Node(u-1,v-1,w));
            System.out.print("Want to enter more nodes?(1/any): ");
            n= s.nextInt();
        }
        lab11cycle b=new lab11cycle();
        System.out.print("negative weight cycle is reachable form: ");
        for(int i=0;i<N;i++){
            b.bellmanford(a,N,i);
        }
        System.out.println();
    }
}
//3 1 2 -10 1 2 3 3 1 3 1 1 2
// 4 1 2 3 1 2 3 4 1 3 4 5 1 4 1 2 1 1 3 -10 2
//4 1 2 3 1 3 2 4 1 3 4 5 1 4 1 2 1 1 3 -10 2

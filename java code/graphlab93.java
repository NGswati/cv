import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

class cdg{
    int noc;
    int no;
    ArrayList<Integer> bfsOfGraph(int n,ArrayList<ArrayList<Integer>> b,int v ){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean visited[] = new boolean[n];
        noc=0;
        for(int i=0;i<n;i++){
            if(visited[(i+v)%n]==false){
                noc++;
                ArrayList<Integer> q=new ArrayList<>();
                q.add((i+v)%n);
                visited[(i+v)%n]=true;
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
    ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> b,int n){
        ArrayList<ArrayList<Integer>> bt=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            bt.add(new ArrayList<Integer>(n));
        }
        for(int i=0;i<b.size(); i++) {
            for(int j=0;j<b.get(i).size();j++) {
                int d=b.get(i).get(j);
                bt.get(d).add(i);
            }
        }
        System.out.println("transpose of given Graph ~");
        for(int i=0;i<bt.size(); i++) {
            int c=i+1;
            System.out.print("["+c+"]");
            for(int j=0;j<bt.get(i).size();j++) {
                int d=bt.get(i).get(j)+1;
                System.out.print("->"+d);
            }
            System.out.println();
        }
        return bt;
    }
    void stronglyConnectedBrute(ArrayList<ArrayList<Integer>> b,int n){
        int t=0,max=0;
        for(int i=0;i<n;i++){
            bfsOfGraph(n,b,i);
            if(noc>1)
            t=1;
            if(noc>max)
            max=noc;
        }
        if(t==0)
        System.out.println("Strongly connected");
        else
        System.out.println("Not strongly connected");
        System.out.println("no. of strongly connected component: "+max);
    }
    void weaklyConnected(ArrayList<ArrayList<Integer>> b,int n){//reverse procd
        for(int i=0;i<b.size(); i++) {
            for(int j=0;j<b.get(i).size();j++) {
                int d=b.get(i).get(j);
                b.get(d).add(i);
            }
        }
        for(int i=0;i<b.size(); i++) {
            int c=i+1;
            System.out.print("["+c+"]");
            for(int j=0;j<b.get(i).size();j++) {
                int d=b.get(i).get(j)+1;
                System.out.print("->"+d);
            }
            System.out.println();
        }
        bfsOfGraph(n,b,0);
        if(noc==1)
        System.out.println("Weakly Connected");
        else
        System.out.println("Not weakly Connected");
    }
    void dfs(int node,Stack<Integer> st,ArrayList<ArrayList<Integer>> b,int vis[]){
        vis[node]=1;
        for(Integer it:b.get(node)){
            if(vis[it]==0)
            dfs(it,st,b,vis);
        }
        st.push(node);
    }
    void revdfs(int node,ArrayList<ArrayList<Integer>> bt,int vis[]){
        vis[node]=1;
        System.out.print((node+1)+" ");
        for(Integer it:bt.get(node)){
            if(vis[it]==0)
            revdfs(it,bt,vis);
        }
    }
    void stronglyConnectedtransposeKR(ArrayList<ArrayList<Integer>> b,int n){
        int visit[]=new int[n];
        int vis[]=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(visit[i]==0)
            dfs(i,st,b,visit);
        }
        ArrayList<ArrayList<Integer>> bt=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            bt.add(new ArrayList<Integer>(n));
        }
        for(int i=0;i<b.size(); i++) {
            for(int j=0;j<b.get(i).size();j++) {
                int d=b.get(i).get(j);
                bt.get(d).add(i);
            }
        }
        no=0;
        while(st.size()>0){
            int node=st.peek();
            st.pop();
            if(vis[node]==0){
                no++;
                System.out.print("Strongly Connected components: ");
                revdfs(node,bt,vis);
                System.out.println();                
            }
        }
        if(no==1)
        System.out.println("\nStrongly connected");
        else
        System.out.println("\nNot strongly connected");
        System.out.println("no of Strongly Connected component : "+no);
    }
}

public class graphlab93 {
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no. of rows/columns: ");
        int n=s.nextInt();
        cdg c=new cdg();
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
            System.out.print("more edge (1/any): ");
            d=s.nextInt();
        }
        System.out.println();
        c.transpose(b,n);
        System.out.println();
        c.stronglyConnectedBrute(b, n);
        System.out.println();
        c.weaklyConnected(b,n);
        System.out.println();
        c.stronglyConnectedtransposeKR(b,n);
    }
}
//8 1 2 1 2 5 1 5 1 1 3 4 1 4 3 1 6 7 1 7 6 2
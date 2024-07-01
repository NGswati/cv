import java.util.Scanner;
//brute force prim algo
public class prim1 {
    static int V;
    static int sum=0;
    static int minKey(int key[],boolean MST[]){
        int min=1000;
        int mink=-1;
        for(int i=0;i<V;i++){
            if(MST[i]==false && key[i]<min){
                min=key[i];
                mink=i;              
            }
        }        
        return mink;
    }
    static void printMST(int parent[], int graph[][]){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++){
            System.out.println(parent[i] + " - " + i + "\t"+ graph[i][parent[i]]);
            sum+=graph[i][parent[i]];
        }
    }
    static void prim(int graph[][]){
        int parent[]=new int[V];
        int key[]=new int[V];
        boolean[] mstset=new boolean[V];
        for(int i=0;i<V;i++){
            key[i]=1000;
            mstset[i]=false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int i=0;i<V-1;i++){
            int u=minKey(key, mstset);
            mstset[u]=true;
            for(int y=0;y<V;y++){
                if(graph[u][y]!=0 && mstset[y]==false && graph[u][y]<key[y] ){
                    parent[y]=u;
                    key[y]=graph[u][y];
                }
            }
        }
        printMST(parent, graph);
    }
    public static void main(String args[]){
        V=9;
        int graph[][]=new int [][]{ { 0, 4, 0, 0, 0 ,0,0,8,0},{ 4, 0, 8, 0, 0 ,0,0,0,0},{ 0, 8, 0, 7, 0 ,4,0,0,2},
        { 0, 0, 7, 0, 9 ,14,0,0,0},{ 0, 0, 0, 9, 0 ,10,0,0,0},{ 0, 0, 4, 14, 10 ,0,2,0,0},
        { 0, 0, 0, 0, 0 ,2,0,1,6},{ 8, 0, 0, 0, 0 ,0,1,0,7},{ 0, 0, 2, 0, 0 ,0,6,7,0}};
        prim(graph);
        System.out.println("the sum is:"+sum);
    }
}
/*{ 0, 2, 0, 6, 0 },{ 2, 0, 3, 8, 5 },{ 0, 3, 0, 0, 7 },{ 6, 8, 0, 0, 9 },{ 0, 5, 7, 9, 0 } */
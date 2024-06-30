import java.util.*;
public class prim2{
    static class edge{
        int source;
        int destination;
        int weight;
        public edge(int s,int d,int w){
            source=s;
            destination=d;
            weight=w;
        }
    }
    static class heapNode{
        int vertex;
        int key;
    }
    static class MST{
        int parent;
        int weight;
    }
    static class Graph{
        int vertices;
        public LinkedList<edge>[] adjacencylist;
        Graph(int V){
        vertices=V;
        adjacencylist=new LinkedList[vertices];
            for(int i=0;i<V;i++){
                adjacencylist[i]=new LinkedList<>();
            }
        }
        public void addedge(int source,int destination,int weight){
            edge e=new edge(source, destination, weight);
            adjacencylist[source].addFirst(e);
            e=new edge(source, destination, weight);
            adjacencylist[destination].addFirst(e);
        }
        public void prim(){
            boolean inHeap[]=new boolean[vertices];
            MST result[]=new MST[vertices];
            heapNode [] heap=new heapNode[vertices];
            int [] key=new int[vertices];
            for(int i=0;i<vertices;i++){
                heap[i]=new heapNode();
                heap[i].vertex=i;
                heap[i].key=Integer.MAX_VALUE;
                result[i]=new MST();
                result[i].parent=-1;
                inHeap[i]=true;
                key[i]=Integer.MAX_VALUE;
            }
            heap[0].key=0;
            MinHeap minheap=new MinHeap(vertices);
            for(int i=0;i<vertices;i++){
                minheap.insert(heap[i]);
            }
            while(!minheap.isEmpty()){
                heapNode h=minheap.extractMin();
                int ExtractedVertex=h.vertex;
                inHeap[ExtractedVertex]=false;
                LinkedList<edge> list=adjacencylist[ExtractedVertex];
                for(int i=0;i<list.size();i++){
                    edge e=list.get(i);
                    if(inHeap[e.destination]) {
                        int destination = e.destination;
                        int newKey = e.weight;
                        if(key[destination]>newKey) {
                            decreaseKey(minheap, newKey, destination);
                            result[destination].parent = ExtractedVertex;
                            result[destination].weight = newKey;
                            key[destination] = newKey;      
                        }

                    }
                }
            }
            printMST(result,vertices);
        }
    }
    public  static void decreaseKey(MinHeap minHeap, int newKey, int vertex){
        int index = minHeap.indexes[vertex];
        heapNode node = minHeap.mH[index];
        node.key= newKey;
        minHeap.bubbleUp(index);
    }
    public static  void printMST(MST[] resultSet,int V){
        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i <V ; i++) {
            System.out.println("Edge: " + i + " -> " + resultSet[i].parent +
            " weight: " + resultSet[i].weight);
            total_min_weight += resultSet[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }   
    static class MinHeap{
        int capacity;
        int currentSize;
        heapNode[] mH;
        int [] indexes; //will be used to decrease the key
        public MinHeap(int capacity) {
            this.capacity = capacity;
            mH = new heapNode[capacity + 1];
            indexes = new int[capacity];
            mH[0] = new heapNode();
            mH[0].key = Integer.MIN_VALUE;
            mH[0].vertex=-1;
            currentSize = 0;
        }
        public void display() {
            for (int i = 0; i <=currentSize; i++) {
                System.out.println(" " + mH[i].vertex + " key " + mH[i].key);
            }
            System.out.println("________________________");
        }
        public void insert(heapNode x) {
            currentSize++;
            int idx = currentSize;
            mH[idx] = x;
            indexes[x.vertex] = idx;
            bubbleUp(idx);
        }   
        public void bubbleUp(int pos) {
            int parentIdx = pos/2;
            int currentIdx = pos;
            while (currentIdx > 0 && mH[parentIdx].key > mH[currentIdx].key) {
                heapNode currentNode = mH[currentIdx];
                heapNode parentNode = mH[parentIdx];
                //swap the positions
                indexes[currentNode.vertex] = parentIdx;
                indexes[parentNode.vertex] = currentIdx;
                swap(currentIdx,parentIdx);
                currentIdx = parentIdx;
                parentIdx = parentIdx/2;
            }
        }      
        public heapNode extractMin() {
            heapNode min = mH[1];
            heapNode lastNode = mH[currentSize];
            // update the indexes[] and move the last node to the top
            indexes[lastNode.vertex] = 1;
            mH[1] = lastNode;
            mH[currentSize] = null;
            sinkDown(1);
            currentSize--;
            return min;
        }
               
        public void sinkDown(int k) {
            int smallest = k;
            int leftChildIdx = 2 * k;
            int rightChildIdx = 2 * k+1;
            if (leftChildIdx < heapSize() && mH[smallest].key > mH[leftChildIdx].key) {
                smallest = leftChildIdx;
            }
            if (rightChildIdx < heapSize() && mH[smallest].key > mH[rightChildIdx].key) {
                smallest = rightChildIdx;
            }
            if (smallest != k) {
                heapNode smallestNode = mH[smallest];
                heapNode kNode = mH[k];
                //swap the positions
                indexes[smallestNode.vertex] = k;
                indexes[kNode.vertex] = smallest;
                swap(k, smallest);
                sinkDown(smallest);
            }
        }     
        public void swap(int a, int b) {
            heapNode temp = mH[a];
            mH[a] = mH[b];
            mH[b] = temp;
        }
        public boolean isEmpty() {
            return currentSize == 0;
        }
        public int heapSize(){
            return currentSize;
        }
    }
    public static void main(String[] args) {
    int vertices = 9;
    Graph graph = new Graph(vertices);
    graph.addedge(0, 1, 4);
    graph.addedge(1, 2, 8);
    graph.addedge(2, 3, 7);
    graph.addedge(3, 4, 9);
    graph.addedge(4, 5, 10);
    graph.addedge(5, 6, 2);
    graph.addedge(6, 7, 1);
    graph.addedge(7, 0, 8);
    graph.addedge(7, 8, 7);
    graph.addedge(6, 8, 6);
    graph.addedge(2, 8, 2);
    graph.addedge(2, 5, 4);
    graph.addedge(3, 5, 14);
    graph.prim();
    }
}
//tutorial horizon
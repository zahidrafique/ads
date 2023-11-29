/* Code adopted from Advanced Data Structures by Robert Lafore */

public class PriorityQGraph {

    private Edge[] queArray;
    private int nItems;

    public PriorityQGraph(int maxSize) // constructor
    {
        queArray = new Edge[maxSize];
        nItems = 0;
    }

    public void insert(Edge item) // insert item
    {        
        int i;
        for (i=nItems-1; i >=0; i--) {
            if (item.weight > queArray[i].weight)
                queArray[i+1] = queArray[i];
            else
                break;
        }
        queArray[i+1] = item;
        nItems++;
    }  // end insert()

    public int find(int destVertex) {
        for (int i=0; i<nItems; i++) {
            if (destVertex == queArray[i].destVertex)
                return i;
        }
        
        return -1;
    }
    
    public Edge remove() // remove minimum item
    {
        return queArray[--nItems];
    }

    public Edge removeN(int n) {
        Edge t = queArray[n];
        for (int i=n; i<nItems-1; i++) {
            queArray[i] = queArray[i+1];
        }
        
        nItems--;
        return t;
    }
    
    public Edge peekMin() // peek at minimum item
    {
        return queArray[nItems - 1];
    }
    
    public Edge peekN(int n) {
        return queArray[n];
    }

    public boolean isEmpty() // true if queue is empty
    {
        return nItems == 0;
    }

    public boolean isFull() // true if queue is full
    {
        return nItems == queArray.length;
    }
}

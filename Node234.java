/* Code adopted from Advanced Data Structures by Robert Lafore */

public class Node234 {
    private final int ORDER = 4;
    private int numItems;   //Either 1, 2 or 3
    private Node234 parent;
    private Node234 childArray[] = new Node234[ORDER];
    private DataItem[] dataArray = new DataItem[ORDER-1];

    public void connectChild(int childNum, Node234 child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    public Node234 disconnectChild(int childNum) {
        Node234 t = childArray[childNum];
        childArray[childNum] = null;
        return t;
    }

    public Node234 getChild(int childNum) {
        return childArray[childNum];
    }

    public Node234 getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int getNumItems() {
        return numItems;
    }

    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    public DataItem getItem(int index) {
        return dataArray[index];
    }

    public int findItem(long data) {
        for (int i=0; i<ORDER-1; i++) {
            if (dataArray[i] == null)
                break;
            else if (dataArray[i].data == data)
                return i;
        }
        
        return -1;
    }

    //This method will be called for nodes that are not full
    public int insertItem(DataItem dataItem) {
        numItems++;  //Increment since a new item is being inserted
        
        for (int i=ORDER-2; i >= 0; i--) {
            if (dataArray[i] == null)
                continue;
            else {
                if (dataArray[i].data > dataItem.data) {
                    dataArray[i+1]  = dataArray[i];
                } else {
                    dataArray[i+1] = dataItem;
                    return i+1;
                }
            }
        }
        
        dataArray[0] = dataItem;
        return 0;
    }

    public DataItem removeRightMostItem() {
        DataItem temp = dataArray[numItems - 1];
        dataArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++)
            System.out.print("/" + dataArray[i].data);
        
        System.out.println("/");
    }
}

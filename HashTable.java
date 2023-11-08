/* Code adopted from Advanced Data Structures by Robert Lafore */

public class HashTable {

    private HashTableDataItem[] hashArray;
    private int arraySize;
    private HashTableDataItem nonItem;

    public HashTable(int size) {
        this.arraySize = size;
        this.hashArray = new HashTableDataItem[size];
        nonItem = new HashTableDataItem(-1, -1);
    }

    private int hashFunction(int key) {
        return key % arraySize;
    }
    
    private int doubleHashFunction(int key) {
        return 5 - key % 5;
    }
    
    private int findIndex(int key, int stopKey) {
        int hash = hashFunction(key);
        int stepSize = doubleHashFunction(hash);
        
        int current = hash;
        
        boolean wrapAround = true;
        while (hashArray[current] != null && hashArray[current].key != stopKey) {
            current = current + stepSize;
            
            if (current == hash) {
                wrapAround = false;
                current = current % arraySize;         
            }
            
            if (wrapAround == true  && current == hash) {
                return -1;
            }
        }
        
        return current;
    }

    public boolean insert(int key, long data) {
        HashTableDataItem HashTableDataItem = new HashTableDataItem(key, data);

        int iIndex = findIndex(key, -1);
        if (iIndex == -1)
            return false;
        
        hashArray[iIndex] = HashTableDataItem;
        return true;
    }

    public HashTableDataItem find(int key) {
        int fIndex = findIndex(key, key);
        if (fIndex == -1)
            return null;
        
        return hashArray[fIndex];
    }

    public HashTableDataItem delete(int key) {
        int dIndex = findIndex(key, key);
        if (dIndex == -1)
            return null;

        HashTableDataItem temp = hashArray[dIndex];
        hashArray[dIndex] = nonItem;
        return temp;
    }

    public void display() {
        System.out.print("Table: ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].key + " ");
            } else {
                System.out.print("");
            }
        }
        System.out.println("");
    }
}

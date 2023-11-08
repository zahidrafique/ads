/* Code adopted from Advanced Data Structures by Robert Lafore */

public class HashTableTest {

    public static void main(String[] args) {
        HashTable ht = new HashTable(11);
        ht.insert(3, 3300);
        ht.insert(5, 5500);
        ht.insert(8, 88000);
        ht.insert(33, 3333);
        ht.insert(10, 1010);
        ht.insert(15, 1515);
        ht.insert(22, 2222);
        ht.insert(29, 2929);
        ht.display();

        ht.delete(10);
        ht.display();
    }
}

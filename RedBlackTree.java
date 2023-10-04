/* Code adopted from Advanced Data Structures by Robert Lafore */

public class RedBlackTree {
    RedBlackNode root;
    
    private void setRoot(RedBlackNode newRoot) {
        root = newRoot;
        root.isRed = false;
    }
    
    public RedBlackNode find(int key) {      
        RedBlackNode current = root;
        while (current != null) {
            if (key == current.id)
                return !current.isDeleted ? current : null; //Return null if isDeleted is true
            
            if (key < current.id)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        
        return null;
    }

    private void flipColors(RedBlackNode current) {
        if (current.leftChild == null ||  current.rightChild == null)
            return;
        
        if (current.leftChild.isRed && current.rightChild.isRed) {
            current.leftChild.isRed = false;
            current.rightChild.isRed = false;
            
            if (current != root)
                current.isRed = true;
        }       
    }
    
    private void rotateLeft(RedBlackNode top, RedBlackNode parent) {
        if (top.rightChild == null)
            return;     
        
        RedBlackNode newTop = top.rightChild;
        top.rightChild = newTop.leftChild;  //Cross over node
        newTop.leftChild = top;     //Move down
        if (top == root) {
            setRoot(newTop);
        } else {
            if (top == parent.leftChild)    //Move up
                parent.leftChild = newTop;  
            else
                parent.rightChild = newTop;
        }
    }
    
    private void rotateRight(RedBlackNode top, RedBlackNode parent) {
        if (top.leftChild == null)
            return;     
        
        RedBlackNode newTop = top.leftChild;
        top.leftChild = newTop.rightChild;      //Corss over node
        newTop.rightChild = top;        //Move down
        if (top == root) {
            setRoot(newTop);
        } else {
            if (top == parent.leftChild)    //Move up
                parent.leftChild = newTop;
            else
                parent.rightChild = newTop;
        }
    }
    
    private void performRotations(RedBlackNode x, RedBlackNode p, RedBlackNode g, RedBlackNode gg) {
        if (!p.isRed) {
            return;
        } else {
            if (x == p.leftChild && p == g.leftChild) { //Outside grandchild - left child
                g.isRed = !g.isRed;
                p.isRed = !p.isRed;
                rotateRight(g, gg);
            }
            if (x == p.rightChild && p == g.rightChild) {   //Outside grandchild - right child
                g.isRed = !g.isRed;
                p.isRed = !p.isRed;
                rotateLeft(g, gg);                
            }
            
            if (x == p.rightChild && p == g.leftChild) {    //Inside grandchild - left child
                g.isRed = !g.isRed;
                x.isRed = !x.isRed;
                rotateLeft(p, g);
                rotateRight(g, gg);
            }
            if (x == p.leftChild && p == g.rightChild) {    //Inside grandchild - right child
                g.isRed = !g.isRed;
                x.isRed = !x.isRed;
                rotateRight(p, g);
                rotateLeft(g, gg);                
            }
        }
    }
    
    public void insert(int id, double data) {
        RedBlackNode newRedBlackNode = new RedBlackNode(id, data);
        
        if (root == null) {
            setRoot(newRedBlackNode);
        } else {
            RedBlackNode current = root;
            RedBlackNode parent = null, grandParent = null, greatGrandParent = null;
            while (true) {
                flipColors(current);    //Check for everyRedBlackNode, if both children are red, then filp colors
                if ((parent != null) && (parent.isRed && current.isRed)) {
                    //If Red-Red conflict after color flip, perform rotations on the way down
                    performRotations(current, parent, grandParent, greatGrandParent);
                }
                
                RedBlackNode newCurrent = null;
                if (id < current.id) {
                    if (current.leftChild == null) {    //Found the spot to insert
                        current.leftChild = newRedBlackNode;
                        performRotations(newRedBlackNode, current, parent, grandParent);
                        break;
                    }
                    newCurrent = current.leftChild;
                }
                
                if (id > current.id) {
                    if (current.rightChild == null) {    //Found the spot to insert
                        current.rightChild = newRedBlackNode;
                        performRotations(newRedBlackNode, current, parent, grandParent);
                        break;
                    }
                    newCurrent = current.rightChild;
                }
                
                greatGrandParent = grandParent;
                grandParent = parent;
                parent = current;
                current = newCurrent;
            }
        }
    }

    boolean delete(int key) {   //We are not really deleting the RedBlackNodes (too complex). Only Hiding!!
        RedBlackNode current = root;
        
        while (current != null && current.id != key) { //Look for RedBlackNode to be deleted
            if (key < current.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        
        if (current == null)
            return false;
        
        current.isDeleted = true;
        
        return true;
    }
   
    private String traversePreOrder(RedBlackNode root) {
        if (root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.id);
        sb.append(root.isRed ? "(R)" : "(B)");
        
        String pointerRight = "---";
        String pointerLeft = "|--";
        
        traverseRedBlackNodes(sb, "", pointerLeft, root.leftChild, root.rightChild != null);
        traverseRedBlackNodes(sb, "", pointerRight, root.rightChild, false);
        
        return sb.toString();
    }
    
    private void traverseRedBlackNodes(StringBuilder sb, String padding, String pointer, 
            RedBlackNode RedBlackNode, boolean hasRightSibling) {
    
        if (RedBlackNode == null)
            return;
        
        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(RedBlackNode.id);
        sb.append(RedBlackNode.isRed ? "(R)" : "(B)");
        
        StringBuilder pb = new StringBuilder(padding);
        if (hasRightSibling) 
            pb.append("|  ");
        else
            pb.append("   ");
        
        String p = pb.toString();
        String pntr = "|--";
        traverseRedBlackNodes(sb, p, pntr, RedBlackNode.leftChild, RedBlackNode.rightChild != null);
        traverseRedBlackNodes(sb, p, pntr, RedBlackNode.rightChild, false);
    }
    
    void print() {
        String s = traversePreOrder(root);
        System.out.println(s);
    }
    
    public RedBlackNode getMinimum() {
        if (root == null)
            return null;
        
        RedBlackNode current = root;
        while(current.leftChild != null)
            current = current.leftChild;
        
        return current;
    }
    
    public RedBlackNode getMaximum() {
        if (root == null)
            return null;
        
        RedBlackNode current = root;
        while(current.rightChild != null)
            current = current.rightChild;
        
        return current;
    }
}

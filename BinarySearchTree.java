public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    BinaryTree<E> tree;

    public BinarySearchTree() {
        tree = new BinaryTree<E>();
    }

    public BinarySearchTree(E val) {
        tree = new BinaryTree<E>(val);
    }

    // returns true if BST has val else false.
    //while left and right not null
    //break loop if found match or not
    public boolean contains(E val) {
        int result = val.compareTo(tree.root.info);
        if (result == 0) {
            return true;
        }
        contains((E) tree.root.left);

        contains((E) tree.root.right);

        return false;
    }

    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
    // if value is already there then don't insert it again
    public void insert(E val) {
        root = insertNode(root, val);
    }

    Node<E> insertNode (Node < E > root, E val){
        if (tree.root == null) {
            root = new Node<E>(val);
            return root;
        } else if (val.compareTo(tree.root.info) == -1){
            root.left = insertNode(root.left, val);
        } else if (val.compareTo(tree.root.info) == 1) {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    // returns the minimum value stored in the tree
    // go all the way down the left path of the tree
    public E findMin() {
        Node<E> current = new Node<>();

        while(tree.root.info != null){
            current = current.left;
        }
        return current.info;
    }

    // returns the maximum value stored in the tree
    public E findMax() {
        Node<E> current = new Node<E>();

        while (current.right != null){ // while current node's left child does not equal null
            current = current.right; // goes through each right branch of the tree and sets that value to current
        }
        return current.info;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt= new BinarySearchTree<>();
        BinarySearchTree<Integer> bt2 = new BinarySearchTree<>(10);
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);

        //System.out.println(bt.contains(3));
        System.out.println(bt.findMax());
        System.out.println(bt2.contains(10));
    }
}
/**
 * @author Willie Ausrotas, Brian Lee
 * Student Number: 7804922, 7938501
 * Assignment: 4, Q6
 * Section: ITI1121-A
 */

public class BinarySearchTree< E extends Comparable<E>> {

    private static class Node<F> {

        private final F value;
        private Node<F> left;
        private Node<F> right;

        private Node(F value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    private Node<E> root = null;

    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add(E obj) {

        // pre-condtion:
        if (obj == null) {
            throw new NullPointerException("Illegal Argument");
        }

        // special case:
        if (root == null) {
            root = new Node<E>(obj);
            return true;
        }

        // general case:
        return add(obj, root);
    }

    private boolean add(E obj, Node<E> current) {

        boolean result;
        int test = obj.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(obj);
                result = true;
            } else {
                result = add(obj, current.right);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> p) {
        if (p == null) {
            return "null";
        } else {
            return "(" + toString(p.left) + "," + p.value + "," + toString(p.right) + ")";
        }
    }
    //Variable to hold the amount of elements >=low and =<high
    private static int count = 0;

    /**
     * Calls the recurisve method to loop through the tree.
     * @param low
     * @param high
     * @return
     */
    public int count(E low, E high)
    {
        count = 0;
       preOrder(this.root, low, high); //Calls the recursive method.
        return count; //Returns the amount of elements found.
    }

    /**
     * Loops through the binary tree in preOrder and checks to see if
     * the root.value is >=low and <=high.
     * @param root
     * @param low
     * @param high
     */
    private void preOrder (Node<E> root, E low, E high){
        if (root.left != null){
            preOrder (root.left, low, high);

        }
        if(low.compareTo(root.value) <= 0 && high.compareTo(root.value) >= 0)
        {
            count++; //If the condition is met, then increment this by 1 stating that we have found
                    //a value in the tree which is >=low && <=high.
        }
        if (root.right != null){

            preOrder (root.right, low, high);
        }
    }


}
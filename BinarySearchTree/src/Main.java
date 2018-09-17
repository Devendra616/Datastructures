public class Main {

    public static void main(String[] args) {
        Tree bst = new Tree();

        bst.insert(25);
        bst.insert(20);
        bst.insert(27);
        bst.insert(15);
        bst.insert(22);
        bst.insert(26);
        bst.insert(30);
        bst.insert(29);
        bst.insert(32);

        System.out.println("\nInOrder Traversal=>");
        bst.traverseInOrder();
        System.out.println("\nPreOrder Traversal=>");
        bst.traversePreOrder();
        System.out.println("\nPostOrder Traversal=>");
        bst.traversePostOrder();

        /*System.out.println("\n Getting 24 "+bst.get(24));
        System.out.println("Getting 27 "+bst.get(27));
        System.out.println("Getting 32 "+bst.get(32));

        System.out.println("\n Maximum is=> "+bst.getMax());
        System.out.println(" Minimum is=> "+bst.getMin());
*/
        bst.delete(15);
        System.out.println("\nInOrder Traversal after deleting 15=>");
        bst.traverseInOrder();

        bst.delete(27);
        System.out.println("\nInOrder Traversal after deleting 27=>");
        bst.traverseInOrder();

        bst.delete(333);
        System.out.println("\nInOrder Traversal after deleting 333=>");
        bst.traverseInOrder();
    }
}

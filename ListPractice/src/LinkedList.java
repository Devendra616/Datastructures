import java.util.HashSet;

public class LinkedList {

    Node head; //head of list
    static class Node{
        int data;
        Node next;
        Node(int d) { //constructor
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        LinkedList lList = new LinkedList();
        lList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        lList.head.next = second;
        second.next = third;

        lList.addAtFront(4);
        lList.addAtFront(1);
        lList.printList();

        lList.addAtFront(4);
        System.out.println("\nAfter insertion at front");
        lList.printList();

        lList.addAfterNode(second,5);
        System.out.println("\nAfter insertion after "+second.data);
        lList.printList();

        lList.addAtEnd(6);
        System.out.println("\nAfter insertion at end ");
        lList.printList();

        lList.deleteNode(2); //4,6
        System.out.println("\nAfter deletion of "+2);
        lList.printList();

        lList.reverseList();
        System.out.println("\nAfter reverse");
        lList.printList();

        lList.reverseRecursive(lList.head);
        System.out.println("\nAfter recursive reverse");
        lList.printList();

        System.out.println("\nMiddle node is "+lList.middleNode().data);

        System.out.println("\n Contains loop "+ lList.detectLoop());

        lList.printList();
        System.out.println("\nRemove duplicates from unsorted list");
        lList.removeDuplicatesUnsortedList();
        lList.printList();

        lList.deleteList();
        System.out.println("\nAfter deletion of list");
        lList.printList();

        lList.addAtFront(1);
        lList.addAtFront(2);
        lList.addAtFront(2);
        lList.addAtFront(3);
        lList.addAtFront(3);
        lList.addAtFront(4);
        lList.addAtFront(4);
        lList.printList();
        System.out.println("\nRemove duplicates from sorted list");
        lList.removeDuplicatesSortedList();
        lList.printList();

        System.out.println("\nAfter swapping");
        lList.swap(3,2);
        lList.printList();

        char []str = {'a','b','a','c','a','b','a'};
        for(char c : str){
            lList.addAtFront(Character.valueOf(c));
        }
        System.out.println("\nNew Linked list is ");
        lList.printList();
        System.out.println("\n Is Palindrome "+lList.isPalindrome());



    }
    /*Traversal of Link list */
    public void printList(){
        Node node = head;
        while (node !=null){
            System.out.print(node.data+"==>");
            node = node.next;
        }
    }
    /* Add a new node at Front */

    public void addAtFront(int n){
        Node newNode = new Node(n);
        newNode.next = head;
        head = newNode;
    }

    public void addAfterNode(Node prev, int n){
        if(prev == null){
            System.out.println("Previous node can not be null");
            return;
        }
        Node newNode = new Node(n);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void addAtEnd(int n){
        Node newNode = new Node(n);
        if(head == null) {//if empty list
            head = newNode;
            return;
        }

        Node node = head;
        while (node.next!=null){
            node = node.next;
        }
        node.next = newNode;
    }

    public void deleteNode(int n){
        if(head != null && head.data == n){ //if data in head
            head= head.next;
            return;
        }
        Node node = head;
        while (node.next.next !=null && node.next.data != n){ //find previous node
            node = node.next;
        }
        Node prev = node;
        prev.next = prev.next.next;
    }

    public void reverseList(){
        if(head == null)
            return;
        Node prevNode = null;
        Node nextNode = null;
        Node curNode = null;
        curNode = head;
        while(curNode !=null){
            nextNode = curNode.next;
            curNode.next= prevNode;

            prevNode = curNode;
            curNode = nextNode;
        }
        head = prevNode;
    }

    public Node reverseRecursive(Node current){
        if(current== null){ //empty list
            return null;
        }

        if(current.next == null){ //at end of list
            head = current;
            return null;
        }
        reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;
        return head;
    }

    public void deleteList(){

        head = null;
    }

/*
* Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5
 * then output should be 3.
If there are even nodes, then there would be two middle nodes, we need to print second middle element.
For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 */
    public Node middleNode(){
        Node mid = head ;
        Node temp = head;
        while(temp != null && temp.next != null){
            temp = temp.next.next;
            mid = mid.next;
        }
        return mid;
    }
    /*
    Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
    When the fast pointer reaches end slow pointer will reach middle of the linked list.
     */

    /*
    * Traverse the list one by one and keep putting the node addresses in a Hash Table.
    * At any point, if NULL is reached then return false and if next of current node points to any of the previously stored nodes in Hash then return true.
     * */
    public boolean detectLoop(){
        Node node = head;
        HashSet<Node> hs = new HashSet<>();

        while (node !=null){
            if(hs.contains(node)){
                return true;
            }
            hs.add(node);
            node = node.next;
        }
        return false;
    }

    public boolean isPalindrome(){
        return isPalindromeUtil(head);
    }

    Node left;
    boolean isPalindromeUtil(Node right){
         left= head;

        //stop recursion when right is null
        if(right ==null){
            return true;
        }
// if sublist is not palindrome then no need of further checking
        boolean isp = isPalindromeUtil(right.next);
        if(isp == false){
            return false;
        }

//        check values at current left and right
        boolean isp1 = (left.data == right.data);

        left =left.next;
        return isp1;
    }

    public void removeDuplicatesUnsortedList(){
        Node current = head;
        Node prev = null;
        HashSet<Integer> hs = new HashSet<>();
        while (current != null){
            if(hs.contains(current.data)){
                prev.next= current.next;
            }else {
                hs.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }


    /*
    compare each node with its next node. If data of next node is same as current node then delete the next node.
    Before we delete a node, we need to store next pointer of the node
     */
    public void removeDuplicatesSortedList(){
        Node current = head;
        Node nextNode;
        while (current.next !=null){
            nextNode = current.next;
            if(current.data == nextNode.data){
                current.next = nextNode.next; //skip the next node
            }else {
                current = current.next;
            }
        }
    }
/*
*   Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links.
*   Swapping data of nodes may be expensive in many situations when data contains many fields.
* */
    public void swap(int x, int y){
        Node prevX,prevY;
        Node curX,curY;

        if(x==y){ //no swapping reqd
            return;
        }

        curX=head;prevX= null;
        while (curX != null && curX.data != x){
            prevX = curX;
            curX = curX.next;
        }
        curY=head;prevY= null;
        while (curY != null && curY.data != y){
            prevY = curY;
            curY = curY.next;
        }
        //if either current X or Y is null then x or y doesnt exist
        if(curX==null || curY == null){
            return;
        }

        if(prevX== null){ //x is head
            head = curY;
        }else {
            prevX.next =curY;
        }

        if(prevY == null){ //y is head
            head = curX;
        }else {
            prevY.next = curX;
        }

        //swap the next pointers
        Node temp = curX.next;
        curX.next = curY.next;
        curY.next = temp;
    }
}

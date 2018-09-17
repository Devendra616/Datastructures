public class DoublyLinkedList {

    static class Node{
        int element;
        Node next;
        Node prev;
        public Node(int element) {
            this.element = element;
        }
    }

    Node head;
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertSorted(5);
        doublyLinkedList.insertSorted(4);
        doublyLinkedList.insertSorted(7);
        doublyLinkedList.insertSorted(1);
        doublyLinkedList.insertSorted(2);
        doublyLinkedList.insertSorted(3);

        doublyLinkedList.printList();
    }

    public void printList(){
        System.out.print("HEAD=> ");
        Node current= head;
        while (current!=null){
            System.out.print(current.element+" <=>");
            current= current.next;
        }
        System.out.println("NULL");

    }

    public void insertSorted(int e){

        Node newNode = new Node(e);

        if(head == null){
            head = newNode;
            return;
        }
        if(e<= head.element){ //insert as first element
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head.next;
        Node previous = head;
        while (current != null && e> current.element ){
            previous=current;
            current = current.next;
        }
        if(current ==null){//have reached end of list
            newNode.prev = previous;
            newNode.next = null;
            previous.next = newNode;
            return;
        }
        { //insert between previous and current
            newNode.next = current;
            newNode.prev =previous;
            previous.next=newNode;
            current.prev = newNode;
            return;
        }

    }

}

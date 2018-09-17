/*
    Can work on front of link list in constant time O(1)
    But at end it takes O(n)
 */
public class EmployeeLinkedList {

    private EmployeeNode head;

    public void addToFront(Employee employee){
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.setNext(head);
        head = newNode;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("\n HEAD->");
        while (current!=null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("NULL");
    }

    public boolean isEmpty(){
        return head== null;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removeNode = head;
        head = head.getNext();

        removeNode.setNext(null);
        return removeNode;
    }

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        EmployeeLinkedList empList = new EmployeeLinkedList();

        System.out.print(empList.isEmpty());
        empList.addToFront(jane);
        empList.addToFront(devendra);
        empList.addToFront(rahul);
        empList.addToFront(reena);

        empList.printList();
        System.out.println("\n"+empList.isEmpty());

        empList.removeFromFront();
        empList.printList();

    }

}

/*
    Insertion and deletion at front and end of list takes place in Constant time O(1)
    Any operation in middle of list takes time O(n) , have to traverse list
 */
public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        EmployeeDoublyLinkedList empList = new EmployeeDoublyLinkedList();

        System.out.print(empList.isEmpty());
        empList.addToFront(jane);
        empList.addToFront(devendra);
        empList.addToFront(rahul);
        empList.addToFront(reena);

        empList.printList();
        System.out.println("\n"+empList.isEmpty());

        empList.addToEnd(new Employee(111,"Anupam","Dwivedi"));
        empList.printList();

        System.out.println("\nInsert into list");
        Employee insertEmp = new Employee(21,"Manish","Purbey");
        empList.insertBefore(devendra,insertEmp);
        empList.printList();

        empList.removeFromFront();
        empList.printList();

        empList.removeFromEnd();
        empList.printList();

        empList.removeFromEnd();
        empList.printList();

        empList.removeFromEnd();
        empList.printList();

        empList.removeFromFront();
        empList.printList();

        empList.removeFromEnd();
        empList.printList();


    }

    public boolean isEmpty(){
        return head== null;
    }

    private void printList() {
        EmployeeNode current = head;
        System.out.print("\n HEAD->");
        while (current!=null){
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.print("NULL");

    }

    private void addToFront(Employee employee) {
        EmployeeNode newNode = new EmployeeNode(employee);
        if(head == null){ //empty list
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.setPrev(null);
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }

    private void addToEnd(Employee employee){
        EmployeeNode newNode = new EmployeeNode(employee);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.setNext(null);
        newNode.setPrev(tail);

        tail.setNext(newNode);
        tail = newNode;
    }

    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        if(head == tail){ //removing the only node
            head = null;
            tail= null;
            return head;
        }
        EmployeeNode removeNode = head;
        head = head.getNext();
        head.setPrev(null);

        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeNode removeFromEnd(){
        if(isEmpty()){
            return null;
        }
        if(head== tail){
            tail= null;
            head = null;
            return head;
        }
        EmployeeNode removeNode = tail;
        tail = removeNode.getPrev();
        tail.setNext(null);

        removeNode.setPrev(null);
        return removeNode;
    }

    public void insertBefore(Employee employee,Employee insertEmp) {

        if (isEmpty()) {
            return;
        }
        //find the existing employee
        EmployeeNode current = head;
        while (current != null && !current.getEmployee().equals(employee)) {
            current = current.getNext();
        }
        if (current == null) {
            System.out.println("Employee " + employee + " doesn't exist");
            return;
        }
        EmployeeNode newNode = new EmployeeNode(insertEmp);
        newNode.setNext(current);
        newNode.setPrev(current.getPrev());
        current.setPrev(newNode);

        if(current == head){
            head = newNode;
        }else {
            current.getPrev().setNext(newNode);
        }

    }
}

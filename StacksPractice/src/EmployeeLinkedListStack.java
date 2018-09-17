import java.util.LinkedList;
import java.util.ListIterator;

/*
    Can use jdk provided linked list implementation and use stack supported methods
    Linkedlist implements deque interface so has push, pop and peek method
    This class now forces the further usage of only the implemented methods, users can not call other
    linkededlist methods not defined here.
 */
public class EmployeeLinkedListStack {

    private LinkedList<Employee> stack;

    public EmployeeLinkedListStack(){
        stack = new LinkedList<>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){
        ListIterator<Employee> listIterator = stack.listIterator();

        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+"=>");
        }
    }

    /*
        Now calling the above
     */
    public static void main(String[] args) {
        EmployeeLinkedListStack linkedStack = new EmployeeLinkedListStack();
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        linkedStack.push(devendra);
        linkedStack.push(jane);
        linkedStack.push(rahul);
        linkedStack.push(reena);

        linkedStack.printStack();

        linkedStack.pop();
        linkedStack.pop();
        System.out.println("\nAfter pop two");
        linkedStack.printStack();
        System.out.println("\n Top element "+linkedStack.peek());
        linkedStack.printStack();
        System.out.println("\n Is stack empty "+linkedStack.isEmpty());
    }

}

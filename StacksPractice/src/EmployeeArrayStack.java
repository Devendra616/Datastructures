import java.util.EmptyStackException;

public class EmployeeArrayStack {

    private Employee[] stack;
    private int top;

    public EmployeeArrayStack(int capacity){
        stack = new Employee[capacity];
    }

    public void push(Employee employee){

//        If stack is full, expand the stack
        if(top == stack.length)
        {
            Employee[] newEmp=  new Employee[2*stack.length];
//            copy the prev stack to new
            System.arraycopy(stack,0,newEmp,0,stack.length);
            stack = newEmp;
        }
        stack[top++] = employee;
    }

    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Employee employee =  stack[--top];
        stack[top] = null; //dereference the top to let it garbage collected
        return employee;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public boolean isEmpty(){
        return 0==top;
    }

    public void printStack(){
        System.out.print("\n TOP => ");
        for(int i=top-1;i>=0;i--){
            System.out.print(stack[i]+"=>");
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        EmployeeArrayStack arrayStack = new EmployeeArrayStack(3);
        arrayStack.push(new Employee(12,"Devendra","Singh"));
        arrayStack.printStack();
        arrayStack.push(new Employee(10,"Deepti","Bajpai"));
       arrayStack.push(new Employee(2,"Jonny","Jones"));
//        arrayStack.push(new Employee(3,"Vijay","Kapoor"));
        arrayStack.printStack();

        System.out.println("\nAfter popping "+arrayStack.pop());
        arrayStack.printStack();

        /*System.out.println("\nAfter popping "+arrayStack.pop());
        arrayStack.printStack();*/
       /* System.out.println("\nAfter popping "+arrayStack.pop());
        arrayStack.printStack();*/

        System.out.println("\nTop is "+arrayStack.peek());
    }
}

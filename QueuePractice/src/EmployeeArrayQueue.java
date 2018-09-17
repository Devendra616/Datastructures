import java.util.NoSuchElementException;

public class EmployeeArrayQueue {

    private Employee[] queue;
    private int front;
    private int rear;

    public EmployeeArrayQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
    //Queue is full,resize array
        if(rear == queue.length){
            Employee[] newArr = new Employee[2*queue.length];
            System.arraycopy(queue,0,newArr,0,queue.length);
            queue = newArr;
        }
        queue[rear]= employee;
        rear++;
    }

    public Employee remove(){
        if(size()==0){ //front==size
            throw new NoSuchElementException();
        }
        Employee employee= queue[front];
        queue[front]=null;
        front++;

        //if the only element is removed then reset the queue
        if(size()==0){
            front=rear=0;
        }
        return employee;
    }

    public int size(){
        return rear-front;
    }

    public Employee peek(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue(){
        for(int i=front;i<rear;i++){
            System.out.print(queue[i]+" =>");
        }
    }

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        EmployeeArrayQueue arrayQueue = new EmployeeArrayQueue(5);
        arrayQueue.add(rahul);
        arrayQueue.add(reena);
        arrayQueue.add(devendra);
        arrayQueue.add(jane);
       // arrayQueue.printQueue();

        arrayQueue.add(rahul);
        arrayQueue.add(rahul);
        arrayQueue.add(rahul);
        arrayQueue.add(rahul);
        arrayQueue.printQueue();

        System.out.println("\nRemoving one");
        arrayQueue.remove();
        arrayQueue.printQueue();

        System.out.println("\nRemoving two");
        arrayQueue.remove();
        arrayQueue.remove();
        arrayQueue.printQueue();

        System.out.println("\nPeek front "+arrayQueue.peek());

        System.out.println("\nRemoving one");
        arrayQueue.remove();
        arrayQueue.printQueue();
        /*System.out.println("\nRemoving one");
        arrayQueue.remove();
        arrayQueue.printQueue();*/


    }
}

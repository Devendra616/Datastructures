import java.util.NoSuchElementException;

public class EmployeeCircularQueue {

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        EmployeeCircularQueue circularQueue = new EmployeeCircularQueue(3);
        circularQueue.add(rahul);
        circularQueue.add(reena);
        circularQueue.add(devendra);
        circularQueue.add(jane);
        circularQueue.printQueue();

        System.out.println("\nSize: "+circularQueue.size());

        System.out.println("\nRemoving one");
        circularQueue.remove();
        circularQueue.printQueue();

        System.out.println("\nRemoving two");
        circularQueue.remove();
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println("\nSize: "+circularQueue.size());

        System.out.println("\nPeek front "+circularQueue.peek());

        System.out.println("\nRemoving one");
        circularQueue.remove();
        circularQueue.remove();
        circularQueue.printQueue();
    }

    private Employee[] queue;
    private int front;
    private int rear;
    public EmployeeCircularQueue(int capacity){
        queue = new Employee[capacity];
    }

    public void add(Employee employee){
        int arraySize = size();
        if(arraySize == queue.length){
        //resize array
            Employee[] newEmpArr = new Employee[2*queue.length];
            if(rear>=front){
                System.arraycopy(queue,0,newEmpArr,0,arraySize);
            }else {
//shift elements of wrapped queue
                System.arraycopy(queue,front,newEmpArr,0,queue.length-front);
                System.arraycopy(queue,0,newEmpArr,queue.length-front,rear);
            }
            queue = newEmpArr;
            front=0;
            rear=arraySize;
        }
        queue[rear] = employee;
        rear++;
    }

    public Employee remove(){
        if (size() == 0) {
            throw new NoSuchElementException();
        }

            Employee employee= queue[front];
            queue[front] = null;
            front++;
            if(size()==0){
                front=0;
                rear=0;
            }else if(front== queue.length){
                front=0;
            }

            return employee;
    }

    public Employee peek(){
        if(size()==0){
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size(){
        if(rear >= front){
            return rear-front;
        }else {
            return queue.length-(front-rear);
        }
    }

    public void printQueue(){

        if(rear>=front){
            for(int i=front;i<=rear;i++)
                System.out.print(queue[i]);
        }else {
            for(int i=front;i<queue.length-1;i++){
                System.out.print(queue[i]);
            }
            for(int i=0;i<rear;i++){
                System.out.print(queue[i]);
            }
        }

    }


}

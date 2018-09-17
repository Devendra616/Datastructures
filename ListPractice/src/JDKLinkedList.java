import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedList {

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        JDKLinkedList jdklist = new JDKLinkedList();

        LinkedList<Employee> empList = new LinkedList<>();
        empList.add(jane);
        empList.add(devendra);
        empList.add(rahul);
        empList.add(reena);

        jdklist.printList(empList);

      /*  for(Employee employee: empList){
            System.out.println(employee);
        }*/

      Employee billDaves = new Employee(101,"Bill","Daves");
      empList.addLast(billDaves);
      jdklist.printList(empList);

      empList.remove();
      jdklist.printList(empList);

      empList.removeFirst();
      jdklist.printList(empList);

      empList.removeLast();
      jdklist.printList(empList);

    }

    public static void printList(LinkedList empList){
        Iterator iterator = empList.iterator();
        System.out.print("HEAD=>");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print("=>");
        }
        System.out.println("NULL");
    }
}

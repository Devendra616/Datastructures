/*
    Arraylist is backed by array
    if has index then O(1)
    Arraylist is not synchronized ie not thread safe but is faster than Vector
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(123,"Jane","Jones"));
        employeeList.add(new Employee(124,"Devendra","Singh"));
        employeeList.add(new Employee(125,"Rahul","Roy"));
        employeeList.add(new Employee(126,"Reena","Yadav"));

        printList(employeeList);

        //get particular item from list
        System.out.println("\n"+employeeList.get(1)+"\n");

        //replace and item in list
        employeeList.set(1,new Employee(45,"Brijendra","Singh"));
        printList(employeeList);

        System.out.println("Size of list"+employeeList.size());

        //By default add to end of list
        employeeList.add(new Employee(78,"Rajesh","Jaiswal"));

        //add at particular index
        employeeList.add(3,new Employee(99,"Priyanka","Tripathi"));
        printList(employeeList);

        //get in Array
        Employee []empArray = employeeList.toArray(new Employee[employeeList.size()]);
        System.out.println("Employee array printing");
        for(Employee emp: empArray){
            System.out.println(emp);
        }

        //if list contains the item
        boolean isContain = employeeList.contains(new Employee(45,"Brijendra","Singh"));
        System.out.println(isContain);

        //index of item in the list
        System.out.println(employeeList.indexOf(new Employee(45,"Brijendra","Singh")));

        //remove an item at index
        employeeList.remove(3);
        printList(employeeList);

    }

    public static void printList(List<Employee> empList){
        empList.forEach(employee -> System.out.println(employee));
    }
}

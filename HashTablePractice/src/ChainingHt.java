import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHt {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainingHt(){
        hashtable = new LinkedList[10];
        for(int i=0;i<hashtable.length;i++){
            hashtable[i]= new LinkedList<StoredEmployee>();
        }
    }

    private int hashKey(String key){
//        return key.length()% hashtable.length;
        return Math.abs(key.hashCode()%hashtable.length);
    }

    public void put(String key, Employee employee){
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key,employee));
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee stEmp = null;

        int index=-1; //so that in iterator it becomes 0- (length)
        while (listIterator.hasNext()){
            stEmp = listIterator.next();
            index++; //starts with 0
            if(stEmp.key.equals(key)){
                return stEmp.employee;
            }
        }
        return null;
    }

    public Employee remove(String key){
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee stEmp = null;

        int index=-1; //so that in iterator it becomes 0- (length)
        while (listIterator.hasNext()){
            stEmp = listIterator.next();
            index++; //starts with 0
            if(stEmp.key.equals(key)){
                break;
            }
        }
        if((stEmp != null)&&(stEmp.key.equals(key))){
            hashtable[hashedKey].remove(index);
            return stEmp.employee;
        }

        return null;
    }

    public void printHashTable(){
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i].isEmpty()){
                System.out.println("Position: "+i+" : Empty");
            }else {
                System.out.print("Position: "+i+" : ");
                ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().employee+" -> ");
                }
                System.out.println("NULL");
            }
        }
    }

    public static void main(String[] args) {
        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        ChainingHt ht = new ChainingHt();
        System.out.println("\n\nChained Hashing -----/n");
        ht.put("Roy",rahul);
        ht.put("Jones",jane);
        ht.put("Yadav",reena);
        ht.put("Singh",devendra);
        ht.put("Yadav",reena);
        ht.put("Roy",rahul);
        ht.put("Jones",jane);
        ht.put("Singh",devendra);
        ht.put("Yadav",reena);

        ht.printHashTable();

        System.out.println("Getting Yadav "+ht.get("Yadav"));

        System.out.println("\nRemoving one item");
        ht.remove("Singh");
        ht.remove("Yadav");

        ht.remove("Dwivedi");
//        ht.remove("Singh");
        ht.printHashTable();

        System.out.println("Getting Yadav "+ht.get("Yadav"));
    }
}

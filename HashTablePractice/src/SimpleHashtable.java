public class SimpleHashtable {

    private Employee[] hashtable;

    public SimpleHashtable(){
        hashtable = new Employee[10];
    }

    public SimpleHashtable(int capacity){
        hashtable = new Employee[capacity];
    }

    private int hashKey(String key){
        return key.length()%hashtable.length;
    }

    public void put(String key, Employee employee){
        int hashedkey = hashKey(employee.getLastName());
        if(hashtable[hashedkey] != null){
            System.out.println("Sorry there is already an employee at "+hashedkey);
            return;
        }
        hashtable[hashedkey]=employee;
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    public void printHashtable(){
        for(int i=0;i<hashtable.length;i++){
            System.out.println("Position :"+i+"->"+hashtable[i]);
        }
    }

    /*calling main func */
    public static void main(String[] args) {

        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Singh",devendra);
        ht.put("Roy",rahul);
        ht.put("Jones",jane);
        ht.put("Yadav",reena);
        ht.printHashtable();

        System.out.println("Getting Singh "+ht.get("Singh"));



    }
}

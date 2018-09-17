public class LinearProbingHt {

    private StoredEmployee[] hashtable;

    public LinearProbingHt(){
        hashtable = new StoredEmployee[10];
    }

    public LinearProbingHt(int capacity){
        hashtable = new StoredEmployee[capacity];
    }

    private int hashKey(String key){
        return key.length()%hashtable.length;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        int stopIndex = hashedKey;
        while (hashtable[hashedKey] !=null && !hashtable[hashedKey].key.equals(key) ){
            hashedKey = (hashedKey+1)%hashtable.length;
            if(hashedKey == stopIndex){
                break;
            }
        }

        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        } else {
            return -1;
        }

    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if(hashtable[hashedKey].key.equals(key)){
            return hashtable[hashedKey].employee;
        }else {
            return null;
        }

    }

    public void printHashtable(){
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i] == null){
                System.out.println("Position :"+i+"-> Empty");
            }else{
                System.out.println("Position :"+i+"->"+hashtable[i].employee);
            }

        }
    }

    public void put(String key, Employee employee){
        int hashedkey = hashKey(employee.getLastName());
        int stopIndex = hashedkey;

        while (hashtable[hashedkey] !=null){
            hashedkey = (hashedkey+1)%hashtable.length;
           /* if(hashedkey >= hashtable.length){
                hashedkey=0;
            }*/
            if(hashedkey == stopIndex ){
                break;//to avoid loop
            }

        }
        if(hashtable[hashedkey] !=null){
            System.out.println("Sorry no postion available");
        } else{
            hashtable[hashedkey]= new StoredEmployee(key, employee);
        }

    }

    public Employee remove(String key){
        int hashedkey = findKey(key);

        if(hashedkey == -1){ //nothing to remove
            return null;
        }
        Employee employee = hashtable[hashedkey].employee;
        hashtable[hashedkey] = null;

//        rehash the table to let the null used by other item
        StoredEmployee[] oldhashtable = hashtable;
        hashtable= new StoredEmployee[hashtable.length];
        for(int i=0;i<hashtable.length;i++){
            if(oldhashtable[i] !=null)
                put(oldhashtable[i].key,oldhashtable[i].employee);
        }
        return employee;
    }

    public static void main(String[] args) {

        Employee jane = new Employee(123,"Jane","Jones");
        Employee devendra =new Employee(124,"Devendra","Singh");
        Employee rahul = new Employee(125,"Rahul","Roy");
        Employee reena = new Employee(126,"Reena","Yadav");

        LinearProbingHt ht = new LinearProbingHt();
        System.out.println("\n\nLinear probing------/n");
        ht.put("Roy",rahul);
        ht.put("Jones",jane);
        ht.put("Yadav",reena);
        ht.put("Singh",devendra);
        ht.put("Yadav",reena);
        ht.put("Roy",rahul);
        ht.put("Jones",jane);
        ht.put("Singh",devendra);
        ht.put("Yadav",reena);

        ht.printHashtable();
        System.out.println("Getting Yadav "+ht.get("Yadav"));

        System.out.println("\nRemoving one item");
        ht.remove("Yadav");
        ht.remove("Yadav");
        ht.printHashtable();
        System.out.println("Getting Yadav "+ht.get("Yadav"));
    }

}

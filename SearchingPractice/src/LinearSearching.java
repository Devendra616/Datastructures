public class LinearSearching {

    public static void main(String[] args) {
        int []arr = {6,-7,48,20,14,32,45,0};

        System.out.println("Item -7 found at :"+linearSearch(arr,-7));
        System.out.println("Item 0 found at :"+linearSearch(arr,0));
        System.out.println("Item 54 found at :"+linearSearch(arr,54));
    }

    private static int linearSearch(int []arr,int item){

        for(int i=0;i<arr.length;i++){
            if(arr[i]== item){
                return i;
            }
        }
        return -1;
    }
}

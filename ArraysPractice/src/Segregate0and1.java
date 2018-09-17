/*
You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array.
Traverse array only once.
Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class Segregate0and1 {

    public static void main(String[] args) {

        int []arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        System.out.println("\nOriginal Array=>");
        printArray(arr);

      //  segreagateArray(arr);
        segregateArray2(arr);

        System.out.println("\nSegregated Array=>");
        printArray(arr);
    }

    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void segreagateArray(int []arr){
        int count0= 0;
        //count the no of 0s
        for(int i:arr){
            if(i==0){
                count0++;
            }
        }
        int i=0;
        for(;i<count0;i++){
            arr[i]=0;
        }
        for(;i<arr.length;i++){
            arr[i]=1;
        }
    }

    public static void segregateArray2(int []arr){
        int index0=0;
        int index1= arr.length-1;

        while(index0<index1){
            if(arr[index0] == 1){
                swap(arr,index0,index1);
                index1--;
            }else {
                index0++;
            }
        }
    }

    private static void swap(int []arr, int i, int j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}

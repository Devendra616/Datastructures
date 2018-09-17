/*
   XOR of all array elements gives us the number with single occurrence. The idea is based on following two facts.
a) XOR of a number with itself is 0.
b) XOR of a number with 0 is number itself.
 */

public class NonRepeatitiveElementXOR {
    public static void main(String[] args) {
        int arr[] = {2,4,2,6,6,4,5,2,2};
        int res = arr[0];

        for(int i=1;i<arr.length;i++){
            res = res ^ arr[i];
        }

        if(res == 0){
            System.out.print("No non repeating element found!");
        }else {
            System.out.println(res);
        }


    }

}
/*
    Time Complexity : O(n)
    Auxiliary Space: O(1)
    Works only if one non repeating element in array
 */
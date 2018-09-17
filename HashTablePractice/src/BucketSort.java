
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Uses hasing
    can sort in O(n)
    Distributes items into bucket based on hashed values
    Sort items in each bucket
    Merge buckets--gathering items
    Values in bucket X must be greater than the values in bucket X-1
    and greater than values in bucket X+1
    Hashing function should put lower value in lower bucket

    Not inplace algo (uses extra space)
    Insertion sort usually used for sorting bucket as it is fast for small numbers of items as in each bucket

 */
public class BucketSort {

    public static void main(String[] args) {
        int []intArray = {45,75,32,52,12,6,42,91,84};
        bucketSort(intArray);

        for(int i=0;i<intArray.length;i++){
            System.out.print(intArray[i]+" ");
        }
    }

    public static void bucketSort(int []arr){
        List<Integer> []buckets = new List[10];

        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }

        int hash;
        for(int i=0;i<arr.length;i++){
            hash = hashKey(arr[i]);
            buckets[hash].add(arr[i]);
        }

//        sort each bucket => default merge sort
        for(List bucket:buckets){
            Collections.sort(bucket);
        }

//        gather items
        int j=0;
        for(int i=0;i<buckets.length;i++){
            for(int value:buckets[i]){
                arr[j++] = value;
            }
        }
    }

    private static int hashKey(int key){
        return key/10;
    }

}

/*
    In this problem we have a Knapsack that has a weight limit W
There are items i1, i2, ..., in each having weight w1, w2, … wn and some benefit (value or profit)
associated with it v1, v2, ..., vn
Our objective is to maximise the benefit such that the total weight inside the knapsack is at most W
And we are also allowed to take an item in fractional part
As main time taking step is sorting, the whole problem can be solved in O(n log n) only.

 */

import java.util.Arrays;

public class FractionalKnapsackProblem {


    public static void main(String[] args) {
        Item[] itemlist = {
                new Item("i1",6,6),
                new Item("i2", 10, 2),
                new Item("i3",  3, 1),
                new Item("i4",  5, 8),
                new Item("i5",  1, 3),
                new Item("i6",  3, 5)
        };

        final int MAX_WEIGHT_LIMIT = 16;

        fractionalKnapsack(itemlist,MAX_WEIGHT_LIMIT,6);

    }

    private static void fractionalKnapsack(Item[] list, int maxWeight, int count){
        int curWeight =0; //weight of knapsack
        float curValue=0;

        Arrays.sort(list);
        System.out.println("Sorted list is");
        for(int i=0;i<count;i++){
            System.out.println(list[i].id+"("+(float)list[i].value/list[i].weight+")");
        }

        for(int i=count-1;i>=0;i--){
            //check if item can be added as whole
            if(curWeight + list[i].weight <=maxWeight){
                curWeight+= list[i].weight;
                curValue += list[i].value;
                System.out.println("Selected "+list[i].id+" Value: "+list[i].value+ " Weight: "+list[i].weight+ " Total Weight: "+curWeight+" Total Value: "+curValue);
            }else { //used only at last stage for fractional part
                float diffWeight = maxWeight-curWeight;
                curWeight += diffWeight;
                float diffValue = diffWeight*list[i].value/list[i].weight;
                curValue += diffValue;
                System.out.println("Selected "+list[i].id+" Value: "+diffValue+ " Weight: "+diffWeight+ " Total Weight: "+curWeight+" Total Value: "+curValue);

                break;
            }
        }

        System.out.println("\n Final Value Covered: "+curValue);
        System.out.println("Final Weight Covered: "+curWeight);

    }
}




  class Item implements Comparable {
    String id;
    int value;
    int weight;

     public Item(String id, int weight, int value) {
         this.id = id;
         this.value = value;
         this.weight = weight;
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public int getValue() {
         return value;
     }

     public void setValue(int value) {
         this.value = value;
     }

     public int getWeight() {
         return weight;
     }

     public void setWeight(int weight) {
         this.weight = weight;
     }


     //if value/weight is more then the item is greater priority
      @Override
      public int compareTo(Object other) {
            Item otherItem = (Item)other;
            float densityThis = (float)this.value/this.weight;
            float densityOther = (float)otherItem.value/otherItem.weight;

            return densityThis> densityOther?1:(densityThis<densityOther?-1:0);
      }


  }
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCodingProblem {
//print the code generated through tree traversal, code is the generated code so far
    public static void printCode(HuffmanNode root,String code){
//base case: if leaf node then print it
        if(root.left == null && root.right==null && Character.isLetter(root.ch)){
            System.out.println("Node: "+root.ch +" Code: "+code);
            return;
        }
//recursively call for left and right subtree adding 0 for left and 1 for right
        if(root.left !=null){
            printCode(root.left,code+"0");
        }
        if(root.right !=null){
            printCode(root.right,code+"1");
        }
    }

    public static void main(String[] args) {

        char []chArray = {'a','b','c','d','e','f'};
        int []freqArray = {5,9,12,13,16,45};

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new MyComparator());
        for(int i=0;i<chArray.length;i++){
            HuffmanNode hn= new HuffmanNode();
            hn.ch= chArray[i];
            hn.freq = freqArray[i];
            hn.left= null;
            hn.right= null;
            pq.add(hn);
        }

//        Create a root node
        HuffmanNode root = new HuffmanNode();
//        extract two min and add to root
        while (pq.size()>1){
            HuffmanNode temp1 = pq.peek();
            pq.poll(); //removes the first min

            HuffmanNode temp2 = pq.peek();
            pq.poll();//removes second min

            //sum of min nodes to be added
            HuffmanNode node = new HuffmanNode();
            node.freq = temp1.freq + temp2.freq;
            node.ch='-';
            node.left=temp1;
            node.right=temp2;

            //making new node as the root
            root = node;
            pq.add(node);
        }

        printCode(root,"");
    }
}

//Each node of Huffman tree
class HuffmanNode{
    int freq;
    char ch;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.freq - o2.freq;
    }
}

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode(int data){
        this.data=data;
    }

//    implementation with no duplicate value
    public void insert(int item){
        if(item == data){
            return;
        }
        if(item<data){
            if(left == null){
                left = new TreeNode(item);
            }else {
                left.insert(item);
            }
        }else {
            if(right == null){
                right= new TreeNode(item);
            }else {
                right.insert(item);
            }
        }
    }

//    Left child->Node->Right Child
    public void traverseInOrder(){
        if(left !=null){
            left.traverseInOrder();
        }
        System.out.print(data+" ,");
        if(right !=null){
            right.traverseInOrder();
        }
    }

//    Left->Right->node
    public void traversePostOrder(){
        if(left !=null){
            left.traversePostOrder();
        }
        if(right !=null){
            right.traversePostOrder();
        }
        System.out.print(data+" ,");
    }

//   Root->Left->Right
    public void traversePreOrder(){
        System.out.print(data+" ,");
        if(left !=null){
            left.traversePreOrder();
        }
        if(right !=null){
            right.traversePreOrder();
        }
    }

    public TreeNode get(int value){
        if(value == data){
            return this;
        }else if(value< data){
            if(left!=null)
                return left.get(value);
        }else {
            if(right!=null)
                return right.get(value);
        }
        return null; //data not found
    }

    public int getMax(){
        if(right == null){
            return data;
        }else {
            return right.getMax();
        }
    }

    public int getMin(){
        if(left == null){
            return data;
        }else {
            return left.getMin();
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String toString() {
        return "Data = " + data;
    }


}

public class Tree {

    private TreeNode root;

    public void insert(int value){
        if(root == null){
            root = new TreeNode(value);
        }else {
            root.insert(value);
        }
    }

    public void traverseInOrder(){
        if(root!=null){
            root.traverseInOrder();
        }
    }

    public void traversePreOrder(){
        if(root!=null){
            root.traversePreOrder();
        }
    }

    public void traversePostOrder(){
        if(root!=null){
            root.traversePostOrder();
        }
    }

    public TreeNode get(int value){
        if(root!=null){
            return root.get(value);
        }else
            return null;
    }

    public int getMax(){
        if(root!=null){
            return root.getMax();
        }else
            return Integer.MAX_VALUE;
    }

    public int getMin(){
        if(root!=null){
            return root.getMin();
        }else
            return Integer.MIN_VALUE;
    }

    public void delete(int value){
        root = delete(root,value);
    }

    //    returns the replacement node
    private TreeNode delete(TreeNode subTreeRoot,int value){
        if(subTreeRoot == null){
            return subTreeRoot;
        }

        if(value < subTreeRoot.getData()){
            subTreeRoot.setLeft(delete(subTreeRoot.getLeft(),value));
        }else if(value > subTreeRoot.getData()){
            subTreeRoot.setRight(delete(subTreeRoot.getRight(),value));
        }
//node to be deleted
        else{
            //handles 0 or 1 child
            if(subTreeRoot.getLeft() == null){
                return subTreeRoot.getRight();
            }else if(subTreeRoot.getRight() == null){
                return subTreeRoot.getLeft();
            }

//            2 children
            //replace value in subtree node with smallest value from right subtree
            subTreeRoot.setData(subTreeRoot.getRight().getMin());
            //delete the node that has smallest value in subtree
            subTreeRoot.setRight(delete(subTreeRoot.getRight(),subTreeRoot.getData()));

            //subTreeRoot.setData(subTreeRoot.left.getMax());
            //subTreeRoot.setLeft(delete(subTreeRoot.left,subTreeRoot.data));

        }

        //if value not in tree
        return subTreeRoot;

    }
}

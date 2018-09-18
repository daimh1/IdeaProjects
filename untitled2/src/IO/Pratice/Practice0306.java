package IO.Pratice;

public class Practice0306 {
    private class TreeNode {
        int item;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(int item, TreeNode lChild, TreeNode rChild) {
            this.item = item;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }
    int loc;
    private TreeNode[] treeNodes=new TreeNode[100];
    char str1[]=new char[25];
    char str2[]=new char[25];
    int size1,size2;
    char str;
    int size;
    public void postOrder(TreeNode T){
        if(T.lChild!=null){
            postOrder(T.lChild);
        }
        if(T.rChild!=null){
            postOrder(T.rChild);
        }
        //str[size++]=T.item+'0';
    }
}

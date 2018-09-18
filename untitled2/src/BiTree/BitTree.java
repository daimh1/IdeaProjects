package BiTree;
import java.util.*;
//import sun.reflect.generics.tree.*;

public class BitTree {
    private TreeNode root;
    public void build(char[] pre,char[] mid){
        root = buildTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode buildTree(char[] pre, int lPre, int rPre, char[] mid, int lMid, int rMid){
          //1 在现需遍历序列中，找到树的根节点
        char root=pre[lPre];
        //2.中序遍历中，查找根节点在中序遍历的位置
        int rootIndex=getRootIndex(mid,lMid,rMid,root);
        if(rootIndex==-1){
            throw new IllegalArgumentException("illegal argument");
        }
        int lNum=(rootIndex-1)-lMid+1;//左子树个数[lMid,rootIndex-1]
        int rNum= rMid-(rootIndex+1)+1;//右子树个数

        //左子树构建
        TreeNode lchild;
        if(lNum==0){
            lchild=null;

        }else {
            //先序数组坐标：根：lpre
            //左子树：lpre+1
            //右子树：lpre+lnum
            lchild=buildTree(pre,lPre+1,lPre+lNum,mid,lMid,rootIndex-1);
        }

        //右子树构建
        TreeNode rchild;
    if(rNum==0){
        rchild=null;
    }else{
        rchild=buildTree(pre,lPre+lNum+1,rPre,mid,rootIndex+1,rMid);
    }

    return new TreeNode(root,lchild,rchild);

    }
    public int getRootIndex(char[] mid,int lMid,int rMid,char root){
        for(int i=lMid;i<=rMid;i++){
            if(mid[i]==root){
                return i;
            }
        }
        return -1;
    }
    //树节点类
    private class TreeNode{
        char item;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(char item, TreeNode lChild, TreeNode rChild) {
            this.item = item;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }
    //三张遍历
    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.item+" ");
            preOrder(root.lChild);
            preOrder(root.rChild);
        }
    }
    public void midOrder(TreeNode root){
        if(root!=null){
            midOrder(root.lChild);
            System.out.print(root.item+" ");
            midOrder(root.rChild);
        }
    }
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.lChild);
            postOrder(root.rChild);
            System.out.print(root.item+" ");
        }
    }
    //广度优先遍历，层次遍历
    public void BFS(){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.remove();

            System.out.print(node.item+" ");
            if(node.lChild!=null){
                queue.add(node.lChild);
            }
            if(node.rChild!=null){
                queue.add(node.rChild);
            }
        }
    }

}

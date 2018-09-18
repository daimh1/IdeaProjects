package BiTree;

public class BiTreeTest {
    public static void main(String[] args) {

        char[] pre = {'A', 'B', 'E', 'K', 'L', 'F', 'D', 'H', 'J'};
        char[] mid = {'K', 'E', 'L', 'B', 'F', 'A', 'H', 'D', 'J'};
        BitTree bitTree = new BitTree();
        bitTree.build(pre, mid);

        //先序遍历
        bitTree.preOrder(bitTree.getRoot());
        System.out.println();
        //中序遍历
        bitTree.midOrder(bitTree.getRoot());
        System.out.println();
        //后序遍历

        bitTree.postOrder(bitTree.getRoot());
        System.out.println();

        bitTree.BFS();
    }
}

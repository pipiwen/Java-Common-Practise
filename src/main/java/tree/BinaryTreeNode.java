package tree;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/14 22:49 <br>
 * @see tree <br>
 */
public class BinaryTreeNode {

    BinaryTreeNode left;
    BinaryTreeNode right;
    Integer value;

    BinaryTreeNode(Integer value) {
        this.value = value;
    }

    //构造一棵树
    public static BinaryTreeNode[] binaryTree() {
        BinaryTreeNode[] binaryTree = new BinaryTreeNode[10];
        // 实例化各节点
        for (int i = 0; i < 10; i++) {
            binaryTree[i] = new BinaryTreeNode(i);
        }
        //构造左右节点
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) {
                binaryTree[i].left = binaryTree[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                binaryTree[i].right = binaryTree[i * 2 + 2];
            }
        }

        return binaryTree;
    }

}

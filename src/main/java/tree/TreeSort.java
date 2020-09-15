package tree;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/14 23:16 <br>
 * @see tree <br>
 */
public class TreeSort {
    //前序遍历(根 -> 左 -> 右)
    public static void preSort(BinaryTreeNode binaryTreeNode) {
        System.out.println(binaryTreeNode.value);
        BinaryTreeNode leftTreeNode = binaryTreeNode.left;
        if (null != leftTreeNode) {
            preSort(leftTreeNode);
        }
        BinaryTreeNode rightTreeNode  = binaryTreeNode.right;
        if (null != rightTreeNode) {
            preSort(rightTreeNode);
        }
    }
    //中序遍历(左->根->右)
    public static void midSort(BinaryTreeNode binaryTreeNode) {
        if (null != binaryTreeNode.left) {
            midSort(binaryTreeNode.left);
        }
        System.out.println(binaryTreeNode.value);
        if (null != binaryTreeNode.right) {
            midSort(binaryTreeNode.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode[] binaryTreeNodes = BinaryTreeNode.binaryTree();
        //preSort(binaryTreeNodes[0]);
        midSort(binaryTreeNodes[0]);
    }
}

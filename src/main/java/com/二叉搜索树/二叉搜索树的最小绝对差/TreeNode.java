package 二叉搜索树.二叉搜索树的最小绝对差;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/3/20
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 验证二叉搜索树
 * <p>
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author yang.shang
 * @create 2018-09-19 15:26
 **/
public class IsValidBST {

    //第一种想法 走递归调用 深度优先搜索 DFS
    //好像无法解决，难点在于判断一个二叉树是否有效，其左子树和右子树的所有节点都需要对比根结点

    //其实可以解决 解决办法是引入上界和下界的概念
    //任何一个结点都需要对比上界和下界，根结点的上界和下界都不存在
    //然后往左走 root.left -> 此时这个结点的上界为根结点，下界不存在
    //再往右走 root.left.right -> 此时这个结点的上界继承父结点 为根结点root 下界为父结点root.left
    //从而遍历整棵树所有节点
    public boolean isValidBST(TreeNode root) {
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max){
        if (root == null)
            return true;
        if (root.val <= min || root.val >=max)
            return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }


    //正确的做法是 利用DFS中序遍历 的性质 先遍历左子树再遍历根结点，再遍历右子树的特性
    //合法的BST中序遍历的顺序 类似一个 升序的链表
    //通过2个结点，依次指向pre cur 然后始终满足pre < cur即可
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return true;
        TreeNode mid = root;
        Integer pre = null;
        while (!stack.isEmpty() || mid != null) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            if (!stack.isEmpty()) {
                mid = stack.pop();
                int cur = mid.val;
                if (pre != null &&pre >= cur)
                    return false;
                pre = cur;
                mid = mid.right;
            }
        }
        return true;
    }


    //复习下二叉搜索树3种DFS遍历方式吧 result索引顺序即为遍历的顺序
    //前序遍历
    public List<TreeNode> leftOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return null;
        stack.push(root);
        TreeNode mid;
        while (!stack.isEmpty()) {
            mid = stack.pop();
            result.add(mid);
            if (mid.right != null)
                stack.push(mid.right);
            if (mid.left != null)
                stack.push(mid.left);
        }
        return result;
    }


    //中序遍历 写了一年....终于写完了
    public List<TreeNode> midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return null;
        TreeNode mid = root;
        while (!stack.isEmpty() || mid != null) {
            while (mid != null && mid.left != null) {
                stack.push(mid);
                mid = mid.left;
            }
            if (mid == null)
                mid = stack.pop();
            if (mid.right != null) {
                result.add(mid);
                mid = mid.right;
            } else {
                result.add(mid);
                mid = null;
            }
        }
        return result;
    }

    //中序遍历 更加简洁的写法
    public List<TreeNode> midOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return null;
        TreeNode mid = root;
        while (!stack.isEmpty() || mid != null) {
            while (mid != null) {
                stack.push(mid);
                mid = mid.left;
            }
            if (!stack.isEmpty()) {
                mid = stack.pop();
                result.add(mid);
                mid = mid.right;
            }
        }
        return result;
    }

    //后序遍历 三种最难的一种，因为顶端节点需要在左子树和右子树都访问完以后才能出栈 即根结点需要访问2次
    //因此需要保存节点的访问状态
    public List<TreeNode> rightOrder(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        //List<TreeNode> result = new IsValidBST().leftOrder(root);
        //List<TreeNode> result = new IsValidBST().midOrder2(root);
        //result.forEach((i) -> System.out.println(i.val));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        boolean k = new IsValidBST().isValidBST2(root2);
        System.out.println(k);
    }

}

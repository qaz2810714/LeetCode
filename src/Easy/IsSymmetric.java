package Easy;

import java.util.*;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
    / \
   2  2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分
 *
 * @author yang.shang
 * @create 2018-09-29 15:31
 **/
public class IsSymmetric {

    //按常理先写迭代再写递归
    //思路 递归对比两个节点的是否相等，相等则递归 (left.left right.right)  (left.right right.left)
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    boolean helper(TreeNode left ,TreeNode right){
        if (left == null && right == null)
            return true;
        if (left !=null && right !=null && left.val == right.val){
            return helper(left.left,right.right) && helper(left.right,right.left);
        }
        return false;
    }

    //迭代分析
    public boolean isSymmetric2(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

package Easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 最大深度
 *
 * @author yang.shang
 * @create 2018-09-19 10:01
 **/
public class MaxDepth {

    //深度优先搜索 利用递归栈 简洁而且优雅，但是利用了递归所以感觉不太好
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //不利用递归栈，额外使用一个栈 同样属于深度优先搜索
    //DFS 如果修改栈的压入顺序将更加符合直觉，先压左子树再压右子树
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack=new Stack<>();
        //想了半天怎么计算最大深度，维护另外一个栈 保存Stack对应节点的深度即可
        Stack<Integer> depth=new Stack<>();
        stack.push(root);
        depth.push(1);
        TreeNode topNode;
        int max=0;
        while (!stack.isEmpty()){
            topNode=stack.pop();
            int value=depth.pop();
            max=Math.max(value,max);
            if (topNode.left != null) {
                stack.push(topNode.left);
                depth.push(value+1);
            }
            if (topNode.right != null) {
                stack.push(topNode.right);
                depth.push(value+1);
            }
        }
        return max;
    }

    //广度优先搜索BFS 对二叉树的每一层进行遍历
    // 利用 队列保存 迭代方式进行
    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        //怎么计算最大深度，构筑另一个队列对应节点队列的节点最大深度就行
        Queue<Integer> depth=new LinkedList<>();
        queue.offer(root);
        depth.offer(1);
        TreeNode curNode;
        int max=0;
        while (!queue.isEmpty()){
            curNode=queue.poll();
            int value=depth.poll();
            max=Math.max(value,max);
            if (curNode.left != null) {
                queue.offer(curNode.left);
                depth.offer(value+1);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                depth.offer(value+1);
            }
        }
        return max;
    }

    //LeetCode上有改进版，与方案4类似，但是不用额外队列维护深度
    public int maxDepth4(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //count代表当前是第几层
        int count = 0;
        while(!queue.isEmpty()) {
            //变量size代表的是当前层有多少个结点
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                size--;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}

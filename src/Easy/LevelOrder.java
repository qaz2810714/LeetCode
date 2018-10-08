package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历
 *
 * @author yang.shang
 * @create 2018-09-19 13:58
 **/
public class LevelOrder {

    //BFS 广度优先搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        //用额外的队列维护
        Queue<TreeNode> queue=new LinkedList<>();
        //结果集
        List<List<Integer>> result=new ArrayList<>();
        if (root == null)
            return result;
        queue.offer(root);
        TreeNode topNode;
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curr=new ArrayList<>(size);
            while (size > 0){
                topNode=queue.poll();
                size--;
                curr.add(topNode.val);
                if (topNode.left != null)
                    queue.offer(topNode.left);
                if (topNode.right != null)
                    queue.offer(topNode.right);
            }
            result.add(curr);
        }
        return result;
    }
}

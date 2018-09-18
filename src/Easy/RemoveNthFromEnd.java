package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第n个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 *
 * @author yang.shang
 * @create 2018-09-17 16:56
 **/
public class RemoveNthFromEnd {

    //最简单的方法即是两次扫描，第一次扫描链表长度L，可得 L-n
    //第二次扫描拿到L-N结点并进行操作
    //难点在于如何通过一次扫描得到结果

    //我的做法是 在第一次扫描时构筑所有节点List 空间换时间 其实也不太好
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next=head.next;
        List<ListNode> nodeList=new ArrayList<>();
        nodeList.add(head);
        while(next != null){
            nodeList.add(next);
            next=next.next;
        }
        ListNode delNode = nodeList.get(nodeList.size() - n);
        if(nodeList.size() > n){
            ListNode preNode = nodeList.get(nodeList.size() - n-1);
            preNode.next=delNode.next;
        }
        else{
            if(delNode.next != null){
                head.val=delNode.next.val;
                head.next=delNode.next.next;
            }
            else{
                head = null;
            }
        }
        return head;
    }

    //看了下LeetCode上的OnePass算法 感觉也一般。。不过比上面的做法好
    //中心思想在于维持2个指针 pre cur
    //在一次循环中，先让pre不动，cur向前推进，直到 cur和pre 的距离为n 时，
    //同时向前推进pre cur,直到cur到末尾，此时pre 即为关键点
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        // Advances cur pointer so that the gap between cur and pre is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            cur = cur.next;
        }
        // Move cur to the end, maintaining the gap
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}

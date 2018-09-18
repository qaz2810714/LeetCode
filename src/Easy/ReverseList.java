package Easy;

/**
 * 反转链表
 *
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 * @author yang.shang
 * @create 2018-09-18 17:29
 **/
public class ReverseList {

    //迭代算法
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre=null;
        ListNode cur=head;
        ListNode after=cur.next;
        while (after != null){
            cur.next = pre;
            pre = cur;
            cur =after;
            after = after.next;
        }
        cur.next=pre;
        return cur;
    }
}

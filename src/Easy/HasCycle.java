package Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 *
 给定一个链表，判断链表中是否有环。

 进阶：
 你能否不使用额外空间解决此题？
 *
 * @author yang.shang
 * @create 2018-09-18 15:38
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        //第一个思路是 遍历链表，对已经遍历过的结点添加到Set中
        //第一种方法会导致空间复杂度的增加
        Set<ListNode> hasContain=new HashSet<>();
        ListNode cur=head;
        while ((!hasContain.contains(cur)) && cur != null){
            hasContain.add(cur);
            cur=cur.next;
        }
        return cur != null;
    }
    //不使用额外空间，则代表必须在原有的链表上进行，修改已经遍历过的val或next值，
    // 虽然可以得到结果,但这种做法太狗屎了
    public boolean hasCycle2(ListNode head) {
        while (head!=null){
            if(head.val == Integer.MIN_VALUE)
                return true;
            head.val=Integer.MIN_VALUE;
            head = head.next;
        }
        return false;
    }

    //最完美的做法
    //把环想象成一个圈 假如圈长为k   如果链表中有环 那必定是从 m   ->  m+k 索引处
    //定义2个指针 奔跑速度不同 一个为1 slow 一个为2 fast
    // 如果有环，则2个指针必定相遇 否则fast或slow必定会为null 代表无环
    // 以下是证明
    //一次迭代总能把两个指针送进环内，假如slow在环的起点时和fast的距离为 s (k > s)
    // 为什么不反着想象一下 想象成是fast在追 slow 其中fast距离slow (k-s)的距离
    //两者速度差为1 故 k-s 时间后就可以相遇
    //这个做法比第一种思路空间复杂度更好,比第二种思路破坏性更低 可以说是很完美了
    public boolean hasCycle3(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

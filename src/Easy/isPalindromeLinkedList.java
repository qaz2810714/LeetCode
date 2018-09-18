package Easy;

/**
 * 回文链表
 *
 * 请判断一个链表是否为回文链表。
 * 回文链表:正向和反向相等

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author yang.shang
 * @create 2018-09-18 11:10
 **/
public class isPalindromeLinkedList {

    //正常做法 转成数组，再通过2个指针遍历数组依次向中间靠拢即可.但明显不是最优解 空间复杂度O(n)
    //这里想到一个办法，但是不知道有没有漏洞  通过结点的val值为int想到能不能通过异或进行 （不能 1133就不是回文数  3311)
    //第二个做法 通过改变结点的next值，反序后半部分的链表是否可行？会造成源链表的改变，好像也不太可行
    //最后想不出来看了下LeetCode，高票回答一就是用的反转一半的链表结构。。。但是高票回答二反对了高票回答一
    //原因就是因为上述的考虑:输入应该是可读的 不应该造成源列表的修改 这里提供反转链表的解决思路
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}

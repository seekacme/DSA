package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }

    /**
     * 非递归（迭代）反转链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null ) return head;

        ListNode newHead = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

}

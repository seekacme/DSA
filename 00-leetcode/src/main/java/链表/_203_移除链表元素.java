package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/comments/
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode cur = first;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return first.next;
    }


}

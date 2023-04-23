import java.util.ArrayList;
import java.util.List;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class off024 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode tail = head.next;
        ListNode h = reverseList(head.next);
        tail.next = head;
        head.next = null;
        return h;
    }
}

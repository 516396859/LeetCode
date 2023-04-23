import java.util.ArrayDeque;

public class off026 {
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> deq = new ArrayDeque<>();
        ListNode p = head;
        while (p!=null){
            deq.addLast(p);
            p = p.next;
        }
        p = head;
        if(!deq.isEmpty()){
            deq.pollFirst();
        }
        while (!deq.isEmpty()){
            ListNode last = deq.pollLast();
            p.next = last;
            p = p.next;

            if(!deq.isEmpty()){
                ListNode first = deq.pollFirst();
                p.next = first;
                p = p.next;
            }
        }
        p.next = null;
    }
}

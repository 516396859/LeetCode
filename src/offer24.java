class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class offer24 {
    public ListNode reverse(ListNode cur ,ListNode pre){
        if(cur==null){
            return pre;
        }
        ListNode res = reverse(cur.next, cur);
        cur.next = pre;
        return res;
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }
}
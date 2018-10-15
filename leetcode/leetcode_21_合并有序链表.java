package leetcode;



public class leetcode_21_合并有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode newHead = null;
        ListNode newTemp = null;
        while (temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                if(newHead==null){
                    newHead=temp1;
                    newTemp=newHead;
                }else {
                    newTemp.next = temp1;
                    newTemp = temp1;
                }
                temp1 = temp1.next;
            }else {
                if(newHead==null){
                    newHead=temp2;
                    newTemp=newHead;
                }else {
                    newTemp.next = temp2;
                    newTemp = temp2;
                }
                temp2 = temp2.next;
            }
        }
        if(temp1!=null && newTemp!=null) newTemp.next = temp1;
        if(temp2!=null && newTemp!=null) newTemp.next = temp2;
        if(temp1!=null && newTemp==null) return temp1;
        if(temp2!=null && newTemp==null) return temp2;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

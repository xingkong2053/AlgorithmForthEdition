package basic.DataAbstraction.Test;

import java.util.*;

/**
 * 合并两个有序链表。
 *
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;

        ListNode head=l1;
        ListNode a=l1;
        ListNode b=l1.next;
        ListNode c=l2;

        while(b!=null){
            if (c==null) return head;

            if(c.val<a.val){
                head=new ListNode(c.val);
                head.next=a;
                c=c.next;
            }
            else if(c.val<b.val){               //c.val>=a.val
                a.next=new ListNode(c.val);
                a.next.next=b;
                a=a.next;
                c=c.next;
            }
            else{                               //c.val>=b.val
                a=b;
                b=b.next;
            }
        }

        a.next=c;

        return head;
    }
}


class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        val=x;
    }
}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}





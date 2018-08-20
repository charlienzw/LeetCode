//Merge with Divide And Conquer

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return helper(lists,0,lists.length-1);
    }
    public ListNode helper(ListNode[] lists,int low,int high)
    {
        if(low==high) return lists[low];
        int mid=(high-low)/2+low;
        return merge(helper(lists,low,mid),helper(lists,mid+1,high));
    }
    public ListNode merge(ListNode l1,ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val)
        {
            l1.next=merge(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}

//Priority Queue

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
        ListNode res=new ListNode(0);
        ListNode p=res;
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null) pq.add(lists[i]);
        }
        while(pq.size()>0)
        {
            ListNode tmp=pq.poll();
            p.next=new ListNode(tmp.val);
            p=p.next;
            tmp=tmp.next;
            if(tmp!=null)
                pq.add(tmp);
        }
        return res.next;
    }
}
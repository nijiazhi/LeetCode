package LinkedList_test;

import java.util.List;

public class RemoveNthNodeFromEndofList {

	public static ListNode removeNthFromFront(ListNode head, int n) {
        int count = 1;
        ListNode tmp = head;
        ListNode pre = null;
        while(tmp != null && count<n){
        	pre = tmp;
        	tmp = tmp.next;//要删除的
        	count++;
        }
        if(pre == null)
        	head = head.next;
        else
        	pre.next = tmp.next;
        
        return head;
    }

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 1;//首尾数，方便求解
		ListNode tmp = head;
		while(tmp!=null){
			tmp = tmp.next;
			count++;
		}
		
		int id = 1;
		tmp = head;
		ListNode pre = null;
		while(tmp!=null && count-id>n){
			pre = tmp;
			tmp = tmp.next;
			id++;
		}
		
		//删除倒数第n个
		if(pre == null)
        	head = head.next;
        else
        	pre.next = tmp.next;

		return head;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
		ListNode a3 = new ListNode(3);a2.next=a3;
		ListNode a4 = new ListNode(4);a3.next=a4;
		ListNode a5 = new ListNode(5);a4.next=a5;
		ListNode a6 = new ListNode(6);a5.next=a6;
		
//		ListNode rs = removeNthFromFront(a1, 2);
		ListNode rs = removeNthFromEnd(a1, 4);
//		ListNode rs = a1;
		
		while( rs!=null ){
			System.out.print(rs.val + " --> ");
			rs = rs.next;
		}
		
	}

}

package LinkedList_test;

public class SwapNodesinPairsTotal {
	
	public static ListNode swapSwapNodesinPairsTotal(ListNode head){

		if(head == null || head.next == null){
	        	return head;
	        }
	        
	        ListNode dummyHead = new ListNode(0);
	        
	        dummyHead.next = head;
	        ListNode cur = dummyHead;
	        ListNode probe = cur.next;
	        while(probe!=null && probe.next!=null){
	            cur.next = probe.next;
	            probe.next = probe.next.next;
	            cur.next.next = probe;
	            cur = probe;
	            probe = probe.next;
	        }
	        return dummyHead.next;
	    }
	
	public static void main(String[] args){ 
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
		ListNode a3 = new ListNode(3);a2.next=a3;
		ListNode a4 = new ListNode(4);a3.next=a4;
		ListNode a5 = new ListNode(5);a4.next=a5;
		ListNode a6 = new ListNode(6);a5.next=a6;
		ListNode a7 = new ListNode(7);a6.next=a7;
		
		
		ListNode rs = swapSwapNodesinPairsTotal(a1);
		while(rs != null){
			System.out.print(rs.val + " --> ");
			rs = rs.next;
		}

	}
}

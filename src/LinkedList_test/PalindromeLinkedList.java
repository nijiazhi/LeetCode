package LinkedList_test;

public class PalindromeLinkedList {

	/*
	 * 	1、遍历整个链表，将链表每个节点的值记录在数组中，再判断数组是不是一个回文数组，时间复杂度为O（n），但空间复杂度也为O（n），不满足空间复杂度要求。

		2、利用栈先进后出的性质，将链表前半段压入栈中，再逐个弹出与链表后半段比较。时间复杂度O（n），但仍然需要n/2的栈空间，空间复杂度为O（n）。

		3、反转链表法，将链表后半段原地翻转，再将前半段、后半段依次比较，判断是否相等，时间复杂度O（n），空间复杂度为O（1）满足题目要求。
	 */
	
	public static boolean isPalindrome(ListNode head){
		return false;
	}
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
		ListNode a3 = new ListNode(3);a2.next=a3;
		ListNode a4 = new ListNode(4);a3.next=a4;
		ListNode a5 = new ListNode(5);a4.next=a5;
		ListNode a6 = new ListNode(6);a5.next=a6;

		System.out.println("test1 : " + isPalindrome(a1));
	}

}

package LinkedList_test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class mergeSortedList {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);
        ListNode tmp = rs;
        while(l1!=null && l2!=null){
        	if(l1.val <= l2.val){
        		tmp.next = l1;
        		l1 = l1.next;
        		tmp = tmp.next;
        	}else{
        		tmp.next = l2;
        		l2 = l2.next;
        		tmp = tmp.next;
        	}
        }
        
        if(l1 == null && l2 != null){
        	tmp.next = l2;
        	l2 = l2.next;
        	tmp = tmp.next;
        }else if(l2 == null && l1!=null){
        	tmp.next = l1;
    		l1 = l1.next;
    		tmp = tmp.next;
        }
        
        return rs.next;
	}
	
	/*
	 * 方法1 --- java中没有指针，记录堆顶元素来自于哪个list不容易，如果用map<int,int>记录对应关系，key会重复；所以堆中每个元素换为一个对象，
	 * 			用对象记录来自于哪个list，以便于指针在lists中的移动。
	 * 
	 *将每个链表的表头元素取出来，建立一个小顶堆，因为k个链表中都排好序了，因此每次取堆顶的元素就是k个链表中的最小值，可以将其合并到合并链表中，
	 *再将这个元素的指针指向的下一个元素也加入到堆中，再调整堆，取出堆顶，合并链表。。。。以此类推，直到堆为空时，链表合并完毕。
	 *建堆的时间复杂度是k/2logk, 每次取出堆顶再加入元素的复杂度是logk,假设每条链表平均有n个元素，则一共有nk-k次。
	 *因此总的时间复杂度为O(nklogk)。
	 *
	 */
	public static ListNode mergeKLists1(ListNode[] lists) {
		
		ListNode rs = new ListNode(0);
        int k = lists.length;
        List<Integer> heap = new ArrayList<>();
        //初始化堆
        for(int i=0; i<k; i++)
        	heap.add(lists[i].val);
        buildMinHeap(heap, k-1);
        
        while(heap.size()!=0){
        	
        }
        
        return rs.next;
    }
	
	public static List<Integer> heapSort_min(List<Integer> data){
		if(data==null || data.size()==0)
			return null;
		
		int len = data.size();
		buildMinHeap(data, len-1);
		//堆排序－－将最后一个节点与第一个节点换位置
		for(int i=len-1; i>0; i--){
			swap(data, 0, i);
			minHeap(data, 0, i-1);
		}
		return data;
	}
	
	//heapSize is lastIndex
	public static void buildMinHeap(List<Integer> data,int heapSize){
		int lastParent = (heapSize-1)/2;
		
		for(int i=lastParent; i>=0; i--){
			minHeap(data, i, heapSize);
		}
	}
	
	public static void swap(List<Integer> data, int index1, int index2){
		int temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}
	
	//调整堆 by data[index]
	public static void minHeap(List<Integer> data, int index, int heapSize){
		int left = index*2 + 1;
		int right = index*2 + 2;
		int min = index;
		
		if(left<=heapSize && data.get(left)<data.get(index))
			min = left;
		
		if(right<=heapSize && data.get(right)<data.get(min))
			min = right;
		
		if(min != index){
			swap(data, min, index);
			minHeap(data, min, heapSize);
		}
	}
	
	 //方法1 --- 改进inJAVA（PriorityQueue）
	
	public static ListNode mergeKLists4(ListNode[] lists) {
		if(lists==null || lists.length==0)
			return null;
		
		ListNode rs = new ListNode(0);
		ListNode head = rs;
		//优先级队列当作heap使用
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
		
		//初始化
		for(ListNode list : lists){
			if(list != null)
				q.offer(list);

		}
		
		while(!q.isEmpty()){
			ListNode tmp = q.poll();
			head.next = tmp;
			head = head.next;
			
			if(tmp.next != null)
				q.offer(tmp.next);
		}
		return rs.next;
	}

	
	/*方法2-－－超时---合并的过程可以调整，不是1、2合并，再去合并3，然后再去合并4； 而是1、2合并，3，4合并，然后最终合并（改进）
	 * 还有一种思路是取出两条，用merge2Lists的方法合并为一条，再将这条和下一条用merge2Lists来合并为一条，
	 * 以此类推。假设每条链表平均有n个元素，此种时间复杂度是O(2n+3n+…+kn), 为O(nk²)
	 * 因此若用此法----超时
	 */
	public static ListNode mergeKLists2(ListNode[] lists) {
		ListNode rs = null;
        rs = merger(rs, lists, 0);  
        return rs;
    }
	
	public static ListNode merger(ListNode rs, ListNode[] lists, int i) {
		if(i == lists.length)
			return rs;
		return merger(mergeTwoLists(rs, lists[i]), lists, i+1);
	}
	
	//方法2-－改进版merger
	public static ListNode mergeKLists3(ListNode[] lists){
		int sz = lists.length;  
		if (sz == 0)  
			return null;  
	  
        while (sz > 1) {
            int k = (sz + 1) / 2;
//        	int k = sz/2+1;//两者有区别
            for (int i = 0; i < sz / 2; i++)  
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);  
            sz = k;  
        }  
        return lists[0];  
	}

	public static void main(String[] args) {
		
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);a1.next=a2;
		ListNode a3 = new ListNode(5);a2.next=a3;
		ListNode a4 = new ListNode(6);a3.next=a4;
		ListNode a5 = new ListNode(12);a4.next=a5;
		ListNode a6 = new ListNode(61);a5.next=a6;
		
		ListNode b1 = new ListNode(0);
		ListNode b2 = new ListNode(7);b1.next=b2;
		ListNode b3 = new ListNode(8);b2.next=b3;
		ListNode b4 = new ListNode(84);b3.next=b4;

//		ListNode rs = mergeTwoLists(a1, b1);
		ListNode[] l = {a1,b1};
		ListNode rs = mergeKLists4(l);
		while(rs != null){
			System.out.print(rs.val + " --> ");
			rs = rs.next;
		}
	
	}
	

}
//
package Sort;


public class heapSort1 {
	
	public static int[] heapSort_min(int data[]){
		if(data==null || data.length==0)
			return null;
		
		int len = data.length;
		buildMinHeap(data, len-1);
		//堆排序－－将最后一个节点与第一个节点换位置
		for(int i=len-1; i>0; i--){
			swap(data, 0, i);
			minHeap(data, 0, i-1);
		}
		return data;
	}
	
	//heapSize is lastIndex
	public static void buildMinHeap(int data[],int heapSize){
		int lastParent = (heapSize-1)/2;
		
		for(int i=lastParent; i>=0; i--){
			minHeap(data, i, heapSize);
		}
	}
	
	public static void swap(int data[], int index1, int index2){
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	//调整堆 by data[index]
	public static void minHeap(int data[], int index, int heapSize){
		int left = index*2 + 1;
		int right = index*2 + 2;
		int min = index;
		
		if(left<=heapSize && data[left]<data[index])
			min = left;
		
		if(right<=heapSize && data[right]<data[min])
			min = right;
		
		if(min != index){
			swap(data, min, index);
			minHeap(data, min, heapSize);
		}
	}
	
	public static void main(String[]  args){
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
				98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51,123,421,1,42,532,12,6456,12 };
		
		int[] result = heapSort_min(a);
		
		if(result != null)
			for(int i=0;i<result.length;i++){
				System.out.print(result[i]+" ");
			}
		System.out.println("\n Done!");
	}
}

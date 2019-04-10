package Sort;

public class HeadSort_minHead { 
	
	public int[] HeadSort_minHead(int[] sortArray){
		
		for(int i=0; i<sortArray.length-1; i++){//剩下最后一个点，不需要计算
		   buildMinHead(sortArray, sortArray.length-1-i);
		   swap(sortArray,0,sortArray.length-1-i);//堆顶和最后一位交换，保留所有堆顶元素，完成排序
		}
		
		return sortArray;
	}
	
	private void buildMinHead(int[] data, int lastIndex) {
		
		int parent = (lastIndex - 1)/2;
		
		for(int i=parent; i>=0; i--){
			int curNode = i;
			
			//leftChild exists;
			while(2*curNode+1 <= lastIndex){
				int smallChild = 2*curNode + 1;//left
				//rightChild exists;
				if(smallChild < lastIndex){
					if(data[smallChild] > data[smallChild-1]){//左面的小
//						swap(data, smallChild, smallChild-1);//可以注释此行或者下一行，此行保证heap里右子节点小于左子节点
						smallChild --;
					}
				}
				if(data[smallChild] < data[curNode]){
					swap(data, smallChild, curNode);
					curNode = smallChild;//更新当前点，进入while循环可以迭代每个min
				}else{
					break;//满足最小堆跳出
				}
			}
		}//end-for
		
	}

	//交换两个数据的方法
	public void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static void main(String args[]){
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
				98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51,123,421,1,42,532,12,6456,12 };
		
//		int a[] = {2,4,12,43,0,41};
		int[] result = new HeadSort_minHead().HeadSort_minHead(a);
		
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}

	}
    
}
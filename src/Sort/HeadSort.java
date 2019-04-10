package Sort;

public class HeadSort { 
	
	public int[] headSort(int[] sortArray){
		
		for(int i=0; i<sortArray.length-1; i++){
		   buildMaxHeap(sortArray, sortArray.length-1-i);
		   swap(sortArray,0,sortArray.length-1-i);
		}
		
		return sortArray;
	}

	
	//交换两个数据的方法
	public void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	//建立大顶堆
	public void buildMaxHeap(int[] data,int lastIndex){
		//从lastIndex节点的父节点开始舰堆
		for(int i=(lastIndex-1)/2; i>=0; i--){
			//保存正在判断的节点
			int k = i;
			//这里为每个节点建立大顶堆,只要这个根节点还有子节点
			while((2*k+1) <= lastIndex){
				//假设左节点的值时最大的
				int biggerIndex = 2*k+1;
				//说明还有右节点是存在的
				if(biggerIndex < lastIndex){
					//选出子节点中最大的值
					if(data[biggerIndex] < data[biggerIndex+1]){
						biggerIndex++;
					}
				}
				//将当前根节点与子节点进行比较
				if(data[k] < data[biggerIndex]){
					swap(data,k,biggerIndex);
					k = biggerIndex;//注释不会影响排序结果，但是中间的堆并不是理论中的最大堆，只是堆顶是全部数据中最大的
				}else{
					break;
				}
			}
		}
	} 

	
	public static void main(String args[]){
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
				98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51,123,421,1,42,532,12,6456,12 };
		
//		int a[] = {2,4,12,43,0,41};
		int[] result = new HeadSort().headSort(a);
		
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}

	}
    
}
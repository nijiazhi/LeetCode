package ContainerWithMostWaterTotal;

public class ContainerWithMostWaterTotal {
	
	//线性时间－－－利用性质。
	/*
	 * 有两个指针i和j分别指向头和尾， 如果a[i]<a[j], 则i++,否则j--:
		证明：
		对任意ｋ<j：
		都有(k-i)*min(a[k],a[i]) < (j-i)min(a[j],a[i]) = (j-i)a[i]
		因为:		(k-i) < (j-i)
		min(a[k],a[i]) < a[i] < min(a[j],a[i])
		所以此种情况移动j只能得到更小的值， 移动j无用， 只能移动i。 反之亦然。
	 */
	
	public static int maxArea1(int[] height) {
		if(height == null)
			return 0;
		int len = height.length;
		int max = 0;
		int left = 0;
		int right = len - 1;
		
		while(left < right){
			int tmp = Math.min(height[left], height[right]) *(right-left);
			if(tmp > max)
				max = tmp;
			
			//使用性质
			if(height[left] > height[right])
				right--;
			else
				left++;
		}
		
		return max;
		
	}
	 
	 public static void main(String[] args){
		 int[] a = {123,12,42,432,434};
		 int rs1 = maxArea1(a);
		 System.out.println("rs1 : "+rs1);
	 }
}

package Sum_3;

import java.util.Arrays;

public class threeSumClosest {
	
    public static int threeSumClosest(int[] nums, int target) {
    	if(nums == null || nums.length < 3)
    		return 0;
    	
    	int len = nums.length;
    	int rs = 0;
    	int min = Integer.MAX_VALUE;
    	Arrays.sort(nums);

    	for(int i=0; i<len; i++){
    		//此时不能考虑去重复，例如｛1，1，1，1｝
//    		if(i+1<len && nums[i] == nums[i+1])
//    			continue;
    		
    		int l = i+1;
    		int r = len - 1;
    		int fix = nums[i];
    		while(l < r){
    			int sum = nums[l] + nums[r] + fix;
    			int dis = Math.abs(sum-target);
    			
    			if(dis == 0)
    				return target;
    			else if(sum > target){
    				r--;
    			}else{
    				l++;
    			}
    			
    			if(dis < min){
					min = dis;
					rs = sum;
				}
    		}//end while
    	}//end for
    	
    	return rs;
    }
	

	public static void main(String[] args) {
//		int[] num = {-1,7,-3,-7,-4,-4,0,3,-2,-10,-10,9};
		int[] num = {1,1,1,1};
		int target = 0;
		int rs1 = threeSumClosest(num,target);
		System.out.println("rs1 : "+rs1);
	}

}

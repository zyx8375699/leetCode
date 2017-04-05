public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
    	int i = 0;
    	while(i < nums.length - 2) {
    		while(i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
    			i++;
    		}
    		int low = i + 1;
    		int high = nums.length - 1;
    		int target = -nums[i];
    		while(low < high) {
        		if(nums[low] + nums[high] == target) {
        			list.add(Arrays.asList(nums[i], nums[low], nums[high]));
        			low++;
        			high--;
        			while(low < high && nums[low] == nums[low - 1]) low++;
        			while(low < high && nums[high] == nums[high + 1]) high--;
        		} else if(nums[high] + nums[low] > target) high--;
        		else low++;
    		}
    		i++;
    	}
    	return list;
    }
}
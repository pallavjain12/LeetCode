class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1]) {
                int value = 0 - nums[i];
                int l = i+1; int r = nums.length - 1;
                while (l < r) {
                    while(l - 1 > i && l < r && nums[l] == nums[l-1]){
                        l += 1; 
                    }
                    while(r + 1 < nums.length && l < r && nums[r] == nums[r + 1]){
                        r -= 1;
                    }
                    int inter = nums[l] + nums[r];
                    if (l < r && inter == value) {
                        ArrayList<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[l]);
                        tempList.add(nums[r]);
                        list.add(tempList);
                        l += 1;
                        r -= 1;
                    }
                    else if (inter < value) {
                        l += 1;
                    }
                    else {
                        r -= 1;
                    }
                }
            }
            else{
                continue;
            }
            
        }
        return list;
    }
}
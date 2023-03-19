class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        
        int ans = 0;
        
        while(left < right)
        {
            int lval = height[left], rval = height[right];
            //System.out.println("left = " + lval + " right = " + rval);
            int min = Math.min(lval, rval);
            int cur = min * (right - left);
            ans = Math.max(ans, cur);
            if(lval <= rval)
                left++;
            else
                right--;
        }
        return ans;
    }
}
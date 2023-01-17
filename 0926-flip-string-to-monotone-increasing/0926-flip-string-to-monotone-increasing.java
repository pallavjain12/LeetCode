class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (ones == 0) {
                    continue;
                }
                else {
                    zeros += 1;
                }
            }
            else {
                ones += 1;
            }
            if (zeros > ones) zeros = ones;
        }
        return zeros;
    }
}
        // if(s.size()==0){
        //     return 0;
        // }
        // int countFlips = 0;
        // int countOnes = 0;
        // for(auto ele:s){
        //     if(ele=='0'){
        //         if(countOnes==0)
        //             continue;
        //         else
        //             countFlips++;
        //     }else{
        //         countOnes++;
        //     }
        //     if(countFlips>countOnes){
        //         countFlips = countOnes;
        //     }
        // }
 
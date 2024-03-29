class Solution {
public:
   //Top-Down Dp(recoursion with memorization)
    int findMinValUsingDP(vector<vector<int>>& costs,int X,int Y,int T,vector<vector<int>>&dp){
        if(costs.size()==T&&!X&&!Y)return 0;
        if(dp[X][Y]!=INT_MAX)return dp[X][Y];
        int minVal = INT_MAX;
        if(X)
            minVal = costs[T][0]+findMinValUsingDP(costs,X-1,Y,T+1,dp);
        if(Y)
            minVal = min(minVal,costs[T][1]+findMinValUsingDP(costs,X,Y-1,T+1,dp));
        return dp [X][Y] = minVal;
    }
    int twoCitySchedCost(vector<vector<int>>& costs){
        vector<vector<int>>dp(costs.size(),vector<int>(costs.size(),INT_MAX));
        return findMinValUsingDP(costs,costs.size()/2,costs.size()/2,0,dp);
    }
};
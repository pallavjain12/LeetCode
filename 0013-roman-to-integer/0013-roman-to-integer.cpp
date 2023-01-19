class Solution {
public:
    int romanToInt(string s) {
        map<char, int> mp;
        mp['I'] = 1;
        mp['V'] = 5;
        mp['X'] = 10;
        mp['L'] = 50;
        mp['C'] = 100;
        mp['D'] = 500;
        mp['M'] = 1000;
        int prev = 3000;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s[i];
            int val = mp[ch];
            if (prev < val) {
                ans += ((val - prev) - prev);
                prev = val;
            }
            else {
                ans += val;
                prev = val;
            }
        }
        return ans;
    }
};
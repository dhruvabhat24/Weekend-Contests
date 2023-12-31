#include <vector> 
 
class Solution { 
public: 
    bool hasTrailingZeros(std::vector<int>& nums) { 
        int cnt = 0; 
        for (auto x : nums) { 
            if (x % 2 == 0) { 
                cnt++; 
            } 
        } 
        if (cnt >= 2) { 
            return true; 
        } 
        return false; 
    } 
};

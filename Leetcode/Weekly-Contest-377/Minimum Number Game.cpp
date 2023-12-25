class Solution {
public:
    vector<int> numberGame(vector<int>& nums) {
    sort(nums.begin(),nums.end());
    vector<int>a;
    vector<int>c;
    for(int i=0;i<nums.size();i++){
        if(i%2==0){
            c.push_back(nums[i]);
        }
        else{
            a.push_back(nums[i]);
        }
    }
        vector<int>b;
        for(int i=0;i<a.size();i++){
        b.push_back(a[i]);
        b.push_back(c[i]);
        }
        return b;
    }
};

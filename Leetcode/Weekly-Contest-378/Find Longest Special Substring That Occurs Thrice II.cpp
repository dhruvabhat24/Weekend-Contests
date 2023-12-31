class Solution { 
public: 
    int maximumLength(string s) { 
        int ans=0; 
        vector<vector<int>>freq(26); 
        for(int i=0;i<s.size();i++) 
        { 
            int j=i; 
            while(j<s.size() and s[j]==s[i])j++; 
            freq[s[i]-'a'].push_back(j-i); 
            i=j-1; 
        } 
        for(auto x:freq) 
        { 
            if(x.empty())continue; 
            sort(x.begin(),x.end()); 
            int sz=x.size(); 
            ans=max(ans,x.back()-2); 
            if(sz>1) 
            { 
                ans=max(ans,min(x[sz-1]-1,x[sz-2])); 
            } 
            if(sz>2) 
            { 
                ans=max(ans,x[sz-3]); 
            } 
        } 
        if(ans==0)ans=-1; 
        return ans; 
    } 
};

#include <bits/stdc++.h>
using namespace std;

int main() {
	
	int t;
    cin>>t;
	while(t--)
	{
	    string s;
	    cin>>s;

	    int i=0,j=s.size()-1;
	    
        bool flag=0;
	    while(i<=j)
	    {
	        if(s[i]==s[j])
	        {
	            if(s[i]=='.')
	            {
	                s[i]=s[j]='a';
	            }
	            i++;
                j--;
	        }
	        else if((s[i]=='.'&&s[j]!='.')||(s[j]=='.'&&s[i]!='.'))
	        {
	            if(s[i]=='.')
	            {
	                s[i]=s[j];
	            }else{
	                s[j]=s[i];
	            }
	        }
	        else if(s[i]!=s[j])
	        {
	            flag=1;
	            break;
	        }
	    }
	    if(flag)s="-1";
	    
	    cout<<s<<endl;
	}
	return 0;
}
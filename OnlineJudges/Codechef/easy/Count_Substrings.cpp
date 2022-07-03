#include<bits/stdc++.h>
using namespace std;


long int fact(long int n){
    if(n == 0 || n == 1) 
        return 1;
    return (n) * fact(n-1);
}

int main()
{
    long int t;
    cin >> t;
    while(t--){
        long int n;
        cin >> n;
        string s;
        cin >> s;
        long long int count = 0;
        sort(s.begin(), s.end(), std::greater<char>());
        long int index = s.find_first_of('0');
        if(index == -1)
            count = n;    
        else
            count = index;
        // long int k, r;
        // r = 2;
        // k = count;
        // long int numerator = (k + r - 1);
        // long int numFact = fact(numerator);
        // long int kFact = fact(k-1);
        // long int rFact = fact(r);

        // long int ans = (numFact) / (rFact * kFact);

        long int ans = ((long long int)count * ((long long int)count + 1))/2 ;

        cout << ans << endl;




    }

    return 0;
}
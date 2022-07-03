#include<bits/stdc++.h>
using namespace std;
 
// Function to return trailing
// 0s in factorial of n
long long int findTrailingZeros(long long int n)
{
 
    // Initialize result
    long long int count = 0;
 
    // Keep dividing n by powers of
    // 5 and update count
    for (int i = 5; n / i >= 1; i *= 5)
        count += n / i;
 
    return count;
}
 
// Driver Code
int main()
{
    long long value;
    long long int no;
    cin >> no;
    while(no--){
        cin >> value;
        cout << findTrailingZeros(value) << endl;
    }
    
}

/*
*
  A simple method is to first calculate factorial of n, then count trailing 0s in the result (We can count trailing 0s by repeatedly dividing the factorial by 10 till the remainder is 0).  
  Will cause issue for bigger nums


    What is prime factorization:
    https://www.youtube.com/watch?v=XGbOiYhHY2c&ab_channel=mathantics


https://www.handakafunda.com/number-of-trailing-zeros/


*/
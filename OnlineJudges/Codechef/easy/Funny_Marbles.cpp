// Fenwick Tree

#include <stdio.h>
#include <iostream>

typedef unsigned long long ull;
const int MAX = 1000001;
// a is the given array, tree is the fenwick tree
ull a[MAX], tree[MAX]={0}, res;
int N, Q, k, p, q;
char M;
using namespace std;

void update(int p, int q){ //o(logn)
    while(p<=N){
        tree[p]+=q;
        p=p&(-p);
    }
}

ull getSum(int n){  // o(logn)
    ull r = 0;
    while(n>0){
        r += tree[n];
        n -= n&(-n);
    }
    return r;
}

int main(){

    cin >>N>>Q;
    for (int i = 1; i <= N; i++)
    {
        cin >> a[i];
        // our tree is empty initially, we want to have the same values as of the array
        // So we update the tree at index i with element a[i]
        update(i, a[i]);
    }
    while(Q--){
        cin >> M;
        cin >> p>>q;
        // we are adding 1 to p because we are using 1 based indexing and question has 0 based.
        p++;
        // q can be value or index based on the value of M
        if(M == 'T'){
            update(p, -q);
        }else if(M == 'G'){
            update(p, q);
        }else{
            // sum

            /*
                1 2  3 4   5 6
            a = 1 4  5 2   6 3
            p = 1 5 10 12 18 21
            Actual Sum [3, 5] = 13 [5 2 6]
            l = 3, r = 5
            getSum(r) - getSum(l-1)


            */
            q++;
            if(p!=1){
                res = getSum(q) - getSum(p-1);
            }else{
                res= getSum(q);
            }
            cout << res << endl;
        }
    }
    
    return 0;
}
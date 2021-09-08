/*
Operations:
He can jump to x+1th block of the same lane.
He can switch gravity quickly and jump to xth block of the other lane.
He can switch gravity and jump to x+1th block of the other lane.

Scenario 1: 
a: . # . # . #
b: # . # . # .

a: # . . . # 
b: . # # # .

We can have a function which takes array and index as the input and returns how many blocks we can move
long int checkNextSafeBlock(int[] a, int pos){
    long int val = -1;
    long int N = a.size();
    while(pos < N && a[pos+1] == '.')
        val = pos + 1;
    return val;
}

long int res = 0;
for( int i=0; i<n; i++){    
    if(a[i] == '.'){
        res = checkNextSafeBlock(&a, i);
        if(res < 0){
            if(b[i+1] == '.' || b[i] == '.'){
                if(b[i+1] == '.'){
                    res = checkNextSafeBlock(&a, i+1);
                }else{
                    res = checkNextSafeBlock(&a, i);
                }

                switch++;
            }
        }else{

        }
    }else if(b[i] == '.'){
        res = checkNextSafeBlock(&a, i);
    }else{
        cout << "No" << endl;
    }
}


while(i<n || j < n)
a[i] == '.'
    a[i+1] == "#"
        switch
            b[j+1] == '.' 
                count++;
                i = j
            elseif
            b[j] == '.'
                count++
            else
            no
b[i] == '.'

else
    No


*/

// Dynamic Approach
#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;
#define LIM 200011
#define INF (LIM<<3)

char L[2][LIM];
int D[2];
int nD[2];
int main() {
    int z;
    scanf("%d", &z);
    while (z--) {
        scanf("%s%s", L[0], L[1]);
        int n = strlen(L[0]);
        D[0] = D[1] = 0;        
        for (int i = 0; i < n; i++) {
            nD[0] = L[0][i] == '#' ? INF : min(D[0], D[1] + 1);
            nD[1] = L[1][i] == '#' ? INF : min(D[1], D[0] + 1);
            D[0] = nD[0];
            D[1] = nD[1];
        }
        int ans = min(D[0], D[1]);
        if (ans >= INF) {
            printf("No\n");
        } else {
            printf("Yes\n%d\n", ans);
        }
    }
}

// greedy approach
#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;
#define LIM 200011
#define INF LIM<<3

char words[2][LIM];
int main() {
    int z;
    scanf("%d", &z);
    while (z--) {
        scanf("%s%s", words[0], words[1]);
        int n = strlen(words[0]);
        int curr = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            bool dirty0 = words[0][i] == '#';
            bool dirty1 = words[1][i] == '#';
            if (dirty0 && dirty1) {
                ans = INF;
                break;
            }
            if (dirty0) {
                if (curr == 0) ans++;
                curr = 1;
            }
            if (dirty1) {
                if (curr == 1) ans++;
                curr = 0;
            }
        }
        if (ans >= INF) {
            printf("No\n");
        } else {
            printf("Yes\n%d\n", ans);
        }
    }
}
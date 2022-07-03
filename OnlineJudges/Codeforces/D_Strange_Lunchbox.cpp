#include<bits/stdc++.h>

using namespace std;

int solve(vector<pair<int, int>> &input, int sumX, int sumY, int idx, int x, int y, int n){

    if(idx == n){
        if(sumX >= x && sumY >= y){
            return 1;
        }else{
            return 0;
        }
    }

    sumX += input.at(idx).first;
    sumY += input.at(idx).second;
    int left = solve(input, sumX, sumY, idx+1, x, y, n);
    

    sumX -= input.at(idx).first;
    sumY -= input.at(idx).second;
    int right = solve(input, sumX, sumY, idx+1, x, y, n);

    return left+right;
}

int main(){
    int n;
    cin >> n;
    int x, y;
    cin >> x >> y;

    vector<pair<int, int>> input;
    for (int i = 0; i < n; i++)
    {
        int a = 0, b= 0;
        cin >> a >> b;
        input.push_back(make_pair(a, b));
    }

    int ans = solve(input, 0, 0, 0, x, y, n);
    cout << ans << endl;
    
    return 0;
}
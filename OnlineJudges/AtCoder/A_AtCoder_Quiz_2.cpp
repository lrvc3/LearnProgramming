#include<bits/stdc++.h>
using namespace std;

int main(){
    int score = 0, points = 0;
    int novice = 40;
    int intermediate = 70;
    int advanced = 90;
    int expert = 90;
    cin >> score;
    if( score >= 0 && score < novice){
        points = novice - score;
        cout << points << endl;
    }else if(score >= novice && score < intermediate){
        points = intermediate - score;
        cout << points << endl;
    }else if(score >= intermediate && score < advanced){
        points = advanced - score;
        cout << points << endl;
    }else if(score >=expert){
       cout << "expert" << endl;
    }
    return 0;
}
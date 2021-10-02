#include<bits/stdc++.h>

using namespace std;

int main(){

    map<int, string> hm;
    hm[1] =  "a";
    hm[2] =  "b";
    hm[3] =  "c";
    hm[4] =  "d";
    hm[5] =  "e";
    hm[6] =  "f";
    hm[7] =  "g";
    hm[8] =  "h";
    hm[9] =  "i";
    hm[10] =  "j";
    hm[11] =  "k";
    hm[12] =  "l";
    hm[13] =  "m";
    hm[14] =  "n";
    hm[15] =  "o";
    hm[16] =  "p";
    hm[17] =  "q";
    hm[18] =  "r";
    hm[19] =  "s";
    hm[20] =  "t";
    hm[21] =  "u";
    hm[22] =  "v";
    hm[23] =  "w";
    hm[24] =  "x";
    hm[25] =  "y";
    hm[26] =  "z";

    int arr[26];
    string output = "";
    for (int i = 0; i < 26; i++)
    {
        int val = 0;
        cin >> val;
        output += hm.at(val);
    }
    cout << output << endl;
    


    return 0;
}
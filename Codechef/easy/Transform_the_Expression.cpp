#include<bits/stdc++.h>
using namespace std;

bool isAlpha(char c){

    if((int(c) <= 122 && int(c) >= 97) || (int(c) <= 90 && int(c) >= 65)) 
        return true;
    return false;
}
bool isOperator(char o){

    if(o == '+' || o == '-' || o == '*' || o == '/' || o == '^')
        return true;
    else
        return false;

}

void printRPNForm(string s){
    if(s.length() == 0)
        return;

    stack<char> st;
    for (int i = 0; i < s.length(); i++)
    {
        if(s.at(i) == '('){
            // continue
        }else if(isAlpha(s.at(i)) ){
            cout << s.at(i);
        }else if(isOperator(s.at(i))){
            st.push(s.at(i));
        }else if(s.at(i) == ')'){
            char res = st.top();
            st.pop();
            cout << res;
        }
    }
    cout <<"\n";    
}


int main(){

    int t;
    cin >> t;
    while (t--)
    {
        string s;
        cin >> s;
        printRPNForm(s);
        
    }
    return 0;
    
}


// Solution from a different guy
// #include<bits/stdc++.h>
// using namespace std;
// typedef vector<int> vi;
// typedef long long ll;
// const int N = 1e5 + 10;
// const int M = 1e9 + 7;

// int pre(char a){
// 	if(a == '^')
// 		return 3;
// 	if(a == '*' || a == '/')
// 		return 2;
// 	if(a == '+' || a == '-')
// 		return 1;
// 	else 
// 		return 0;
// }

// string infix_postfix(string s){
// 	int n = s.size();											 
// 	stack<char> sta;											
// 	string ans;
// 	for(int i = 0; i < n; i++){
// 		if(s[i] >= 'a' && s[i] <= 'z')
// 			ans.push_back(s[i]);
// 		else if(s[i] == '(')
// 			sta.push(s[i]);
// 		else if(s[i] == ')'){
// 			while(sta.top() != '('){
// 				ans.push_back(sta.top()); 
// 				sta.pop();
// 			}
// 			sta.pop();
// 		}
// 		else{
// 			while(!sta.empty() && pre(s[i]) <= pre(sta.top())){
// 				ans.push_back(sta.top());
// 				sta.pop();
// 			}
// 			sta.push(s[i]);
// 		}
// 	}

// 	while(!sta.empty()){
// 		ans.push_back(sta.top());
// 		sta.pop();
// 	}
// 	return ans;
// }

// void test_case(){
// 	string s;
// 	cin >> s;
// 	cout << infix_postfix(s) << "\n";

// }

// int main(){
// 	ios::sync_with_stdio(0);
// 	cin.tie(0);
// 	int t;
// 	cin >> t;
// 	while(t--){
// 		test_case();
// 	}
// 	return 0;
// }

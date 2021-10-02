#include <bits/stdc++.h>
using namespace std;

vector<long long> printMaximumOfSubArray(long long int A[],
        long long int n, long long int k) {

	long long i = 0, j = 0;
	vector<long long> ans;
	deque<long long> list;


	if(k > n){
		ans.push_back(*max_element(A, A+n));
		return ans;		
	}

	while (j < n) {

		// We remove all the elements from the list
		// which are less than the a[j]
		// because it will definitely not be the max
		while(list.size() && list.back() < A[j]){
			list.pop_back();
		}
		list.push_back(A[j]);

		if (j - i + 1 < k) {
			j++;
			continue;
		} else if (j - i + 1 == k) {

			ans.push_back(list.front());
			// remove the calculation for i
			if (A[i] == list.front()) {
				list.pop_front();
			}
			i++;
		}
		j++;
	}
	return ans;

}

int main()
{


#ifndef ONLINE_JUDGE

	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

#endif

	long long int n, k;
	cin >> n;
	long long int A[n];
	for (int i = 0; i < n; ++i)
	{
		long long int val;
		cin >> val;
		A[i] = val;
	}
	cin >> k;

	vector<long long> a = printMaximumOfSubArray(A, n, k);

	for (auto it : a) {
		cout << it << " ";
	}

	return 0;
}


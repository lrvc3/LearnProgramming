#include <bits/stdc++.h>
using namespace std;

vector<long long> printFirstNegativeInteger(long long int A[],
        long long int N, long long int K) {

	long long i = 0, j = 0;
	vector<long long> ans;
	deque<long long> list;
	while (j < N) {

		if (A[j] < 0) {
			list.push_back(A[j]);
		}

		if (j - i + 1 < K) {
			j++;
			continue;
		} else if (j - i + 1 == K) {

			if (list.empty()) {
				ans.push_back(0);
			} else {
				ans.push_back(list.front());
			}

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

	long long int A[5];
	for (int i = 0; i < 5; ++i)
	{
		long long int val;
		cin >> val;
		A[i] = val;
	}

	// long long int A[] = { -8, 2, 3, -6, 10};
	long long int N = 5;
	long long int K = 2;
	vector<long long> a = printFirstNegativeInteger(A, N, K);

	for (auto it : a) {
		cout << it << " ";
	}

	return 0;
}


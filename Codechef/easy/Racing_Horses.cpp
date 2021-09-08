#include <stdio.h>

void swap(long* a, long* b)
{
    long t = *a;
    *a = *b;
    *b = t;
}

int partition (long arr[], int low, int high)
{
    long pivot = arr[high];
    int i = (low - 1);
 
    for (int j = low; j < high; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(long arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
 
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main(void)
{
	int T;
	scanf("%d", &T);

	while(T--)
	{
		int N;
		scanf("%d", &N);

		long A[N];
		for(int i = 0; i < N; ++i)		/* insertion sort */
		{
			scanf("%li", &A[i]);
		}

		quickSort(A, 0, N - 1);

		long minima = A[1] - A[0];
		for(int i = 2; i < N; ++i)
		{
			minima = A[i] - A[i - 1] < minima ? A[i] - A[i - 1] : minima;
		}

		printf("%li\n", minima);
	}

	return 0;
}
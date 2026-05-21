package sorting_algo;


public class insertion_sort 
{
    public void insert(int arr[])
    {
        int n = arr.length, i;
        for (i = 1; i < n; ++i)
            {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        for(i=0;i<n;i++)
        {
            System.err.print(" "+arr[i]);
        }
    }
}

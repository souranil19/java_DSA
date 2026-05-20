package sorting_algo;

public class bubble_sort {
    public void bubble(int[] arr)
    {
        int len=arr.length-1,i,j,temp;
        for(i=0;i<len;i++)
        {
            for (j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) 
                {
                    
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(i=0;i<=len;i++)
        {
            System.err.print(" "+arr[i]);
        }
    }
}

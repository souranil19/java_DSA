package sorting_algo;

public class selection_short {
    public void selection(int[] a)
    {
        int len=a.length-1,i,j,temp;
        for(i=0;i<len;i++)
        {
            int min_idx=i;
            for(j=i+1;j<=len;j++)
            {
                if(a[min_idx]>a[j])
                {
                    min_idx=j;
                }
            }
            temp=a[i];
            a[i]=a[min_idx];
            a[min_idx]=temp;
        }
        for(i=0;i<=len;i++)
        {
            System.err.print(" "+a[i]);
        }
    }
}

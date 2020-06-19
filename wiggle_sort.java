public class wiggle_sort{
    // sort the given array in o(n) time such that arr[0]<arr[1]>arr[2]<arr[3]>........
    // We get the median of the array by randomised quicksort method in o(n)
    // since all elements greater than the median will be greater than all elements smaller than the median
    // place all elements greater than median at odd indices as we want odd to be greater
    // place all elements smaller than median at even indices from the end 
    // place the median element at the remaining indices
    public static void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static int sort(int arr[],int start,int end)
    {
        int pivot_idx=(start+end)/2;
        swap(arr,pivot_idx,end);
        int i=start-1;
        for(int j=start;j<=end-1;j++)
        {
            if(arr[j]<arr[end])
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i+1;
    }
    public static int get_median(int arr[],int start,int end,int k) // k= the median index
    {
        int pivot_idx=sort(arr,start,end);
        if(pivot_idx==k)
        return arr[pivot_idx];
        else if(pivot_idx<k)
        return get_median(arr,pivot_idx+1,end,k);
        else
        return get_median(arr,start,pivot_idx-1,k);
    }
    public static void func(int arr[])
    {
        int median=get_median(arr,0,arr.length-1,arr.length/2);
        Integer temp[]=new Integer[arr.length];
        int odd_idx=1;
        int even_idx=(arr.length%2==0)?(arr.length-2):(arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>median)
            {
                temp[odd_idx]=arr[i];
                odd_idx=odd_idx+2;
            }
            else if(arr[i]<median)
            {
                temp[even_idx]=arr[i];
                even_idx=even_idx-2;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(temp[i]==null)
            temp[i]=median;
            arr[i]=temp[i];
        }
    }
    public static void main(String args[])
    {
        int arr[]={1,3,2,2,3,1};
        func(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
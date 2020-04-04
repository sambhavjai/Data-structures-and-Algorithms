// Given an array with 0,1 and 2
// SOrt the array using constant space and in a single pass
public class sort_012{
    public static void swap(int i,int j,int arr[])
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void func(int arr[])
    {
        //000111.....222
        int low=0,high=arr.length-1,mid=0; // low represents start of 1s
        while(mid<=high)                   // mid represents the start of unknown region
        {                                  // high represents the end of unknown region
            if(arr[mid]==0)
            {
                swap(low,mid,arr);
                low++;
                mid++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else
            {
                swap(mid,high,arr);
                high--;
            }
        }
    }
    public static void main(String args[])
    {
        int arr[]={2,0,2,1,1,0};
        func(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
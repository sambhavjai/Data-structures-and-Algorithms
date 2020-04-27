public class duplicate_number{
    // The given array is of n+1 size and contains integers from 1 to n (both inclusive)
    // There is only 1 repeating element find the repeating element
    public static int func(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int idx=Math.abs(arr[i])-1;
            if(arr[idx]<0)
            return idx+1;
            arr[idx]=-arr[idx];
        }
        return 0;
    }
    public static void main(String args[])
    {
        int arr[]={1,3,4,2,2};
        System.out.println(func(arr));
    }
}
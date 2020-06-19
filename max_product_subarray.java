public class max_product_subarray{
    // Find the max product of any subarray of the given array
    public static int func(int arr[])
    {
        int max_ending=arr[0]; // maximum product value ending at ith index
        int min_ending=arr[0]; // minimum product value ending at ith index this is maintained considering the case that when negative number
        int max_sofar=arr[0];  // is multiplied with another -ve it gives us a +ve number which can be very large
        for(int i=1;i<arr.length;i++)
        {
            int temp=max_ending;
            max_ending=Math.max(arr[i],Math.max(arr[i]*max_ending,arr[i]*min_ending)); // arr[i]*min_ending to consider case for -ve * -ve
            min_ending=Math.min(arr[i],Math.min(arr[i]*min_ending,arr[i]*temp));
            max_sofar=Math.max(max_sofar,max_ending);
        }
        return max_sofar;
    }
    public static void main(String args[])
    {
        int arr[]={2,3,-2,4};
        System.out.println(func(arr));
    }
}
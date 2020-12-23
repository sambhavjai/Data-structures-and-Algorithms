// Check is number of global inversion == local inversions
// For this to happen every global inversion in the array must be a local inversion
// that is if there is an inversion in the array then it must be a local inversion
// We only need to check if the max element found so far is greater than any element beyond current idx +1 
// Since the array always has number between 1-n (n = size of the array) and no number is repeated
// so we only need to check if the max so far is greater than arr[i+2] then a global inversion which is not local exists
public class inversion_1
{
    public static boolean func(int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-2;i++)
        {
            max=Math.max(max,arr[i]);
            if(max>arr[i+2])
            return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        int arr[]={1,2,0};
        System.out.println(func(arr));
    }
}
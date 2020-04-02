// Find peak element in an array
// Peak element is one which is greater than both of its neighbours
public class peak_element{
    // We use a simple binary search for the scenario
    // Each array can be classified into one of the 3 cases
    // 1. It a descending array 2. Ascending array 3. Mixed array
    public static int func(int arr[])
    {
        int l=0,r=arr.length-1;
        while(l<r)
        {
            int mid=(l+r)/2;
            if(arr[mid]>arr[mid+1]) // If descending slope then peak will always be towards left of it and the middle element may be a peak also
            {
                r=mid;
            }
            else
            l=mid+1; // If ascending slope then peak will always be towards its right and middle element cannot be peak so we skip it
        }
        return arr[l];
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,1};
        System.out.println(func(arr));
    }
}
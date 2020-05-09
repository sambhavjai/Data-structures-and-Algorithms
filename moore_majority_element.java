public class moore_majority_element{
    // Find the majority element in the array using constant space
    public static int func(int arr[])
    {
        int count=1; // assume the first element of the array to be the majority element initialise the count to be 1 for first element
        int maj_idx=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[maj_idx]==arr[i]) // if the current element is the majority element then increase the count
            count++; // otherwise decrease the count
            else
            count--;
            if(count==0) // when count becomes 0 assume majority element as the current element
            {
                count=1;
                maj_idx=i;
            }
        }
        // the maj_idx now may have the majority element so we check using another pass and counting its instances
        // if the maj_idx is not majority element then majority element does not exists
        count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==arr[maj_idx])
            count++;
        }
        if(count>arr.length/2) // if count is greater than half the array length then it is the majority element
        return arr[maj_idx];
        return -1; // return -1 if majority element is not found
    }
    public static void main(String args[])
    {
        int arr[]={2,2,1,1,1,2,2};
        System.out.println(func(arr));
    }
}
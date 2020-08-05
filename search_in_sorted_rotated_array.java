public class search_in_sorted_rotated_array{
    // search in a sorted rotated array
    // first we find the pivot index then we perform a binary search in that part of the array only
    public static int pivot(int nums[],int start,int end)
    {
        if(start>end)
            return -1;
        if(start==end)
            return start;
        int mid=(start+end)/2;
        if(mid-1>=0&&nums[mid]<nums[mid-1]) // pivot element will be whose next element is smaller
            return mid-1;
        if(mid+1<nums.length&&nums[mid]>nums[mid+1])
            return mid;
        if(nums[start]<nums[mid])
            return pivot(nums,mid+1,end); // sorted order prevails look towards right
        else
            return pivot(nums,start,mid-1); // sorted order disturbed pivot lies here
    }
    public static int binary_search(int nums[],int start,int end,int target)
    {
        if(start>end)
            return -1;
        int mid=(start+end)/2;
        if(nums[mid]==target)
            return mid;
        if(nums[mid]>target)
            return binary_search(nums,start,mid-1,target);
        else
            return binary_search(nums,mid+1,end,target);
    }
    public static int search(int[] nums, int target) {
        int pivot_idx=pivot(nums,0,nums.length-1);
        if(pivot_idx==-1) // array is not rotated
            return binary_search(nums,0,nums.length-1,target);
        else if(target==nums[pivot_idx])
            return pivot_idx;
        else if(target<nums[0])
            return binary_search(nums,pivot_idx+1,nums.length-1,target);
        else
            return binary_search(nums,0,pivot_idx-1,target);
    }
    public static void main(String args[])
    {
        int arr[]={4,5,6,7,0,1,2};
        int target=1;
        System.out.println(search(arr,target));
    }
}
import java.util.*;
// An inversion denotes how far away is the array from being sorted
// Count the number of inversion in the array whether local or global
// We use a merge sort approach where we count the number of inversions while performing merge sort
// We get the number of inversions in the left and right subarray using recursion
// Then we count the number of inversions due to the merging of the subarrays
public class inversion_2{
    public static int merge(int arr[],int start,int mid, int end)
    {
        int left[]=Arrays.copyOfRange(arr,start,mid+1); // form the left subarray
        int right[]=Arrays.copyOfRange(arr,mid+1,end+1); // form the right subarray
        int i=0,j=0,k=start,inversion=0;
        while(i<left.length && j<right.length)
        {
            if(left[i]<=right[j]) // if left is smaller there will be no inversion
            {
                arr[k++]=left[i++];
            }
            else
            {
                arr[k++]=right[j++];
                inversion=inversion+(mid+1)-(start+i); // if right is smaller then inversions will be equal to all the elements in the left subarray from the current element to the end as all these will be greater than the current element of right
            }
        }
        return inversion;
    }
    public static int func(int arr[],int start,int end)
    {
        if(start>=end)
        return 0;
        int count=0;
        int mid=(start+end)/2;
        count = count + func(arr,start,mid); // get inversions from left
        count = count + func(arr,mid+1,end); // get inversions from right
        count = count + merge(arr,start,mid,end); // get inversions from merge
        return count;
    }
    public static void main(String args[])
    {
        int arr[]={1,20,6,4,5};
        System.out.println(func(arr,0,arr.length-1));
    }
}
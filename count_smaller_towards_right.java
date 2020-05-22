import java.util.*;
public class count_smaller_towards_right{
    // Given an array of integers return the count of numbers smaller than the current number and towards its right
    // we use binary_search in a sorted array to find the position for the current element then add the element at that position
    // count of the index of the element will be the number of elements smaller than it
    // time complexity: o(nlogn)
    public static int binary_search(ArrayList<Integer> temp,int start,int end,int val)
    {
        int mid=(start+end)/2; //calculate mid
        if(start>=end)
        {
            temp.add(mid,val);// if the correct position for current element is found add it to the array and return the idx
            return mid;
        }
        if(temp.get(mid)>val)
        return binary_search(temp,start,mid,val);
        else
        return binary_search(temp,mid+1,end,val);
    }
    public static int[] func(int arr[])
    {
        int ans[]=new int[arr.length];
        ArrayList<Integer> temp=new ArrayList<>();// used to store the elements of the array in a sorted order
        for(int i=arr.length-1;i>=0;i--)
        {
            ans[i]=binary_search(temp,0,temp.size(),arr[i]);// call binary search on all elements of the array and store their answer
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={5,2,6,1};
        int ans[]=func(arr);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
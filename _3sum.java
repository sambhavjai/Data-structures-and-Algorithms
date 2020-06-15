import java.util.*;
public class _3sum{
    // Find the triplets amounting to the target value in the array
    public static ArrayList<ArrayList<Integer>> func(int arr[],int target)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        // Sort the array first then check for each value and correspondingly looping on the remaining values.
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++)
        {
            if(i-1>=0&&arr[i-1]==arr[i]) // check for repetititon to remove repeting answers in the original array
            continue;
            int l=i+1;
            int r=arr.length-1;
            while(l<r)
            {
                if(arr[i]+arr[l]+arr[r]==target)
                {
                    ans.add(new ArrayList<>(Arrays.asList(arr[i],arr[l],arr[r])));
                    while(l<r&&arr[l]==arr[l+1]) // skip if same value is repeated
                    {
                        l++;
                    }
                    while(l<r&&arr[r]==arr[r-1]) // skip if same value is repeated
                    {
                        r--;
                    }
                    l++;
                    r--;
                }
                if(arr[i]+arr[l]+arr[r]<target) // if smaller than target then we need to increase the sum so shift left pointer 
                l++;
                else if(arr[i]+arr[l]+arr[r]>target) // if greater than target we need to decrease the sum so shift the right pointer
                r--;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={-1,0,1,2,-1,-4};
        System.out.println(func(arr,0));
    }
}
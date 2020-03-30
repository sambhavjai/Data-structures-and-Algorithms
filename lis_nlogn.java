// Find the length of longest increasing subsequence in an array in O(nlogn)
import java.util.*;
public class lis_nlogn{
    public static int ceil(int key,ArrayList<Integer> ans)
    {
        int l=0,r=ans.size()-1;
        while(r>l+1)
        {
            int mid=(l+r)/2;
            if(key>=ans.get(mid))
            l=mid;
            else 
            r=mid;
        }
        return r;
    }
    public static int func(int arr[])
    {
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<=ans.get(0))  // if is smaller than the smallest element of current sequence it can a possible start of a new seq
            {
                ans.set(0,arr[i]);
            }
            else if(arr[i]>ans.get(ans.size()-1))   //if it greater than the current end then it can be the new end
            {
                ans.add(arr[i]);
            }
            else
            {
                int ceil=ceil(arr[i],ans); // find the element just greater than the current and replace it
                ans.set(ceil,arr[i]);
            }
        }
        return ans.size();
    }
    public static void main(String args[])
    {
        int arr[]={2,5,3,7,11,8,10,13,6};
        System.out.println(func(arr));
    }
}